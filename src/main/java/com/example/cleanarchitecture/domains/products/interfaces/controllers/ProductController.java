package com.example.cleanarchitecture.domains.products.interfaces.controllers;

import com.example.cleanarchitecture.domains.products.application.entities.Product;

public interface ProductController {
    Product getById(String id);
}
