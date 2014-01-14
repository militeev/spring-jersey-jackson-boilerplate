package com.militeev;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@Provider
public class ObjectMapperProvider implements ContextResolver<ObjectMapper> {
 
    private final ObjectMapper defaultObjectMapper;
 
    public ObjectMapperProvider() {
        defaultObjectMapper = createDefaultMapper();
    }
 
    @Override
    public ObjectMapper getContext(Class<?> type) {
        return defaultObjectMapper;
    }
 
    private static ObjectMapper createDefaultMapper() {
        final ObjectMapper result = new ObjectMapper();
        result.configure(SerializationFeature.INDENT_OUTPUT, true);
        return result;
    }
 
}