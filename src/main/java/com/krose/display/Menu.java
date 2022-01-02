package com.krose.display;

import com.google.inject.assistedinject.Assisted;
import com.google.inject.assistedinject.AssistedInject;
import com.krose.io.Input;
import com.krose.io.Output;

import javax.inject.Inject;
import java.io.IOException;

public final class Menu extends Screen.ValueElement<Integer> {
    private final String title;
    private final String[] options;

    @Inject
    public Menu(@Assisted("id") String id, @Assisted("title") String title, @Assisted("options") String[] options, Output output, Input input) {
        super(id, "Option", output, input);
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
    protected void displayOutput() {
        getOutput().writeDivider('#');
        int totalSpace = getOutput().getLineLength() - getTitle().length() - 2;
        int firstSpace = totalSpace / 2;
        String t = '#' + " ".repeat(Math.max(0, firstSpace)) + getTitle() + " ".repeat(Math.max(0, totalSpace - firstSpace)) + '#';
        getOutput().writeLine(t);
        getOutput().writeDivider('#');
        for (int i = 0; i < options.length; i++) getOutput().writeLine(String.format("%d.\t%s", i + 1, options[i]));
        getOutput().writeDivider();
    }

    @Override
    protected UserInput<Integer> requestUserInput() {
        try {
            Integer result = getInput().getInteger();
            if (result <= 0 || result > options.length) return UserInput.failure("Invalid selection.", true);
            return UserInput.successful(result);
        } catch (IOException e) {
            return UserInput.failure("Could not get input.", false);
        } catch (NumberFormatException e) {
            return UserInput.failure("Integer expected.", true);
        }
    }
}
