package com.krose.display;

import com.krose.io.Input;
import com.krose.io.Output;

public abstract class Node {
    private final String id;
    private Object value;
    private Output output;
    private Input input;

    protected Node (String id) {
        this.id = id;
        this.value = null;
        this.output = null;
        this.input = null;
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

    protected Output getOutput() {
        return output;
    }

    public void setOutput(Output output) {
        this.output = output;
    }

    protected Input getInput() {
        return input;
    }

    public void setInput(Input input) {
        this.input = input;
    }

    public abstract void execute();
}
