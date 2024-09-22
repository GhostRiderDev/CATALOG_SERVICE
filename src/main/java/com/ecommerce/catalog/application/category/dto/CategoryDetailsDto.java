package com.ecommerce.catalog.application.category.dto;

import com.ecommerce.catalog.application.image.dto.ImageDetailsDto;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDetailsDto {
  private String id;
  private String name;
  private ImageDetailsDto image;
}
