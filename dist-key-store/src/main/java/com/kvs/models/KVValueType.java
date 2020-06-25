package com.kvs.models;

public enum KVValueType {
    INT,
    BOOL,
    DOUBLE,
    STRING;

    public static KVValueType getType(Object o) {
        // Determine object type
        KVValueType vT= null;
        if(o instanceof String) {
            vT = KVValueType.STRING;
        } else if(o instanceof Double) {
            vT = KVValueType.DOUBLE;
        } else if(o instanceof Boolean) {
            vT = KVValueType.BOOL;
        } else {
            vT = KVValueType.INT;
        }
        return vT;
    }
}