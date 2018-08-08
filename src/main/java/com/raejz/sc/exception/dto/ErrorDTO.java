package com.raejz.sc.exception.dto;

import java.util.List;
import lombok.Data;

/**
 *
 */
@Data
public class ErrorDTO {

  private int status;
  private String errorCode;
  private String message;
  private List<String> errors;
  private String timestamp;
}
