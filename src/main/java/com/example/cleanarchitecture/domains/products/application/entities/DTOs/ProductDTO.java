package com.example.cleanarchitecture.domains.products.application.entities.DTOs;

import lombok.Data;

@Data
public class ProductDTO {
    private String id;
    private String title;
    private double price;
    private String currency_id;
    private String thumbnail;
    private String condition;
    private ShippingDTO shipping;
    private String address;


}
