package com.ecommerce.catalog.application.dto;

import java.math.BigDecimal;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class CreatePriceDto {
  @DecimalMax(value = "9999999999999.99")
  @DecimalMin(value = "0.01")
  private BigDecimal value;

  
  private String currency;
}
