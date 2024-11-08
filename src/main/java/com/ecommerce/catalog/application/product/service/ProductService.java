package com.ecommerce.catalog.application.product.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.ecommerce.catalog.application.brand.service.IBrandService;
import com.ecommerce.catalog.application.category.service.ICategoryService;
import com.ecommerce.catalog.application.image.service.IImageService;
import com.ecommerce.catalog.application.product.dto.CreateProductDto;
import com.ecommerce.catalog.application.product.dto.ProductDetailsDto;
import com.ecommerce.catalog.application.product.mapper.IProductMapperDtoModel;
import com.ecommerce.catalog.domain.constant.Constant;
import com.ecommerce.catalog.domain.exception.NotFoundException;
import com.ecommerce.catalog.domain.model.brand.Brand;
import com.ecommerce.catalog.domain.model.category.Category;
import com.ecommerce.catalog.domain.model.image.Image;
import com.ecommerce.catalog.domain.model.product.Product;
import com.ecommerce.catalog.domain.model.product.port.IProductRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductService implements IProductService {

  private final IProductRepository productRepository;
  private final IProductMapperDtoModel productMapper;
  private final ICategoryService categoryService;
  private final IImageService imageService;
  private final IBrandService brandService;

  public ProductService(IProductRepository productRepository, IProductMapperDtoModel productMapper, ICategoryService categoryService, IImageService imageService, IBrandService brandService) {
    this.productRepository = productRepository;
    this.productMapper = productMapper;
    this.categoryService = categoryService;
    this.imageService = imageService;
    this.brandService = brandService;
  }

  @Override
  @Transactional
  public ProductDetailsDto saveProduct(CreateProductDto productDto) {
    List<Category> categories = productDto.getCategoriesId().stream().map((category) -> {
      Category categoryDB = categoryService.findCategoryByIdInternal(category);
      log.info("Category found: {}", categoryDB);
      return categoryDB;
    }).toList();

    List<Image> images = productDto.getImagesIds().stream().map(imageService::findImgByIdInternal).toList();
    Brand brand = brandService.findBrandByIdInternal(productDto.getBrandId());
    Product product = productMapper.toModel(productDto, images, categories, brand);
    Product productSaved = productRepository.save(product, product.getPrice());
    ProductDetailsDto productDetailsDto = productMapper.toDetailsDto(productSaved, categories, images, brand);
    return productDetailsDto;
  }

  @Override
  public ProductDetailsDto findProductById(String id) {
    Product productDB = productRepository.findById(id)
        .orElseThrow(() -> new NotFoundException(Constant.PRODUCT_NOT_FOUND));
    List <Category> categories = productDB.getCategories();
    List <Image> images = productDB.getImages();
    Brand brand = productDB.getBrand();    
    return productMapper.toDetailsDto(productDB, categories, images, brand);
  }

  @Override
  public List<ProductDetailsDto> findAllProducts() {
    var products = productRepository.findAll();
    log.info("Products found: {} *******", products);
    return productRepository.findAll().stream().map(product -> findProductById(product.getId())).toList();
  }
}
