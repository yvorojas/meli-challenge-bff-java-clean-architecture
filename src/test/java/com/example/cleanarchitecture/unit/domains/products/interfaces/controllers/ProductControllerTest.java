package com.example.cleanarchitecture.unit.domains.products.interfaces.controllers;

import com.example.cleanarchitecture.domains.products.application.entities.Product;
import com.example.cleanarchitecture.domains.products.application.useCases.GetByIdUseCase;
import com.example.cleanarchitecture.domains.products.interfaces.controllers.ProductController;
import com.example.cleanarchitecture.unit.BaseTest;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

class ProductControllerTest extends BaseTest {

    @Mock
    private GetByIdUseCase useCase;

    @Test
    public void shouldCallToUseCaseAndReturnProductInfo() {
        String id = "id";
        Product expectedProduct = Product
                .builder()
                .id(id)
                .build();
        when(useCase.execute(id)).thenReturn(expectedProduct);
        ProductController controller = new ProductController(useCase);

        Product product = controller.getById(id);

        assertEquals(expectedProduct, product);
        verify(useCase, times(1)).execute(id);
    }
}