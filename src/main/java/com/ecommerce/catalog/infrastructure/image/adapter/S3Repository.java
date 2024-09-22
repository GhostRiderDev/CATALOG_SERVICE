package com.ecommerce.catalog.infrastructure.image.adapter;

import java.io.File;
import java.net.URL;
import java.util.Date;
import org.springframework.stereotype.Repository;
import com.amazonaws.HttpMethod;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.ecommerce.catalog.domain.model.image.port.out.IAssetRepository;
import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class S3Repository implements IAssetRepository {

  private final AmazonS3 s3Client;

  public S3Repository(AmazonS3 s3Client) {
    this.s3Client = s3Client;
  }


  public String uploadFile(String bucketName, String fileName, File fileObj) {
    s3Client.putObject(new PutObjectRequest(bucketName, fileName, fileObj));
    fileObj.delete();
    return generateFileUrl(bucketName, fileName);
  }

  public String generateFileUrl(String bucketName, String fileName) {
    Date expiration = new Date();
    long expTimeMillis = expiration.getTime();
    expTimeMillis += 1000 * 60 * 60; // 1 hour
    expiration.setTime(expTimeMillis);

    GeneratePresignedUrlRequest generatePresignedUrlRequest =
        new GeneratePresignedUrlRequest(bucketName, fileName).withMethod(HttpMethod.GET)
            .withExpiration(expiration);
    URL url = s3Client.generatePresignedUrl(generatePresignedUrlRequest);
    return url.toString();
  }


 


  @Override
  public String getUrlBlob(String bucketName, String key) {
    String urlGenerated = generateFileUrl(bucketName, key);
    return urlGenerated;
  }
}
