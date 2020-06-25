package com.kvs.models;

public class AttributeValueMap {
    String attribute;
    Object Value;

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public Object getValue() {
        return Value;
    }

    public void setValue(Object value) {
        Value = value;
    }

    @Override
    public String toString() {
        return "AttributeValueMap{" +
                "attribute='" + attribute + '\'' +
                ", Value=" + Value +
                '}';
    }
}
