package com.raejz.sc.bus.common;

import com.datastax.driver.core.Session;
import com.datastax.driver.mapping.MappingManager;
import com.raejz.sc.bus.common.model.BaseDoc;
import java.sql.Timestamp;
import java.time.Clock;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 */
@Repository
public class BaseRepository {

  protected Session session;
  protected MappingManager mappingManager;

  @Autowired
  public BaseRepository(Session session, MappingManager mappingManager) {
    this.session = session;
    this.mappingManager = mappingManager;
  }

  public void add(BaseDoc baseDoc) {
    Timestamp iso8601 = Timestamp.valueOf(LocalDateTime.now(Clock.systemUTC()));
    baseDoc.setCreateAt(iso8601);
    baseDoc.setModifyAt(iso8601);
  }

  public void modify(BaseDoc baseDoc) {
    baseDoc.setModifyAt(Timestamp.valueOf(LocalDateTime.now(Clock.systemUTC())));
  }
}
