package com.ecommerce.catalog.application.image.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.ecommerce.catalog.domain.model.image.port.out.IAssetRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AwsService implements IAwsService {
  @Value("${spring.cloud.aws.bucket.name}")
  private String bucketName;

  private final IAssetRepository assetRepository;

  public AwsService(IAssetRepository s3Repository) {
    this.assetRepository = s3Repository;
  }

  @Override
  public String uploadFile(MultipartFile file, String fileName) {
    File fileObj = convertMultiPartFileToFile(file);
    return assetRepository.uploadFile(bucketName, fileName, fileObj);
  }

  private File convertMultiPartFileToFile(MultipartFile file) {
    File convertedFile = new File(file.getOriginalFilename());
    try (FileOutputStream fos = new FileOutputStream(convertedFile)) {
      fos.write(file.getBytes());
    } catch (IOException e) {
      log.error("Error converting multipartFile to file", e);
    }
    return convertedFile;
  }

  @Override
  public String findUrlBlob(String fileName) throws IOException {
    return assetRepository.getUrlBlob(bucketName, fileName);
  }

  
}

