package com.ecommerce.catalog.infrastructure.image.mapper;

import org.springframework.stereotype.Component;
import com.ecommerce.catalog.domain.model.image.Image;
import com.ecommerce.catalog.infrastructure.image.persistence.ImageEntity;

@Component
public class MapperEntityModelImage implements IMapperEntityModelImage {

  @Override
  public ImageEntity toEntity(Image image) {
    return ImageEntity.builder()
        .id(image.getId())
        .alt(image.getAlt())
        .extension(image.getExtension())
        .name(image.getName())
        .build();
  }

  @Override
  public Image toModel(ImageEntity imageEntity) {
    return Image.builder()
        .id(imageEntity.getId())
        .alt(imageEntity.getAlt())
        .extension(imageEntity.getExtension())
        .name(imageEntity.getName())
        .build();
  }
  
}
