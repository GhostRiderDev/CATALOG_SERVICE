package com.ecommerce.catalog.infrastructure.exception;

import java.time.LocalDateTime;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.ecommerce.catalog.domain.exception.AlreadyExistException;
import com.ecommerce.catalog.domain.exception.NotFoundException;
import com.ecommerce.catalog.infrastructure.exception.dto.ExceptionDto;


@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(NotFoundException.class)
  public ResponseEntity<ExceptionDto> handleNotFoundException(NotFoundException exception) {
    ExceptionDto exceptionDto = ExceptionDto.builder()
        .message(exception.getMessage())   
        .status(404)
        .timestamp(LocalDateTime.now())
        .build();
        
    return ResponseEntity.status(404).body(exceptionDto);
  }

  @ExceptionHandler(AlreadyExistException.class)
  public ResponseEntity<ExceptionDto> handleAlreadyExistException(AlreadyExistException exception) {
    ExceptionDto exceptionDto = ExceptionDto.builder()
        .message(exception.getMessage())
        .status(409)
        .timestamp(LocalDateTime.now())
        .build();
        
    return ResponseEntity.status(409).body(exceptionDto);
  }

}
