package com.example.cleanarchitecture.infrastructure.controllers;

import com.example.cleanarchitecture.domains.products.application.entities.Product;
import com.example.cleanarchitecture.domains.products.application.useCases.GetByIdUseCase;
import com.example.cleanarchitecture.domains.products.interfaces.controllers.ProductController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductControllerImpl implements ProductController {

    private final GetByIdUseCase getByIdUseCase;

    public ProductControllerImpl(GetByIdUseCase getByIdUseCase) {
        this.getByIdUseCase = getByIdUseCase;
    }

    @Override
    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Product getById(@PathVariable(value = "id") String id) {
        return getByIdUseCase.execute(id);
    }
}
