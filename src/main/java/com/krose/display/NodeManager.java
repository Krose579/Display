package com.krose.display;

import com.krose.io.Input;
import com.krose.io.Output;

import java.util.HashMap;
import java.util.Map;

public class NodeManager {
    private final Map<String, NodeContainer> nodeMap;
    private NodeContainer currentNode;
    private Output output;
    private Input input;

    private NodeManager () {
        this.nodeMap = new HashMap<>();
        this.currentNode = null;
        this.output = null;
        this.input = null;
    }

    public void addNodeContainer (NodeContainer container) {
        nodeMap.put(container.getId(), container);
        container.setOutput(output);
        container.setInput(input);
    }

    public NodeContainer getNodeContainer (String id) {
        return nodeMap.get(id);
    }

    public void setOutput(Output output) {
        this.output = output;
        for (NodeContainer container : nodeMap.values()) container.setOutput(output);
    }

    public void setInput(Input input) {
        this.input = input;
        for (NodeContainer container : nodeMap.values()) container.setInput(input);
    }

    public void next(String id) {
        next(getNodeContainer(id));
    }

    public void next(NodeContainer container) {
        this.currentNode = container;
    }

    public void execute () {
        while (currentNode != null) {
            NodeContainer prevNode = currentNode;
            currentNode = null;
            prevNode.execute();
            prevNode.exit();
        }
    }
}
