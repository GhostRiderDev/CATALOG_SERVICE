package com.ecommerce.catalog.infrastructure.image.dao;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ecommerce.catalog.infrastructure.image.persistence.ImageEntity;

@Repository
public interface IJpaImageRepository extends JpaRepository<ImageEntity, String> {
  Optional<ImageEntity> findById(String id);
}
