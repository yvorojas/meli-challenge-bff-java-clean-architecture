package com.example.cleanarchitecture.domains.products.interfaces.controllers;

import com.example.cleanarchitecture.domains.products.application.entities.Product;
import com.example.cleanarchitecture.domains.products.application.useCases.GetByIdUseCase;

public class ProductController {

    private final GetByIdUseCase getByIdUseCase;

    public ProductController(GetByIdUseCase getByIdUseCase) {
        this.getByIdUseCase = getByIdUseCase;
    }

    public Product getById(String id) {
        return this.getByIdUseCase.execute(id);
    }
}
