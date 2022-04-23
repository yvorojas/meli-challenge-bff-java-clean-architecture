package com.example.cleanarchitecture.domains.products.application.entities.DTOs;

import lombok.Data;

@Data
public class ProductDTO {
    private String id;
    private String title;
    private double price;
    private String currencyId;
    private String thumbnail;
    private String condition;
    private String shipping;
    private String address;
}
