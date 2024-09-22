package com.ecommerce.catalog.infrastructure.cfg;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;

@Configuration
public class StorageConfig {
  @Value("${spring.cloud.aws.credentials.accessKey}")
  private String accessKey;

  @Value("${spring.cloud.aws.credentials.secretKey}")
  private String secretKey;

  @Value("${spring.cloud.aws.region.static}")
  private String region;

  @Bean
  public AmazonS3 amazonS3Client() {
    AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);
    return AmazonS3Client.builder()
        .withCredentials(new AWSStaticCredentialsProvider(credentials))
        .withRegion(region)
        .build();
  }

}
