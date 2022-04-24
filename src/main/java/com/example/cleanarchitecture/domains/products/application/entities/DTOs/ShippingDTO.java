package com.example.cleanarchitecture.domains.products.application.entities.DTOs;

import lombok.Data;

import java.util.ArrayList;

@Data
public class ShippingDTO {
    private String mode;
    private ArrayList<FreeMethodDTO> free_methods;
    private ArrayList<String> tags;
    private String dimensions;
    private boolean local_pick_up;
    private boolean free_shipping;
    private String logistic_type;
    private boolean store_pick_up;
}
