package com.ecommerce.catalog.application.image.dto;

import com.ecommerce.catalog.domain.model.image.enumerate.ExtensionEnum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ImageDetailsDto {
  private String id;
  private String url;
  private String alt;
  private ExtensionEnum extension;
}
