package com.raejz.sc.bus.movie.model;

import com.google.auto.value.AutoValue;
import java.util.List;

/**
 *
 */
@AutoValue
public class MovieDTO {
  private String title;
  private Integer year;
  private List<String> actorIds;
}
