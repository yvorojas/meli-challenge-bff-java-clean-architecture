package com.example.cleanarchitecture.domains.products.application.useCases;

import com.example.cleanarchitecture.domains.products.application.adapters.ProductRepository;
import com.example.cleanarchitecture.domains.products.application.entities.Product;
import com.example.cleanarchitecture.domains.products.application.mappers.ProductMapper;

public class GetByIdUseCase {

    private final ProductRepository repository;

    public GetByIdUseCase(ProductRepository repository) {
        this.repository = repository;
    }

    public Product execute(String id) {
        return ProductMapper.toProduct(repository.getById(id));
    }
}
