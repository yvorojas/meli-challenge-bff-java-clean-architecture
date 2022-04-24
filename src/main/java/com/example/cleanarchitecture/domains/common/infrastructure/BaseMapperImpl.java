package com.example.cleanarchitecture.domains.common.infrastructure;

import com.example.cleanarchitecture.domains.common.application.BaseMapper;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BaseMapperImpl implements BaseMapper {

    @Override
    public <T, U> T toObject(U input, Class<T> outputClass) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        return mapper.convertValue(input, outputClass);
    }
}
