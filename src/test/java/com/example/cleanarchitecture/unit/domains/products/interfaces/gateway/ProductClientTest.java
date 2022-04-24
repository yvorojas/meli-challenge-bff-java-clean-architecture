package com.example.cleanarchitecture.unit.domains.products.interfaces.gateway;


import com.example.cleanarchitecture.domains.products.application.entities.DTOs.ProductDTO;
import com.example.cleanarchitecture.domains.products.interfaces.adapters.EnvironmentVariables;
import com.example.cleanarchitecture.domains.products.interfaces.adapters.HttpClientCall;
import com.example.cleanarchitecture.domains.products.interfaces.gateway.ProductClient;
import com.example.cleanarchitecture.domains.products.interfaces.gateway.urls;
import com.example.cleanarchitecture.unit.BaseTest;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

class ProductClientTest extends BaseTest {

    @Mock
    private EnvironmentVariables env;
    @Mock
    private HttpClientCall client;

    @Test
    public void shouldReturnClientCallResult() {
        String id = "id";
        String key = "meli.baseurl";
        StringBuilder stringBuilder = new StringBuilder();
        String baseUrl = "https://base_url.com";
        String urlToTest = String.format(stringBuilder.append(baseUrl).append(urls.SEARCH_BY_ID_URI).toString(), id);
        ProductDTO expectedProductDTO = new ProductDTO();
        expectedProductDTO.setId(id);
        when(env.get(key)).thenReturn(baseUrl);
        when(client.callToGetMethod(urlToTest, ProductDTO.class)).thenReturn(expectedProductDTO);
        ProductClient productClient = new ProductClient(client, env);

        ProductDTO productDTO = productClient.getById(id);

        assertEquals(expectedProductDTO, productDTO);

        verify(env, times(1)).get(key);
        verify(client, times(1)).callToGetMethod(urlToTest, ProductDTO.class);

    }

}