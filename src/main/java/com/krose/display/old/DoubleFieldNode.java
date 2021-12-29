package com.krose.display.old;

public class DoubleFieldNode extends FieldNode {
    public DoubleFieldNode(String id, String label) {
        super(id, label);
    }

    @Override
    protected Object handleInput() {
        return getInput().getDouble();
    }
}
