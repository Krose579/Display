package com.krose.display.old;

public class StringFieldNode extends FieldNode {
    public StringFieldNode(String id, String label) {
        super(id, label);
    }

    @Override
    protected Object handleInput() {
        return getInput().getString();
    }
}
