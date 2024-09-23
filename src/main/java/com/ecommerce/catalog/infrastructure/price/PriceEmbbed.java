package com.ecommerce.catalog.infrastructure.price;

import java.math.BigDecimal;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PriceEmbbed {
  private BigDecimal value;
  private String currency;
}
