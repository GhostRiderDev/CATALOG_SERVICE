package com.ecommerce.catalog.application.product.dto;

import java.util.List;
import com.ecommerce.catalog.application.brand.dto.BrandDetailsDto;
import com.ecommerce.catalog.application.category.dto.CategoryDetailsDto;
import com.ecommerce.catalog.application.image.dto.ImageDetailsDto;
import com.ecommerce.catalog.domain.model.price.Price;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Builder
@Getter
@Setter
public class ProductDetailsDto {
  private String id;
  private String name;
  private String description;
  private Price price;
  private List<CategoryDetailsDto> categories;
  private BrandDetailsDto brand;
  private List<ImageDetailsDto> images;
}
