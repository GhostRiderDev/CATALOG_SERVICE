package com.ecommerce.catalog.domain.model.image.port.out;

import java.io.File;

public interface IAssetRepository {
  String uploadFile(String bucketName, String fileName, File file);
  String getUrlBlob(String bucketName, String key);
}
