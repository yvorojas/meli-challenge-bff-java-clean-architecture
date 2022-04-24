package com.example.cleanarchitecture.domains.products.infrastructure.configurations;

import com.example.cleanarchitecture.domains.common.application.BaseMapper;
import com.example.cleanarchitecture.domains.common.infrastructure.BaseMapperImpl;
import com.example.cleanarchitecture.domains.common.infrastructure.EnvironmentWrapper;
import com.example.cleanarchitecture.domains.common.infrastructure.RestTemplateClient;
import com.example.cleanarchitecture.domains.products.application.adapters.ProductRepository;
import com.example.cleanarchitecture.domains.products.application.mappers.ProductMapper;
import com.example.cleanarchitecture.domains.products.application.useCases.GetByIdUseCase;
import com.example.cleanarchitecture.domains.products.interfaces.adapters.EnvironmentVariables;
import com.example.cleanarchitecture.domains.products.interfaces.adapters.HttpClientCall;
import com.example.cleanarchitecture.domains.products.interfaces.controllers.ProductController;
import com.example.cleanarchitecture.domains.products.interfaces.gateways.ProductClient;
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
    public BaseMapper createBaseMapper() {
        return new BaseMapperImpl();
    }

    @Bean
    public ProductMapper createProductMapper() {
        return new ProductMapper(createBaseMapper());
    }

    @Bean
    public GetByIdUseCase createGetByIdUseCase() {
        return new GetByIdUseCase(createProductRepository(), createProductMapper());
    }

    @Bean
    ProductController createProductController() {
        return new ProductController(createGetByIdUseCase());
    }
}
