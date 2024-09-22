// package com.ecommerce.catalog.application.product.mapper;

// import java.util.List;
// import com.ecommerce.catalog.application.image.dto.CreateImageDto;
// import com.ecommerce.catalog.application.price.dto.CreatePriceDto;
// import com.ecommerce.catalog.application.product.dto.CreateProductDto;
// import com.ecommerce.catalog.application.product.dto.ProductDetailsDto;
// import com.ecommerce.catalog.domain.model.image.Image;
// import com.ecommerce.catalog.domain.model.image.enumerate.ExtensionEnum;
// import com.ecommerce.catalog.domain.model.price.Price;
// import com.ecommerce.catalog.domain.model.product.Product;

// public class ProductMapper implements IProductMapper {

//   @Override
//   public Product toModel(CreateProductDto createProductDto, String id) {
//     Price price = Price
//         .builder()
//         .value(createProductDto.getPrice().getValue())
//         .currency(createProductDto.getPrice().getCurrency())
//         .build();

//     List<Image> images = createProductDto
//           .getImages()
//           .stream()
//           .map(image -> Image
//             .builder()
//             .url(image.getUrl())
//             .alt(image.getAlt())
//             .extension(ExtensionEnum.valueOf(image.getExtension()))
//             .build())
//           .toList();

//     return Product
//             .builder()
//             .id(id)
//             .name(createProductDto.getName())
//             .description(createProductDto.getDescription())
//             .price(price)
//             .images(images)
//             .build();
//   }

//   @Override
//   public CreateProductDto toDto(Product product) {
//     List<CreateImageDto> imagesDto = product.getImages()
//     .stream()
//     .map(image -> CreateImageDto
//           .builder()
//           .url(image.getUrl())
//           .alt(image.getAlt())
//           .extension(image.getExtension().name())
//           .build())
//     .toList();


//     CreatePriceDto priceDto = CreatePriceDto
//         .builder()
//         .value(product.getPrice().getValue())
//         .currency(product.getPrice().getCurrency())
//         .build();  

//     return CreateProductDto.builder()
//       .name(product.getName())
//       .description(product.getDescription())
//       .price(priceDto)
//       .images(imagesDto)
//           .build();
//   }

//   @Override
//   public ProductDetailsDto toDetailsDto(Product product) {
//     List<String> categoriesId = product.getCategories()
//     .stream()
//     .map(category -> category.getId())
//     .toList();



//     List<CreateImageDto> imagesDto = product.getImages()
//     .stream()
//     .map(image -> CreateImageDto
//           .builder()
//           .url(image.getUrl())
//           .alt(image.getAlt())
//           .extension(image.getExtension().name())
//           .build())
//     .toList();

//     CreatePriceDto priceDto = CreatePriceDto
//         .builder()
//         .value(product.getPrice().getValue())
//         .currency(product.getPrice().getCurrency())
//         .build();  

//     return ProductDetailsDto.builder()
//       .id(product.getId())
//       .name(product.getName())
//       .description(product.getDescription())
//       .price(priceDto)
//       .categoriesId(categoriesId)
//       .brandId(product.getBrand().getId())
//       .images(imagesDto)
//           .build();
//   }

// }
