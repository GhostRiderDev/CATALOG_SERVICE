package com.ecommerce.catalog.application.image.dto;

import org.hibernate.validator.constraints.URL;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class CreateImageDto {

  @NotBlank
  @URL
  private String url;


  @NotBlank
  @Size(min = 3, max = 100)
  private String alt;

  @NotBlank
  @Size(min = 3, max = 6, message = " minimo 3 maximo 6")
  private String extension;
}
