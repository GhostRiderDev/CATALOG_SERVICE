package com.ecommerce.catalog.application.dto;

import java.util.List;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.UUID;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class CreateProductDto {
  @NotNull
  @NotBlank
  @Size(min = 3, max = 100)
  private String name;

  @NotNull
  @NotBlank
  @Size(min = 3, max = 1000)
  private String description;


  private CreatePriceDto price;

  @NotNull
  @Length(max = 10, min = 1)
  private List<@UUID String> categoriesId;

  @NotNull
  @NotBlank
  @UUID
  private String brandId;


  @NotNull
  @Length(max = 6, min = 1)
  private List<CreateImageDto> images;

  @NotNull
  @Length(max = 5, min = 1)
  private List<@UUID String> tagsId;
}
