package com.example.cleanarchitecture.domains.products.interfaces.adapters;

public interface HttpClientCall {
    <T> T callToGetMethod(String url, Class<T> classType);
}
