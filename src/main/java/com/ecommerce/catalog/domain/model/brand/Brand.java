package com.ecommerce.catalog.domain.model.brand;

import java.time.LocalDateTime;

public class Brand {
  private String id;
  private String name;
  private String cuntry;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;

//Intentar no colocar logica en el modelo
  public Brand() {}

  public Brand(String id, String name, String cuntry, LocalDateTime createdAt,
      LocalDateTime updatedAt) {
    this.id = id;
    this.name = name;
    this.cuntry = cuntry;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCuntry() {
    return cuntry;
  }

  public void setCuntry(String cuntry) {
    this.cuntry = cuntry;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public LocalDateTime getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(LocalDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }

  @Override
  public String toString() {
    return "Brand{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            ", cuntry='" + cuntry + '\'' +
            ", createdAt=" + createdAt +
            ", updatedAt=" + updatedAt +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Brand brand = (Brand) o;

    if (id != null ? !id.equals(brand.id) : brand.id != null) return false;
    if (name != null ? !name.equals(brand.name) : brand.name != null) return false;
    if (cuntry != null ? !cuntry.equals(brand.cuntry) : brand.cuntry != null) return false;
    if (createdAt != null ? !createdAt.equals(brand.createdAt) : brand.createdAt != null) return false;
    return updatedAt != null ? updatedAt.equals(brand.updatedAt) : brand.updatedAt == null;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (cuntry != null ? cuntry.hashCode() : 0);
    result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
    result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
    return result;
  }

}
