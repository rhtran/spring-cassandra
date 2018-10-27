package com.raejz.sc.bus.actor.service;

import static com.datastax.driver.core.querybuilder.QueryBuilder.eq;
import static com.datastax.driver.core.querybuilder.QueryBuilder.set;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.ResultSetFuture;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.Statement;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.mapping.Mapper;
import com.datastax.driver.mapping.MappingManager;
import com.datastax.driver.mapping.Result;
import com.raejz.sc.bus.actor.model.Actor;
import com.raejz.sc.bus.common.BaseRepository;
import com.raejz.sc.config.Table;
import com.raejz.sc.exception.DuplicatedException;
import java.util.UUID;
import lombok.Builder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 */
@Repository
public class ActorRepository extends BaseRepository {
  private static final Logger logger = LoggerFactory.getLogger(ActorRepository.class);

  private Mapper<Actor> mapper;

  /**
   * Base constructor.
   *
   * @param session Cassandra session
   * @param mappingManager object mapper manager
   */
  @Builder
  @Autowired
  public ActorRepository(Session session, MappingManager mappingManager) {
    super(session, mappingManager);
    mapper = mappingManager.mapper(Actor.class);
  }

  /**
   * Search account by id
   *
   * @param id universal unique id
   * @return Account
   */
  public Actor findById(UUID id) {
    Statement stmt = QueryBuilder
        .select("id", "first_name", "last_name", "date_of_birth", "bio",
            "create_at", "modify_at")
        .from(Table.ACTOR.getTableName())
        .where(eq("id", id)).setFetchSize(1);

    ResultSetFuture future = session.executeAsync(stmt);

    try {
      ResultSet resultSet = future.get();
      Result<Actor> result = mapper.map(resultSet);
      return result.one();
    } catch (Exception e) {
      logger.error("No account return: " + e);
      return null;
    }
  }

  /**
   * update if exists; otherwise insert
   * @param actor
   * @return
   */
  private Actor save(Actor actor) {
    Statement cqlStmt = QueryBuilder.update(Table.ACTOR.name())
        .with(set("first_name", actor.getFirstName()))
        .and(set("last_name", actor.getLastName()))
        .and(set("modify_at", actor.getModifyAt()))
        .and(set("create_at", actor.getCreateAt()))
        .where(eq("id", actor.getId()));

    try {
      session.executeAsync(cqlStmt);
      return actor;
    } catch (Exception e) {
      logger.warn(
          String.format("Fail to save actor name: %s because %s", actor.getId(), e.getMessage()));
      return null;
    }
  }

  public Actor insert(Actor actor) {
    logger.info(String.format("Insert new actor: %s.", actor.getId()));

    Actor existedActor = findById(actor.getId());

    if (existedActor != null) {
      String message = String.format("The actor id: %s already existed.", actor.getId());
      logger.info(message);
      throw new DuplicatedException(message);
    }

    add(actor);
    return save(actor);
  }

  public Actor update(Actor actor) {

    return null;
  }

}
