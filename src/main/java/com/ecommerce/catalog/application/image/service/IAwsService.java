package com.ecommerce.catalog.application.image.service;

import org.springframework.web.multipart.MultipartFile;
import com.ecommerce.catalog.domain.model.image.Asset;
import java.io.IOException;
import java.util.List;

public interface IAwsService {

  String uploadFile(MultipartFile file, String fileName);

  String findUrlBlob(String fileName) throws IOException;

  List<Asset> getS3Files(String bucketName) throws IOException;

  byte[] downloadFile(String bucketName, String fileName) throws IOException;

  void moveObject(String bucketName, String fileKey, String destinationFileKey);

  void deleteObject(String bucketName, String fileKey);

}
