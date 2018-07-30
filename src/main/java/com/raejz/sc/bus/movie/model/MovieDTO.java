package com.raejz.sc.bus.movie.model;

import java.util.List;
import lombok.Data;

/**
 *
 */
@Data
public class MovieDTO {
  private String title;
  private Integer year;
  private List<String> actorIds;
}
