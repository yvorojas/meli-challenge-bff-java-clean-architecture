package com.example.cleanarchitecture.infrastructure;

import com.example.cleanarchitecture.domains.products.interfaces.adapters.HttpClientCall;
import org.springframework.web.client.RestTemplate;

public class RestTemplateClient implements HttpClientCall {

    private final RestTemplate client;

    public RestTemplateClient(RestTemplate client) {
        this.client = client;
    }

    public <T> T callToGetMethod(String url, Class<T> classToReturn) {
        return this.client.getForObject(url, classToReturn);
    }
}
