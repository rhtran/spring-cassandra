package com.raejz.sc.exception.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

/**
 *
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class TokenDTO {

  private String accessToken;
  private String refreshToken;
  private String tokenType;
}
