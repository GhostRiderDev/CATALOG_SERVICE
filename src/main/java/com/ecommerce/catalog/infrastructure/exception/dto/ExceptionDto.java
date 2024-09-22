package com.ecommerce.catalog.infrastructure.exception.dto;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ExceptionDto {
  private String message;
  private Integer status;
  private LocalDateTime timestamp;
}
