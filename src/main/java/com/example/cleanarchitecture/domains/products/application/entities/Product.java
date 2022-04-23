package com.example.cleanarchitecture.domains.products.application.entities;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Product {
    private String id;
    private String title;
    private double price;
    private String currencyId;
    private String thumbnail;
    private String condition;
    private String shipping;
    private String address;


}


