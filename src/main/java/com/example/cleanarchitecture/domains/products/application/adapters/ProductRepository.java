package com.example.cleanarchitecture.domains.products.application.adapters;

import com.example.cleanarchitecture.domains.products.application.entities.DTOs.ProductDTO;

public interface ProductRepository {
    ProductDTO getById(String id);
}
