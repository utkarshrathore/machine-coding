package com.kvs.services.impl;

import com.kvs.models.AttributeValueMap;
import com.kvs.models.KVEntry;
import com.kvs.models.KVValueType;
import com.kvs.services.KVCoreService;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class KVCoreServiceImpl implements KVCoreService {
    List<KVEntry> kvStore;
    Map<String, KVValueType> attributeTypeMap;

    public KVCoreServiceImpl() {
        kvStore = new LinkedList();
        attributeTypeMap = new HashMap<String, KVValueType>();
    }

    public synchronized void put(String key, String attribute, Object value) throws RuntimeException {
        Map<String, Object> m = new HashMap();
        m.put(attribute, value);

        if(!attributeTypeMap.containsKey(attribute)) {
            attributeTypeMap.put(attribute, KVValueType.getType(value));
        }

        // Does this key already exists with us? If so, we need to update
        boolean exists=false;
        for(KVEntry kvEntry : kvStore) {
            if(KVValueType.getType(value) != attributeTypeMap.get(attribute)) {
                throw new RuntimeException("Value type does not match stored value type");
            }

            Map<String, Map<String, Object>> kve = kvEntry.getKvEntry();
            if(kve.containsKey(key)) {
                // Already contains this attribute
                Map<String, Object> attributeMap = kve.get(key);
                if(attributeMap.containsKey(attribute)) {
                    kve.get(key).put(attribute, value);
                } else {
                    // add new attribute
                    attributeMap.put(key, new HashMap<String, Object>().put(attribute, value));
                }
                exists=true;
            }
        }

        // Create new KvEntry
        if(exists==false) {
            // add new key
            KVEntry kvEntry = new KVEntry(key, attribute, value);
            kvEntry.setValueType(attributeTypeMap.get(attribute));
            kvStore.add(kvEntry);
        }
    }

    public List<AttributeValueMap> get(String key) {
        List<AttributeValueMap> ret = new LinkedList<AttributeValueMap>();
        for(KVEntry kvEntry : kvStore) {
            if(kvEntry.getKvEntry().containsKey(key)) {
                Map<String, Map<String, Object>> map = kvEntry.getKvEntry();
                for(String k: map.keySet()) {
                    AttributeValueMap attributeValueMap = new AttributeValueMap();
                    attributeValueMap.setAttribute(k);
                    attributeValueMap.setValue(map.get(k));
                    ret.add(attributeValueMap);
                }
            }
        }
        return ret;
    }

    public synchronized void deleteKey(String key) {
        for(KVEntry kvEntry : kvStore) {
            if(kvEntry.getKvEntry().containsKey(key)) {
                // remove main mapping
                Map<String, Map<String, Object>> map = kvEntry.getKvEntry();
                Map<String, Object> val = map.get(key);
                map.remove(key);

                // also remove reverse mapping
                Map<Map<String, Object>, String> revKVEntry = kvEntry.getRevKVEntry();
                revKVEntry.remove(val);
            }
        }
    }

    public List<String> match(String attribute, Object value) {
        List<String> matches = new LinkedList<String>();
        Map<String, Object> key = new HashMap();
        key.put(attribute, value);
        for(KVEntry kvEntry : kvStore) {
            Map<Map<String, Object>, String> revKVEntry = kvEntry.getRevKVEntry();
            if(revKVEntry.containsKey(key)) {
                matches.add(revKVEntry.get(key));
            }
        }
        return matches;
    }
}