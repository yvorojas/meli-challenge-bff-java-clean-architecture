package com.example.cleanarchitecture.domains.products.infrastructure.endpoints;

import com.example.cleanarchitecture.domains.products.application.entities.Product;
import com.example.cleanarchitecture.domains.products.interfaces.controllers.ProductController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductEndpoints {

    private final ProductController controller;

    public ProductEndpoints(ProductController controller) {
        this.controller = controller;
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Product getById(@PathVariable String id) {
        return controller.getById(id);
    }
}
