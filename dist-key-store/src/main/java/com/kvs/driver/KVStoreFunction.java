package com.kvs.driver;

import com.kvs.services.impl.KVCoreServiceImpl;

public class KVStoreFunction {
    public static void main(String[] args) throws RuntimeException {
        KVCoreServiceImpl kvCoreService = new KVCoreServiceImpl();
        kvCoreService.put("delhi", "pollution_level", "very high");
        kvCoreService.put("jakarta", "latitude", -6.0);
        kvCoreService.put("delhi", "population", "10 million");
        kvCoreService.put("delhi", "pollution_level", "high");
        kvCoreService.put("mumbai", "pollution_level", "high");
        kvCoreService.deleteKey("mumbai");
        kvCoreService.get("delhi");
    }
}