package com.ecommerce.catalog.infrastructure.image.controller;

import java.io.IOException;
import java.util.List;
import org.apache.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ecommerce.catalog.application.image.dto.CreateImageDto;
import com.ecommerce.catalog.application.image.dto.ImageDetailsDto;
import com.ecommerce.catalog.application.image.service.IImageService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/images")
@Slf4j
public class ImageController {
  private final IImageService imageService;

  public ImageController(IImageService imageService) {
    this.imageService = imageService;
  }

  @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
  public ResponseEntity<ImageDetailsDto> uploadImage(@ModelAttribute CreateImageDto imageDto) {
    return ResponseEntity.status(HttpStatus.SC_CREATED).body(imageService.uploadImage(imageDto));
  }

  @GetMapping("/all")
  public ResponseEntity<List<ImageDetailsDto>> findAllImages() {
    return ResponseEntity.ok(imageService.findAllImages());
  }

  @GetMapping("/{id}")
  public ResponseEntity<ImageDetailsDto> findImageById(String id) throws IOException {
    return  ResponseEntity.ok(imageService.findImageById(id)); 
  }

}
