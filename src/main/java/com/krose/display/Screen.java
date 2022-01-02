package com.krose.display;

import com.google.inject.assistedinject.Assisted;
import com.krose.io.Input;
import com.krose.io.Output;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public final class Screen {
    private final String id;
    private final List<Element> elements;
    private ScreenListener listener;

    @Inject
    public Screen(@Assisted("id") String id) {
        this.id = id;
        this.elements = new ArrayList<>();
        this.listener = null;
    }

    public String getId() {
        return id;
    }

    public boolean addElement(Element element) {
        if (hasElement(element.getId())) return false;
        return elements.add(element);
    }

    public Element getElement(String id) {
        int index = getIndex(id);
        if (index == -1) return null;
        return getElementAt(index);
    }

    public Element getElementAt(int index) {
        return elements.get(index);
    }

    public int getIndex(String id) {
        for (int i = 0; i < elements.size(); i++) if (elements.get(i).getId().equals(id)) return i;
        return -1;
    }

    public boolean hasElement(String id) {
        return getIndex(id) != -1;
    }

    public void setListener(ScreenListener listener) {
        this.listener = listener;
    }

    public void display() {
        if (this.listener != null) listener.onScreenEnter();
        for (int i = 0; i < elements.size(); i++) getElementAt(i).display();
        if (this.listener != null) listener.onScreenExit();
    }

    private static abstract class Element {
        private final String id;
        private final Output output;

        @Inject
        protected Element(@Assisted("id") String id, Output output) {
            this.id = id;
            this.output = output;
        }

        public String getId() {
            return id;
        }

        protected final Output getOutput() {
            return output;
        }

        public abstract void display();
    }

    public static abstract class ValueElement<T> extends Element {
        private T value;
        private final String label;
        private final Input input;

        @Inject
        protected ValueElement(@Assisted("id") String id, @Assisted("label") String label, Output output, Input input) {
            super(id, output);
            this.value = null;
            this.label = label;
            this.input = input;
        }

        public T getValue() {
            return value;
        }

        protected final void setValue(T value) {
            this.value = value;
        }

        protected String getLabel() {
            return label;
        }

        protected final Input getInput() {
            return input;
        }

        @Override
        public final void display() {
            displayOutput();
            while (true) {
                if (label != null) getOutput().write("Enter " + label + ":");
                UserInput<T> result = requestUserInput();
                if (result.isSuccessful()) {
                    setValue(result.getValue());
                } else if (result.isFailure()) {
                    getOutput().writeLine(result.getFailureMessage());
                    if (result.isRetryAllowed()) continue;
                }
                break;
            }
        }

        protected abstract UserInput<T> requestUserInput();

        protected abstract void displayOutput();
    }

    public static final class TextElement extends Element {
        private final String value;

        @Inject
        public TextElement(@Assisted("id") String id, @Assisted("value") String value, Output output) {
            super(id, output);
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public void display() {
            getOutput().writeLine(getValue());
        }
    }
}
