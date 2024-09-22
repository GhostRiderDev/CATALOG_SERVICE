package com.ecommerce.catalog.domain.model.image.enumerate;

public enum ExtensionEnum {
  PNG, JPG, JPEG, GIF;

  public static ExtensionEnum getExtension(String extension) {
    for (ExtensionEnum ext : ExtensionEnum.values()) {
      if (ext.name().equalsIgnoreCase(extension)) {
        return ext;
      }
    }
    return null;
  }
}
