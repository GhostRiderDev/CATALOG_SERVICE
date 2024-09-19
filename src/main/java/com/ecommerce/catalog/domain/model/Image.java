package com.ecommerce.catalog.domain.model;

import java.time.LocalDateTime;
import com.ecommerce.catalog.domain.enumerate.ExtensionEnum;

public class Image {
  private String id;
  private String url;
  private String alt;
  private ExtensionEnum extension;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;

  public Image() {}

  public Image(String id, String url, String alt, ExtensionEnum extension, LocalDateTime createdAt,
      LocalDateTime updatedAt) {
    this.id = id;
    this.url = url;
    this.alt = alt;
    this.extension = extension;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }

  public String getId() {
    return id;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getAlt() {
    return alt;
  }

  public void setAlt(String alt) {
    this.alt = alt;
  }

  public ExtensionEnum getExtension() {
    return extension;
  }

  public void setExtension(ExtensionEnum extension) {
    this.extension = extension;
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
    return "Image{" + "id='" + id + '\'' + "url='" + url + '\'' + ", alt='" + alt + '\''
        + ", extension=" + extension + '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;

    Image image = (Image) o;

    if (id != null ? !id.equals(image.id) : image.id != null)
      return false;
    if (url != null ? !url.equals(image.url) : image.url != null)
      return false;
    if (alt != null ? !alt.equals(image.alt) : image.alt != null)
      return false;
    return extension == image.extension;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (url != null ? url.hashCode() : 0);
    result = 31 * result + (alt != null ? alt.hashCode() : 0);
    result = 31 * result + (extension != null ? extension.hashCode() : 0);
    return result;
  }
}
