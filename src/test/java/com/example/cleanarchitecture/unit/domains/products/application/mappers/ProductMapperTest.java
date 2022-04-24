package com.example.cleanarchitecture.unit.domains.products.application.mappers;

import com.example.cleanarchitecture.domains.common.application.BaseMapper;
import com.example.cleanarchitecture.domains.products.application.entities.DTOs.ProductDTO;
import com.example.cleanarchitecture.domains.products.application.entities.DTOs.ShippingDTO;
import com.example.cleanarchitecture.domains.products.application.entities.Product;
import com.example.cleanarchitecture.domains.products.application.mappers.ProductMapper;
import com.example.cleanarchitecture.unit.BaseTest;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class ProductMapperTest extends BaseTest {

    @Mock
    private BaseMapper baseMapper;

    @Test
    public void shouldReturnMappedProductFromProductDTO() {
        String id = "id";
        boolean isFreeShipping = true;
        ShippingDTO shippingDTO = new ShippingDTO();
        shippingDTO.setFree_shipping(isFreeShipping);
        ProductDTO productDTOToMap = new ProductDTO();
        productDTOToMap.setId(id);
        productDTOToMap.setShipping(shippingDTO);
        Product expectedProduct = Product
                .builder()
                .id(id)
                .shipping(isFreeShipping)
                .build();
        ProductMapper mapper = new ProductMapper(baseMapper);

        Product product = mapper.toProduct(productDTOToMap);

        assertEquals(expectedProduct, product);
        verify(baseMapper, times(0)).toObject(productDTOToMap, Product.class);
    }

    @Test
    public void shouldReturnMappedProductListFromProductDTOList() {
        String id = "id";
        boolean isFreeShipping = true;
        ShippingDTO shippingDTO = new ShippingDTO();
        shippingDTO.setFree_shipping(isFreeShipping);
        ProductDTO productDTOToMap = new ProductDTO();
        productDTOToMap.setId(id);
        productDTOToMap.setShipping(shippingDTO);
        Product expectedProduct = Product
                .builder()
                .id(id)
                .shipping(isFreeShipping)
                .build();
        List<ProductDTO> productDTOs = new LinkedList<>(List.of(productDTOToMap, productDTOToMap));
        List<Product> expectedProducts = new LinkedList<>(List.of(expectedProduct, expectedProduct));
        ProductMapper mapper = new ProductMapper(baseMapper);

        List<Product> products = mapper.toProducts(productDTOs);

        assertEquals(expectedProducts, products);
        verify(baseMapper, times(0)).toObject(productDTOToMap, Product.class);
    }
}