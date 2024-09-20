package com.ecommerce.catalog.application.brand.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CreateBrandDto {
  private String name;
  private String country;
}
