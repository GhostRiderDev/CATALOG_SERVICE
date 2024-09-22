package com.ecommerce.catalog.infrastructure.category.dao;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ecommerce.catalog.infrastructure.category.persistence.CategoryEntity;

@Repository
public interface IJpaCategoryRepository extends JpaRepository<CategoryEntity, String> {
  Optional<CategoryEntity> findByName(String name);
  Optional<CategoryEntity> findById(String id);
  Optional<CategoryEntity> findByImageId(String imageId);
}
