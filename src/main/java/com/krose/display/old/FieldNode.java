package com.krose.display.old;

public abstract class FieldNode extends Node {
    private final String label;

    protected FieldNode(String id, String label) {
        super(id);
        this.label = label;
    }

    public void execute() {
        getOutput().write(String.format("Enter %s:", label));
        setValue(handleInput());
    }

    protected abstract Object handleInput();
}
