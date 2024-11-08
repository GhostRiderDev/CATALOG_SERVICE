package com.ecommerce.catalog.application.image.service;

import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

public interface IAwsService {

  String uploadFile(MultipartFile file, String fileName);

  String findUrlBlob(String fileName) throws IOException;
}
