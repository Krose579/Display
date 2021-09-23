package com.krose.display;

import java.util.ArrayList;
import java.util.List;

public class NodeContainer {
    private final String id;
    private final List<Node> nodes;
    private OnNodeContainerExitListener listener;

    public NodeContainer (String id) {
        this(id, null);
    }

    public NodeContainer (String id, OnNodeContainerExitListener listener) {
        this.id = id;
        this.listener = listener;
        this.nodes = new ArrayList<>();
    }

    public String getId () {
        return id;
    }

    public boolean addNode (Node node) {
        return nodes.add(node);
    }

    public void setListener (OnNodeContainerExitListener listener) {
        this.listener = listener;
    }

    public void execute () {
        for (Node node : nodes) {
            node.execute();
        }
    }

    public void exit () {
        if (listener == null) return;
        ValueContainer values = new ValueContainer();
        for (Node node : nodes) {
            values.addValue(node.getId(), node.getValue());
        }
        listener.onNodeContainerExit(id, values);
    }
}
