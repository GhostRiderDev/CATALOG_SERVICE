package com.ecommerce.catalog.infrastructure.image.persistence;

import com.ecommerce.catalog.domain.model.image.enumerate.ExtensionEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "\"Image\"")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ImageEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;

  @Column(nullable = false, length = 250)
  private String name;

  @Column(nullable = false, length = 200)
  private String alt;

  @Column(nullable = false)
  @Enumerated(EnumType.ORDINAL)
  private ExtensionEnum extension;
}
