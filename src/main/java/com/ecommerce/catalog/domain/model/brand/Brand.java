package com.ecommerce.catalog.domain.model.brand;

import java.time.LocalDateTime;

public class Brand {
  private String id;
  private String name;
  private String country;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;


  public Brand(String id, String name, String country, LocalDateTime createdAt,
      LocalDateTime updatedAt) {
    this.id = id;
    this.name = name;
    this.country = country;
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

  public String getCountry() {
    return country;
  }

  public void setCuntry(String country) {
    this.country = country;
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
            ", cuntry='" + country + '\'' +
            ", createdAt=" + createdAt +
            ", updatedAt=" + updatedAt +
            '}';
  }

  public static BrandBuilder builder() {
    return new BrandBuilder();
  }

  public static class BrandBuilder {
    private String id;
    private String name;
    private String country;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    BrandBuilder() {
    }

    public Brand.BrandBuilder id(String id) {
      this.id = id;
      return this;
    }

    public Brand.BrandBuilder name(String name) {
      this.name = name;
      return this;
    }

    public Brand.BrandBuilder country(String country) {
      this.country = country;
      return this;
    }

    public Brand.BrandBuilder createdAt(LocalDateTime createdAt) {
      this.createdAt = createdAt;
      return this;
    }

    public Brand.BrandBuilder updatedAt(LocalDateTime updatedAt) {
      this.updatedAt = updatedAt;
      return this;
    }

    public Brand build() {
      return new Brand(id, name, country, createdAt, updatedAt);
    }

    public String toString() {
      return "Brand.BrandBuilder(id=" + this.id + ", name=" + this.name + ", country=" + this.country + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ")";
    }
  }


}
