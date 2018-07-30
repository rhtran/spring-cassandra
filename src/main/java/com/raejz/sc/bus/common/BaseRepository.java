package com.raejz.sc.bus.common;

import com.datastax.driver.core.Session;
import com.datastax.driver.mapping.MappingManager;
import com.raejz.sc.bus.common.model.BaseDoc;
import java.sql.Timestamp;
import java.time.Clock;
import java.time.LocalDateTime;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 */
@Repository
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BaseRepository {

  @NonNull
  protected Session session;

  @NonNull
  protected MappingManager mappingManager;

  public BaseRepository() {
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
