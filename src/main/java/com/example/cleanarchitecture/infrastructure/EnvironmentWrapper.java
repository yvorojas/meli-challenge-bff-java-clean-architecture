package com.example.cleanarchitecture.infrastructure;


import com.example.cleanarchitecture.domains.products.interfaces.adapters.EnvironmentVariables;
import org.springframework.core.env.Environment;

public class EnvironmentWrapper implements EnvironmentVariables {
    private final Environment env;

    public EnvironmentWrapper(Environment env) {
        this.env = env;
    }

    public String get(String key) {
        return env.getProperty(key);
    }

}
