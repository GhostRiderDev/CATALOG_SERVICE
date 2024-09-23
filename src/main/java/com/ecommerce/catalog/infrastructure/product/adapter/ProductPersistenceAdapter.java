package com.ecommerce.catalog.infrastructure.product.adapter;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Component;
import com.ecommerce.catalog.domain.model.price.Price;
import com.ecommerce.catalog.domain.model.product.Product;
import com.ecommerce.catalog.domain.model.product.port.IProductRepository;
import com.ecommerce.catalog.infrastructure.product.dao.IJpaProductRepostory;
import com.ecommerce.catalog.infrastructure.product.mapper.IMapperProductEntityModel;
import com.ecommerce.catalog.infrastructure.product.persistence.ProductEntity;
import com.ecommerce.catalog.infrastructure.category.dao.IJpaCategoryRepository;
import com.ecommerce.catalog.infrastructure.category.persistence.CategoryEntity;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ProductPersistenceAdapter implements IProductRepository {
  private final IJpaProductRepostory jpaProductRepostory;
  private final IJpaCategoryRepository jpaCategoryRepository;
  private final IMapperProductEntityModel mapperProductEntityModel;

  public ProductPersistenceAdapter(IJpaProductRepostory jpaProductRepostory,
      IMapperProductEntityModel mapperProductEntityModel, IJpaCategoryRepository jpaCategoryRepository) {
    this.jpaProductRepostory = jpaProductRepostory;
    this.mapperProductEntityModel = mapperProductEntityModel;
    this.jpaCategoryRepository = jpaCategoryRepository;
  }

  @Override
  public Product save(Product product, Price price) {
    ProductEntity productEntity = mapperProductEntityModel.toEntity(product, price);
    ProductEntity savedProductEntity = jpaProductRepostory.save(productEntity);
    List<CategoryEntity> categories = product.getCategories().stream().map(category -> {
      return jpaCategoryRepository.findById(category.getId()).orElseThrow();
    }).toList();
    savedProductEntity.setCategories(categories);
    return mapperProductEntityModel.toModel(savedProductEntity);
  }

  @Override
  public Optional<Product> findById(String id) {
    Optional<ProductEntity> productEntity = jpaProductRepostory.findById(id);
    return productEntity.map(mapperProductEntityModel::toModel);
  }

  @Override
  public List<Product> findAll() {
    List<ProductEntity> productEntities = jpaProductRepostory.findAll();
    return productEntities.stream().map(mapperProductEntityModel::toModel).toList();
  }

  
}
