package com.krose.display;

import com.krose.io.Input;
import com.krose.io.Output;

import java.util.HashMap;
import java.util.Map;

public class NodeManager {
    private static NodeManager instance;

    private final Input input;
    private final Output output;
    private final Map<String, NodeContainer> nodeMap;
    private NodeContainer currentNode;

    private NodeManager (Input input, Output output) {
        this.input = input;
        this.output = output;
        this.nodeMap = new HashMap<>();
        this.currentNode = null;
    }

    public Input getInput() {
        return input;
    }

    public Output getOutput() {
        return output;
    }

    public void addNodeContainer (NodeContainer container) {
        nodeMap.put(container.getId(), container);
    }

    public void start (String id) {
        start(nodeMap.get(id));
    }

    public void start (NodeContainer container) {
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

    public static NodeManager createNewInstance(Input input, Output output) {
        instance = new NodeManager(input, output);
        return instance;
    }

    public static NodeManager getInstance() {
        return instance;
    }
}
