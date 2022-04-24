package com.example.cleanarchitecture.unit.domains.products.endpoints;

import com.example.cleanarchitecture.domains.products.application.entities.Product;
import com.example.cleanarchitecture.domains.products.infrastructure.endpoints.ProductEndpoints;
import com.example.cleanarchitecture.domains.products.interfaces.controllers.ProductController;
import com.example.cleanarchitecture.unit.BaseTest;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

class ProductEndpointsTest extends BaseTest {

    @Mock
    private ProductController controller;

    @Test
    void shouldCallToControllerAndReturnProductInfo() {
        String id = "id";
        Product expectedProduct = Product
                .builder()
                .id(id)
                .build();
        when(controller.getById(id)).thenReturn(expectedProduct);
        ProductEndpoints endpoints = new ProductEndpoints(controller);

        Product product = endpoints.getById(id);

        assertEquals(expectedProduct, product);
        verify(controller, times(1)).getById(id);
    }
}