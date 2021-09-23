package com.krose.display;

public abstract class FieldNode extends Node {
    private final String label;

    protected FieldNode(String id, String label) {
        super(id);
        this.label = label;
    }

    public void execute() {
        NodeManager.getInstance().getOutput().write(String.format("Enter %s:", label));
        setValue(getInput());
    }

    protected abstract Object getInput();
}
