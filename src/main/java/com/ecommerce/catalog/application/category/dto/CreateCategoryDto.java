package com.ecommerce.catalog.application.category.dto;

import org.hibernate.validator.constraints.UUID;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCategoryDto {
  @NotBlank
  @Size(min = 3, max = 50)
  private String name;

  @NotBlank
  @UUID
  private String imageId;
}
