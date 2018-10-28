package com.raejz.sc.bus.actor.model;

import com.datastax.driver.mapping.annotations.Column;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;
import com.google.auto.value.AutoValue;
import com.raejz.sc.bus.common.model.BaseDoc;
import java.util.UUID;
import javax.validation.constraints.NotNull;

/**
 *
 */
@AutoValue
@Table(name = "actor")
public abstract class Actor extends BaseDoc {
  @NotNull
  @PartitionKey
  public abstract UUID getId();

  @Column(name = "first_name")
  public abstract String getFirstName();

  @Column(name = "last_name")
  public abstract String getLastName();

  @Column(name = "date_of_birth")
  public abstract String getBirthDate();

  public abstract String getBio();

  @AutoValue.Builder
  public abstract static class Build extends BaseDoc {
    abstract Actor setId(UUID id);
    abstract Actor setFirstname(String firstName);
    abstract Actor setLastName(String lastName);
    abstract Actor setBirthDate(String birthDate);
    abstract Actor setBio(String bio);

  }
}
