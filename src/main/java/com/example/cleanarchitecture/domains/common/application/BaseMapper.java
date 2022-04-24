package com.example.cleanarchitecture.domains.common.application;

public interface BaseMapper {
    <T, U> T toObject(U input, Class<T> outputClass);
}
