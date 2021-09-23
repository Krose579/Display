package com.krose.display;

import java.util.HashMap;
import java.util.Map;

public class ValueContainer {
    private Map<String, Object> valueMap;

    public ValueContainer () {
        this.valueMap = new HashMap<>();
    }

    public void addValue (String id, Object value) {
        valueMap.put(id, value);
    }

    public String getString (String id) {
        return (String) valueMap.get(id);
    }

    public Integer getInteger (String id) {
        return (Integer) valueMap.get(id);
    }

    public Double getDouble (String id) {
        return (Double) valueMap.get(id);
    }

    public Boolean getBoolean (String id) {
        return (Boolean) valueMap.get(id);
    }
}
