package com.ecommerce.catalog.domain.model;

import java.math.BigDecimal;
import com.ecommerce.catalog.application.dto.CreatePriceDto;

public class Price {
  private BigDecimal value;
  private String currency;

  public Price() {}
  //Intentar no colocar logica en el modelo
  public Price(BigDecimal value, String currency) {
    this.value = value;
    this.currency = currency;
  }

  public BigDecimal getValue() {
    return value;
  }

  public void setValue(BigDecimal value) {
    this.value = value;
  }

  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  @Override
  public String toString() {
    return "Price{" + "value=" + value + ", currency='" + currency + '\'' + '}';
  }

  public static PriceBuilder builder() {
    return new PriceBuilder();
  }

  public static class PriceBuilder {
    private BigDecimal value;
    private String currency;

    public PriceBuilder value(BigDecimal createPriceDto) {
      this.value = createPriceDto;
      return this;
    }

    public PriceBuilder currency(String currency) {
      this.currency = currency;
      return this;
    }

    public Price build() {
      return new Price(value, currency);
    }
  }
}
