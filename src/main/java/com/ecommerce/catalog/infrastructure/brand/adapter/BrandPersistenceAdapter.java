package com.ecommerce.catalog.infrastructure.brand.adapter;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.ecommerce.catalog.domain.constant.Constant;
import com.ecommerce.catalog.domain.exception.NotFoundException;
import com.ecommerce.catalog.domain.model.brand.Brand;
import com.ecommerce.catalog.domain.model.brand.port.out.IBrandRepository;
import com.ecommerce.catalog.infrastructure.brand.dao.IJpaBrandRepository;
import com.ecommerce.catalog.infrastructure.brand.mapper.IBrandModelEntityMapper;
import com.ecommerce.catalog.infrastructure.brand.persistence.BrandEntity;
import com.ecommerce.catalog.infrastructure.port.KafkaSender;

@Repository
public class BrandPersistenceAdapter implements IBrandRepository {

  private final IJpaBrandRepository jpaBrandRepository;
  private final IBrandModelEntityMapper brandModelEntityMapper;
  private final KafkaSender kafkaSender;

  public BrandPersistenceAdapter(IJpaBrandRepository jpaBrandRepository,
      IBrandModelEntityMapper brandModelEntityMapper, KafkaSender kafkaSender) {
    this.jpaBrandRepository = jpaBrandRepository;
    this.brandModelEntityMapper = brandModelEntityMapper;
    this.kafkaSender = kafkaSender;
  }

  @Override
  public Brand save(Brand brand) {
    kafkaSender.send("catalog.product-check", brand);
    BrandEntity brandEntity = brandModelEntityMapper.toEntity(brand);
    BrandEntity savedBrandEntity = jpaBrandRepository.save(brandEntity);
    return brandModelEntityMapper.toModel(savedBrandEntity);
  }

  @Override
  public Brand findById(String id) {
    BrandEntity brand = jpaBrandRepository.findById(id)
        .orElseThrow(() -> new NotFoundException(Constant.BRAND_NOT_FOUND));
    return brandModelEntityMapper.toModel(brand);
  }

  @Override
  public List<Brand> findAll() {
    return jpaBrandRepository.findAll().stream().map(brandModelEntityMapper::toModel).toList();
  }

}
