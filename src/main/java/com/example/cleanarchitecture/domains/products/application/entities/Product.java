package com.example.cleanarchitecture.domains.products.application.entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Product {
    private String id;
    private String title;
    private double price;
    private String currency;
    private String picture;
    private String condition;
    private boolean shipping;
    private String address;
}


