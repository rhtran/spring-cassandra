package com.raejz.sc.exception.dto;

import lombok.Data;

/**
 *
 */
@Data
public class MessageDTO {

  private String id;
  private int status;
  private String message;
  private String timestamp;
}
