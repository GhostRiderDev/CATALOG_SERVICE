package com.ecommerce.catalog.infrastructure.product.dao;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ecommerce.catalog.infrastructure.product.persistence.ProductEntity;

@Repository
public interface IJpaProductRepostory extends JpaRepository<ProductEntity, String> {
  Optional<ProductEntity> findByName(String name);
}
