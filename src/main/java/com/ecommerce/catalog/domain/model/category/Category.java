package com.ecommerce.catalog.domain.model.category;

import java.time.LocalDateTime;

import com.ecommerce.catalog.domain.model.image.Image;

public class Category {
  private String id;
  private String name;
  private Image image;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
//Intentar no colocar logica en el modelo

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

  @Override
  public String toString() {
    return "Category {" + "id='" + id +
     '\'' + ", name='" + name +
      '\'' + ", image=" + image
        + ", createdAt=" + createdAt +
         ", updatedAt=" + updatedAt + '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;

    Category category = (Category) o;

    if (id != null ? !id.equals(category.id) : category.id != null)
      return false;
    if (name != null ? !name.equals(category.name) : category.name != null)
      return false;
    if (image != null ? image.equals(category.image) : category.image == null)
      return false;
    if (createdAt != null ? !createdAt.equals(category.createdAt) : category.createdAt != null)
      return false;
    return updatedAt != null ? updatedAt.equals(category.updatedAt) : category.updatedAt == null;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (image != null ? image.hashCode() : 0);
    result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
    return result;
  }
}
