package com.ecommerce.catalog.application.price.dto;

import java.math.BigDecimal;
import com.ecommerce.catalog.domain.constant.Constant;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class PriceDto {
  @DecimalMax(value = Constant.MAX_PRICE_VALUE)
  @DecimalMin(value = Constant.MIN_PRICE_VALUE)
  private BigDecimal value;

  private String currency;
}
