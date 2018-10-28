package com.raejz.sc.bus.actor.service;

import com.raejz.sc.bus.actor.model.Actor;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class ActorService {

  @Autowired
  private final ActorRepository actorRepository;

  /**
   * Retrieve actor by actor id.
   *
   * @param id actor id
   * @return retrieve actor
   */
  public Actor getActorById(UUID id) {
    if (id != null) {
      return actorRepository.findById(id);
    }

    return null;
  }

  public Actor add(Actor actor) {

    return null;
  }

  public Actor update(Actor actor) {

    return null;
  }
}
