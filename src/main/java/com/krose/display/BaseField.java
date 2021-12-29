package com.krose.display;

import com.krose.io.Input;
import com.krose.io.Output;

public abstract class BaseField<T> implements Displayable {
    private T value;
    private final String label;
    private final Input input;
    private final Output output;

    public BaseField(String label, Input input, Output output) {
        this.value = null;
        this.label = label;
        this.input = input;
        this.output = output;
    }

    public T getValue() {
        return value;
    }

    public String getLabel() {
        return label;
    }

    protected Input getInput() {
        return input;
    }

    protected Output getOutput() {
        return output;
    }

    @Override
    public void display() {
        while (value == null) {
            output.write(label + ": ");
            value = handleInput();
        }
    }

    protected abstract T handleInput();
}
