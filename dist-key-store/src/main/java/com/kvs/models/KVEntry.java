package com.kvs.models;

import java.util.HashMap;
import java.util.Map;

public class KVEntry {
    Map<String, Map<String, Object>> kvEntry;
    Map<Map<String, Object>, String> revKVEntry;
    KVValueType valueType = null;

    public KVEntry(String key, String attribute, Object value) {
        // Main Map
        Map<String, Object> attributeMap = new HashMap<String, Object>();
        attributeMap.put(attribute, value);
        this.kvEntry = new HashMap<String, Map<String, Object>>();
        kvEntry.put(key, attributeMap);

        // Rev Map
        revKVEntry = new HashMap<Map<String, Object>, String>();
        revKVEntry.put(attributeMap, key);
    }

    public Map<String, Map<String, Object>> getKvEntry() {
        return kvEntry;
    }

    public void setKvEntry(Map<String, Map<String, Object>> kvEntry) {
        this.kvEntry = kvEntry;
    }

    public KVValueType getValueType() {
        return valueType;
    }

    public void setValueType(KVValueType valueType) {
        this.valueType = valueType;
    }

    public Map<Map<String, Object>, String> getRevKVEntry() {
        return revKVEntry;
    }

    public void setRevKVEntry(Map<Map<String, Object>, String> revKVEntry) {
        this.revKVEntry = revKVEntry;
    }

    @Override
    public String toString() {
        return "KVEntry{" +
                "kvEntry=" + kvEntry +
                ", valueType=" + valueType +
                '}';
    }
}