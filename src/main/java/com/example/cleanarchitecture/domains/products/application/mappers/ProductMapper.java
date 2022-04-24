package com.example.cleanarchitecture.domains.products.application.mappers;

import com.example.cleanarchitecture.domains.common.application.BaseMapper;
import com.example.cleanarchitecture.domains.products.application.entities.DTOs.ProductDTO;
import com.example.cleanarchitecture.domains.products.application.entities.Product;

import java.util.List;
import java.util.stream.Collectors;

public class ProductMapper {

    private final BaseMapper baseMapper;

    public ProductMapper(BaseMapper baseMapper) {
        this.baseMapper = baseMapper;
    }

    public Product toProduct(ProductDTO productDTO) {
        return Product.builder()
                .condition(productDTO.getCondition())
                .shipping(productDTO.getShipping().isFree_shipping())
                .currency(productDTO.getCurrency_id())
                .address(productDTO.getAddress() != null ? productDTO.getAddress() : null)
                .id(productDTO.getId())
                .price(productDTO.getPrice())
                .picture(productDTO.getThumbnail())
                .title(productDTO.getTitle())
                .build();
    }

    public List<Product> toProducts(List<ProductDTO> productDTOs) {
        return productDTOs.stream().map(this::toProduct).collect(Collectors.toList());
    }
}
