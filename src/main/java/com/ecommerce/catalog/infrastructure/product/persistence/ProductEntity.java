package com.ecommerce.catalog.infrastructure.product.persistence;

import java.util.List;
import com.ecommerce.catalog.infrastructure.brand.persistence.BrandEntity;
import com.ecommerce.catalog.infrastructure.category.persistence.CategoryEntity;
import com.ecommerce.catalog.infrastructure.image.persistence.ImageEntity;
import com.ecommerce.catalog.infrastructure.price.PriceEmbbed;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "\"Product\"")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ProductEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;

  private String name;

  private String description;

  @ManyToOne
  private BrandEntity brand;

  @Transient
  private List<CategoryEntity> categories;

  @Transient
  private List<ImageEntity> images;

  @Embedded
  private PriceEmbbed price;
}
