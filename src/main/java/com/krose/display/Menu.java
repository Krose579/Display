package com.krose.display;

import com.krose.io.Input;
import com.krose.io.Output;

import javax.inject.Inject;
import java.io.IOException;

public final class Menu extends Screen.Element<Integer> {
    private final String title;
    private final String[] options;

    @Inject
    public Menu(String title, String[] options, String id, Input input, Output output) {
        super(id, input, output);
        this.title = title;
        this.options = options;
    }

    public String getTitle() {
        return title;
    }

    public String getOptionAt(int index) {
        if (index < 0 || index >= options.length) return null;
        return options[index];
    }

    @Override
    protected Integer handleInput() {
        try {
            Integer result = getInput().getInteger();
        } catch (NumberFormatException e) {
            return null;
        } catch (IOException ignored) {}
        return 0;
    }

    @Override
    protected void handleOutput() {
        getOutput().writeDivider('#');
        int totalSpace = getOutput().getLineLength() - getTitle().length() - 2;
        int firstSpace = totalSpace / 2;
        String t = '#' + " ".repeat(Math.max(0, firstSpace)) + getTitle() + " ".repeat(Math.max(0, totalSpace - firstSpace)) + '#';
        getOutput().writeLine(t);
        getOutput().writeDivider('#');
        for (int i = 0; i < options.length; i++) getOutput().writeLine(String.format("%d.\t%s", i + 1, options[i]));
        getOutput().writeDivider();
        getOutput().write("Enter Option:");
    }
}
