package com.example.cleanarchitecture.infrastructure.configurations;

import com.example.cleanarchitecture.domains.products.application.adapters.ProductRepository;
import com.example.cleanarchitecture.domains.products.application.useCases.GetByIdUseCase;
import com.example.cleanarchitecture.domains.products.interfaces.adapters.EnvironmentVariables;
import com.example.cleanarchitecture.domains.products.interfaces.adapters.HttpClientCall;
import com.example.cleanarchitecture.domains.products.interfaces.gateway.ProductClient;
import com.example.cleanarchitecture.infrastructure.EnvironmentWrapper;
import com.example.cleanarchitecture.infrastructure.RestTemplateClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ProductConfiguration {


    @Autowired
    private Environment env;

    @Bean
    public RestTemplate createRestTemplate() {
        return new RestTemplate();
    }

    @Bean
    public HttpClientCall createHttpClientCall() {
        return new RestTemplateClient(createRestTemplate());
    }

    @Bean
    public EnvironmentVariables createEnvironmentVariables() {
        return new EnvironmentWrapper(env);
    }

    @Bean
    public ProductRepository createProductRepository() {
        return new ProductClient(createHttpClientCall(), createEnvironmentVariables());
    }

    @Bean
    public GetByIdUseCase createGetByIdUseCase() {
        return new GetByIdUseCase(createProductRepository());
    }
}
