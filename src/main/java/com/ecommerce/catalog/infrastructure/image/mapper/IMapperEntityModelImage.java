package com.ecommerce.catalog.infrastructure.image.mapper;

import com.ecommerce.catalog.domain.model.image.Image;
import com.ecommerce.catalog.infrastructure.image.persistence.ImageEntity;

public interface IMapperEntityModelImage {
  ImageEntity toEntity(Image image);
  Image toModel(ImageEntity imageEntity);
}
