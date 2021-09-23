package com.krose.display;

public class IntegerFieldNode extends FieldNode {
    public IntegerFieldNode(String id, String label) {
        super(id, label);
    }

    @Override
    protected Object handleInput() {
        return getInput().getInteger();
    }
}
