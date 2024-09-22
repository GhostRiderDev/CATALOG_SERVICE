package com.ecommerce.catalog.infrastructure.image.adapter;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.ecommerce.catalog.domain.constant.Constant;
import com.ecommerce.catalog.domain.exception.NotFoundException;
import com.ecommerce.catalog.domain.model.image.Image;
import com.ecommerce.catalog.domain.model.image.port.out.IImageRepository;
import com.ecommerce.catalog.infrastructure.image.dao.IJpaImageRepository;
import com.ecommerce.catalog.infrastructure.image.mapper.IMapperEntityModelImage;
import com.ecommerce.catalog.infrastructure.image.persistence.ImageEntity;

@Service
public class ImagePersistenceAdapter implements IImageRepository {
  private final IJpaImageRepository jpaImageRepository;
  private final IMapperEntityModelImage mapperEntityModelImage;

  public ImagePersistenceAdapter(IJpaImageRepository jpaImageRepository,
      IMapperEntityModelImage mapperEntityModelImage) {
    this.jpaImageRepository = jpaImageRepository;
    this.mapperEntityModelImage = mapperEntityModelImage;
  }

  @Override
  public List<Image> findAll() {
    return jpaImageRepository.findAll()
        .stream()
        .map(mapperEntityModelImage::toModel)
        .toList();
  }

  @Override
  public Image findById(String id) {
    ImageEntity imageDB = jpaImageRepository.findById(id)
        .orElseThrow(() -> new NotFoundException(Constant.IMAGE_NOT_FOUND));
        
    return mapperEntityModelImage.toModel(imageDB);
  }

  @Override
  public Image save(Image image, String fileName) {
    ImageEntity imageEntity = mapperEntityModelImage.toEntity(image);
    imageEntity.setName(fileName);
    ImageEntity imageDB = jpaImageRepository.save(imageEntity);
    return mapperEntityModelImage.toModel(imageDB);
  }

}
