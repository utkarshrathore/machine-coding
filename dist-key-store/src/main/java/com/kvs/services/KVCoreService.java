package com.kvs.services;

import com.kvs.models.AttributeValueMap;

import java.util.List;

public interface KVCoreService {
    void put(String key, String attribute, Object value) throws RuntimeException;

    List<AttributeValueMap> get(String key);

    void deleteKey(String key);

    /**
     * Use the secondary index to match the value to be searched with the specified value
     */
    List<String> match(String attribute, Object value);
}