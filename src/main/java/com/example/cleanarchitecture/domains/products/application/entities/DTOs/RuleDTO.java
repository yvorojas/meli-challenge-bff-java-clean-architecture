package com.example.cleanarchitecture.domains.products.application.entities.DTOs;

import lombok.Data;

@Data
public class RuleDTO {
    private boolean defaultProp;
    private String free_mode;
    private Boolean free_shipping_flag;
    private String value;

}
