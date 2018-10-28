package com.raejz.sc.bus.movie.model;

import com.google.auto.value.AutoValue;
import com.raejz.sc.bus.common.model.BaseDoc;
import java.util.List;

/**
 *
 */
@AutoValue
public class Movie extends BaseDoc {
  private Integer year;
  private String title;
  private String synopsis;
  private List<String> actorIds;
}
