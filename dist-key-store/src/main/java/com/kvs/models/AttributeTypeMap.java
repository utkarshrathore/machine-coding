package com.kvs.models;

public class AttributeTypeMap {
    private String attribute;
    private KVValueType type;

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public KVValueType getType() {
        return type;
    }

    public void setType(KVValueType type) {
        this.type = type;
    }
}