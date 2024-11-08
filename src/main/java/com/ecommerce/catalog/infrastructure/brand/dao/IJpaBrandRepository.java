package com.ecommerce.catalog.infrastructure.brand.dao;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ecommerce.catalog.infrastructure.brand.persistence.BrandEntity;

@Repository
public interface IJpaBrandRepository extends JpaRepository<BrandEntity, String> {

  Optional<BrandEntity> findById( String id);
}
