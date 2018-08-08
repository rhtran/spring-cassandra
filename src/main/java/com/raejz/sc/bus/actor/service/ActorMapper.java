package com.raejz.sc.bus.actor.service;

import com.raejz.sc.bus.actor.model.Actor;
import com.raejz.sc.bus.actor.model.ActorDTO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 *
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ActorMapper {

  ActorDTO toActorDTO(Actor actor);
  Actor fromActorDTO(ActorDTO actorDTO);
  List<ActorDTO> toAccountDTOs(List<Actor> accounts);
}
