package com.example.cleanarchitecture.domains.products.application.mappers;

import com.example.cleanarchitecture.domains.products.application.entities.DTOs.ProductDTO;
import com.example.cleanarchitecture.domains.products.application.entities.Product;

import java.util.List;
import java.util.stream.Collectors;

public class ProductMapper {
    public static Product toProduct(ProductDTO productDTO) {
        return Product
                .builder()
                .build();
    }

    public static List<Product> toProducts(List<ProductDTO> productDTOs) {
        return productDTOs
                .stream()
                .map(ProductMapper::toProduct)
                .collect(Collectors.toList());
    }
}
