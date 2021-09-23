package com.krose.display;

import com.krose.io.Output;

public class MenuNode extends Node {
    private final String title;
    private final String[] options;

    public MenuNode(String id, String title, String[] options) {
        super(id);
        this.title = title;
        this.options = options;
    }

    @Override
    public void execute() {
        Output output = NodeManager.getInstance().getOutput();
        output.writeDivider();
        output.write(title, Output.Alignment.CENTER);
        output.writeDivider();
        for (int i = 0; i < options.length; i++) {
            output.write(String.format("%d.\t%s", i + 1, options[i]));
        }
        output.writeDivider();
        output.write("Enter Option:");
        setValue(NodeManager.getInstance().getInput().getInteger());
    }
}
