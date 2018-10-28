package com.raejz.sc.bus.common.model;

import com.datastax.driver.mapping.annotations.Column;
import com.google.auto.value.AutoValue;
import java.util.Date;

/**
 *
 */
@AutoValue
public abstract class BaseDoc {

  @Column(name = "create_at")
  public abstract Date getCreateAt();

  @Column(name = "modify_at")
  public abstract Date getModifyAt();

//  static BaseDoc create(Date createAt, Date modifyAt) {
//    return new AutoValue_BaseDoc(createAt, modifyAt);
//  }

//  static Builder builder() {
//    return new AutoValue_BaseDoc.Builder();
//  }

  @AutoValue.Builder
  abstract static class Builder {
    abstract Builder setCreateAt(Date value);
    abstract Builder setModifyAt(Date value);
    abstract BaseDoc build();
  }
}
