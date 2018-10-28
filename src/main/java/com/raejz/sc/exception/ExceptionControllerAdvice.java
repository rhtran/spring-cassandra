package com.raejz.sc.exception;

import com.raejz.sc.exception.dto.ErrorDTO;
import java.sql.Timestamp;
import java.time.Clock;
import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 *
 */
@ControllerAdvice
public class ExceptionControllerAdvice {

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorDTO> exceptionHandler(Exception ex) {
    ErrorDTO response = new ErrorDTO();
    response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
    response.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
    response.setMessage(ex.getMessage());
    response.setTimestamp(Timestamp.valueOf(LocalDateTime.now(Clock.systemUTC())).toString());

    return new ResponseEntity<>(response, HttpStatus.OK);
  }
}
