package com.krose.display;

public abstract class Node {
    private final String id;
    private Object value;

    protected Node (String id) {
        this.id = id;
        this.value = null;
    }

    public String getId() {
        return id;
    }

    public Object getValue() {
        return value;
    }

    protected void setValue(Object value) {
        this.value = value;
    }

    public abstract void execute();
}
