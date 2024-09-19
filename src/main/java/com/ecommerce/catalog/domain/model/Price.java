package com.ecommerce.catalog.domain.model;

import java.math.BigDecimal;

public class Price {
  private BigDecimal value;
  private String currency;

  public Price() {
  }

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
    return "Price{" +
            "value=" + value +
            ", currency='" + currency + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Price price = (Price) o;

    if (value != null ? !value.equals(price.value) : price.value != null) return false;
    return currency != null ? currency.equals(price.currency) : price.currency == null;
  }

  @Override
  public int hashCode() {
    int result = value != null ? value.hashCode() : 0;
    result = 31 * result + (currency != null ? currency.hashCode() : 0);
    return result;
  }
}
