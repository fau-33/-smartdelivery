package br.com.javadevweek.smartdelivery.modules.products.dto;

import br.com.javadevweek.smartdelivery.modules.products.ProductEntity;

import java.util.List;
import java.util.stream.Collectors;

public class ProductMapper {
    public static ProductEntity requestToEntity(CreateProductRequest createProductRequest) {
        return new ProductEntity(
                createProductRequest.getCode(),      // int
                createProductRequest.getName(),      // String
                createProductRequest.getDescription(), // String
                createProductRequest.getPrice()      // double
        );
    }

    public static CreateProductResponse entityToResponse(ProductEntity productEntity) {
        return new CreateProductResponse(
                productEntity.getCode(),
                productEntity.getName(),
                productEntity.getId()
        );
    }

    public static List<ListProductResponse> toResponse(List<ProductEntity> productEntities) {
        return productEntities.stream()
                .map(product -> new ListProductResponse(
                        product.getCode(),        // int
                        product.getName(),        // String
                        product.getPrice(),       // double
                        product.getDescription()  // String
                ))
                .collect(Collectors.toList());
    }
}