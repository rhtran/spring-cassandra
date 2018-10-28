package com.raejz.sc.bus.actor;

import com.raejz.sc.bus.actor.model.Actor;
import com.raejz.sc.bus.actor.model.ActorDTO;
import com.raejz.sc.bus.actor.service.ActorMapper;
import com.raejz.sc.bus.actor.service.ActorService;
import com.raejz.sc.config.API;
import com.raejz.sc.exception.DuplicatedException;
import java.util.UUID;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

/**
 *
 */
@RestController
@RequestMapping(value = API.V1 + "/actors")
public class ActorController {
  private static final Logger logger = LoggerFactory.getLogger(ActorController.class);

  @Autowired
  private final ActorService actorService;

  @Autowired
  private final ActorMapper actorMapper;

  @GetMapping(value = "/{id}",
      produces = MediaType.APPLICATION_JSON_VALUE)
  public DeferredResult<ResponseEntity<?>> getActorById(@PathVariable String id) {
    DeferredResult<ResponseEntity<?>> deferredResult = new DeferredResult<>();

    Actor actor = actorService.getActorById(UUID.fromString(id));
    if (actor == null) {
      ResponseEntity<?> responseEntity = new ResponseEntity<>("{}", HttpStatus.OK);
      deferredResult.setResult(responseEntity);
    } else {
      deferredResult.setResult(ResponseEntity.ok(actorMapper.toActorDTO(actor)));
    }

    return deferredResult;
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public DeferredResult<ResponseEntity<?>> createActor(
      @Valid @RequestBody ActorDTO actorDTO) {
    DeferredResult<ResponseEntity<?>> deferredResult = new DeferredResult<>();
    Actor actor = actorMapper.fromActorDTO(actorDTO);
    Actor newActor = actorService.add(actor);

    try {
      if (newActor == null) {
        logger.info(String.format("Actor id: %s or name: %s is not found", actor.getId(), actor.getFirstName()));
        ResponseEntity<?> responseEntity = new ResponseEntity<>("{}", HttpStatus.OK);
        deferredResult.setResult(responseEntity);
      } else {
        deferredResult.setResult(ResponseEntity.ok(actorMapper.toActorDTO(actor)));
      }
    } catch (DuplicatedException ex) {
      logger.info(ex.getMessage());
      throw ex;
    }

    return deferredResult;
  }
}
