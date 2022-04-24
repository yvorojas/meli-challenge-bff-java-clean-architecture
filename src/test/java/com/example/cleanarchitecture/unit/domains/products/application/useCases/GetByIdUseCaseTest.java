package com.example.cleanarchitecture.unit.domains.products.application.useCases;

import com.example.cleanarchitecture.domains.products.application.adapters.ProductRepository;
import com.example.cleanarchitecture.domains.products.application.entities.DTOs.ProductDTO;
import com.example.cleanarchitecture.domains.products.application.entities.Product;
import com.example.cleanarchitecture.domains.products.application.mappers.ProductMapper;
import com.example.cleanarchitecture.domains.products.application.useCases.GetByIdUseCase;
import com.example.cleanarchitecture.unit.BaseTest;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

class GetByIdUseCaseTest extends BaseTest {

    @Mock
    private ProductRepository repository;
    @Mock
    private ProductMapper mapper;

    @Test
    public void ShouldCallToMapperAndRepositoryAndRetrieveProduct() {
        String id = "id";
        String currency = "currency";
        ProductDTO expectedProductDTO = new ProductDTO();
        expectedProductDTO.setId(id);
        expectedProductDTO.setCurrency_id(currency);
        Product expectedProduct = Product
                .builder()
                .id(id)
                .currency(currency)
                .build();
        when(repository.getById(id)).thenReturn(expectedProductDTO);
        when(mapper.toProduct(expectedProductDTO)).thenReturn(expectedProduct);
        GetByIdUseCase useCase = new GetByIdUseCase(repository, mapper);

        Product product = useCase.execute(id);

        assertEquals(expectedProduct, product);
        verify(repository, times(1)).getById(id);
        verify(mapper, times(1)).toProduct(expectedProductDTO);
    }
}