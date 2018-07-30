package com.raejz.sc.bus.actor.model;

import com.datastax.driver.mapping.annotations.Column;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;
import com.raejz.sc.bus.common.model.BaseDoc;
import java.util.Date;
import java.util.UUID;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "actor")
public class Actor extends BaseDoc {
  @NotNull
  @PartitionKey
  private UUID id;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

  @Column(name = "date_of_birth")
  private String birthDate;

  private String bio;
}
