package com.example.cleanarchitecture.domains.products.interfaces.gateway;

import com.example.cleanarchitecture.domains.products.application.adapters.ProductRepository;
import com.example.cleanarchitecture.domains.products.application.entities.DTOs.ProductDTO;
import com.example.cleanarchitecture.domains.products.interfaces.adapters.EnvironmentVariables;
import com.example.cleanarchitecture.domains.products.interfaces.adapters.HttpClientCall;

public class ProductClient implements ProductRepository {
    HttpClientCall client;
    EnvironmentVariables env;

    public ProductClient(HttpClientCall client, EnvironmentVariables env) {
        this.client = client;
        this.env = env;
    }

    @Override
    public ProductDTO getById(String id) {
        final StringBuilder stringBuilder = new StringBuilder();
        final String url = String.format(stringBuilder.append(env.get("meli.baseurl")).append(urls.SEARCH_BY_ID_URI).toString(), id);
        return client.callToGetMethod(url, ProductDTO.class);
    }
}
