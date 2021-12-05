package com.krose.display.old;

import com.krose.io.Input;
import com.krose.io.Output;

import java.util.ArrayList;
import java.util.List;

public class NodeContainer {
    private final String id;
    private final List<Node> nodes;
    private OnNodeContainerExitListener listener;
    private Output output;
    private Input input;

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

    public void addNode (Node node) {
        node.setOutput(output);
        node.setInput(input);
        nodes.add(node);
    }

    public void setListener (OnNodeContainerExitListener listener) {
        this.listener = listener;
    }

    public void setOutput(Output output) {
        this.output = output;
        for (Node node : nodes) node.setOutput(output);
    }

    public void setInput(Input input) {
        this.input = input;
        for (Node node : nodes) node.setInput(input);
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
