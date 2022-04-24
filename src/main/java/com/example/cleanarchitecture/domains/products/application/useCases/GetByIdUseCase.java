package com.example.cleanarchitecture.domains.products.application.useCases;

import com.example.cleanarchitecture.domains.products.application.adapters.ProductRepository;
import com.example.cleanarchitecture.domains.products.application.entities.Product;
import com.example.cleanarchitecture.domains.products.application.mappers.ProductMapper;

public class GetByIdUseCase {

    private final ProductRepository repository;
    private final ProductMapper mapper;

    public GetByIdUseCase(ProductRepository repository, ProductMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Product execute(String id) {
        return mapper.toProduct(repository.getById(id));
    }
}
