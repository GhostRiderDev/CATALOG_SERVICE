package com.ecommerce.catalog.domain.model.category;

import java.time.LocalDateTime;

import com.ecommerce.catalog.domain.model.image.Image;

public class Category {
  private String id;
  private String name;
  private Image image;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;

  public Category() {}

  public Category(String id, String name, Image image, LocalDateTime createdAt,
      LocalDateTime updatedAt) {
    this.id = id;
    this.name = name;
    this.image = image;
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

  public Image getImage() {
    return image;
  }

  public void setImage(Image image) {
    this.image = image;
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

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  @Override
  public String toString() {
    return "Category {" + "id='" + id +
     '\'' + ", name='" + name +
      '\'' + ", image=" + image
        + ", createdAt=" + createdAt +
         ", updatedAt=" + updatedAt + '}';
  }

  public static CategoryBuilder builder() {
    return new CategoryBuilder();
  }

  public static class CategoryBuilder {
    private String id;
    private String name;
    private Image image;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    CategoryBuilder() {}

    public CategoryBuilder id(String id) {
      this.id = id;
      return this;
    }

    public CategoryBuilder name(String name) {
      this.name = name;
      return this;
    }

    public CategoryBuilder image(Image image) {
      this.image = image;
      return this;
    }

    public CategoryBuilder createdAt(LocalDateTime createdAt) {
      this.createdAt = createdAt;
      return this;
    }

    public CategoryBuilder updatedAt(LocalDateTime updatedAt) {
      this.updatedAt = updatedAt;
      return this;
    }

    public Category build() {
      return new Category(id, name, image, createdAt, updatedAt);
    }
  }

 
}
