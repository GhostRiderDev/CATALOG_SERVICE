package com.ecommerce.catalog.infrastructure.category.adapter;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.ecommerce.catalog.domain.constant.Constant;
import com.ecommerce.catalog.domain.exception.AlreadyExistException;
import com.ecommerce.catalog.domain.exception.NotFoundException;
import com.ecommerce.catalog.domain.model.category.Category;
import com.ecommerce.catalog.domain.model.category.port.out.ICategoryRepository;
import com.ecommerce.catalog.infrastructure.category.dao.IJpaCategoryRepository;
import com.ecommerce.catalog.infrastructure.category.mapper.IMapperEntityModelCategory;
import com.ecommerce.catalog.infrastructure.category.persistence.CategoryEntity;
import com.ecommerce.catalog.infrastructure.image.dao.IJpaImageRepository;
import com.ecommerce.catalog.infrastructure.image.persistence.ImageEntity;
import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class CategoryPersistenceAdapter implements ICategoryRepository {
  private final IJpaCategoryRepository jpaCategoryRepository;
  private final IMapperEntityModelCategory mapperEntityModelCategory;
  private final IJpaImageRepository jpaImageRepository;

  public CategoryPersistenceAdapter(IJpaCategoryRepository jpaCategoryRepository,
      IMapperEntityModelCategory mapperEntityModelCategory,
      IJpaImageRepository jpaImageRepository) {
    this.jpaCategoryRepository = jpaCategoryRepository;
    this.mapperEntityModelCategory = mapperEntityModelCategory;
    this.jpaImageRepository = jpaImageRepository;
  }

  @Override
  public List<Category> findAll() {
    return jpaCategoryRepository.findAll().stream().map(mapperEntityModelCategory::toModel)
        .toList();
  }

  @Override
  public Category findById(String id) {
    CategoryEntity categoryEntity = jpaCategoryRepository.findById(id)
        .orElseThrow(() -> new NotFoundException(Constant.CATEGORY_NOT_FOUND));
    return mapperEntityModelCategory.toModel(categoryEntity);
  }

  @Override
  public Category save(Category category) {
    ImageEntity imageEntity = jpaImageRepository.findById(category.getImage().getId())
        .orElseThrow(() -> new NotFoundException(Constant.IMAGE_NOT_FOUND));
    
    jpaCategoryRepository.findByName(category.getName())
      .ifPresent(categoryEntity -> {
        throw new AlreadyExistException(Constant.CATEGORY_ALREADY_EXIST);
      });

    jpaCategoryRepository.findByImageId(category.getImage().getId())
      .ifPresent(categoryEntity -> {
        throw new AlreadyExistException(Constant.CATEGORY_WITH_IMAGE_ALREADY_EXIST);
      });  
        

    CategoryEntity categoryEntity = CategoryEntity
        .builder()
        .name(category.getName())
        .image(imageEntity)
        .createdAt(category.getCreatedAt())
        .updatedAt(category.getUpdatedAt())
        .build();

    
    CategoryEntity categoryDB = jpaCategoryRepository.save(categoryEntity);
    return mapperEntityModelCategory.toModel(categoryDB);
  }
  

}
