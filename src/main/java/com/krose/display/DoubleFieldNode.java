package com.krose.display;

public class DoubleFieldNode extends FieldNode {
    public DoubleFieldNode(String id, String label) {
        super(id, label);
    }

    @Override
    protected Object getInput() {
        return NodeManager.getInstance().getInput().getDouble();
    }
}
