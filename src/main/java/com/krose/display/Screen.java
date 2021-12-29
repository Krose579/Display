package com.krose.display;

import com.krose.io.Input;
import com.krose.io.Output;

import javax.inject.Inject;

public final class Screen {
    public static abstract class Element {
        private final String id;
        private final Output output;

        @Inject
        protected Element(String id, Output output) {
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

        protected ValueElement(String id, String label, Output output, Input input) {
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
                if (label != null) getOutput().write(label + ":");
            }
        }

        protected abstract void displayOutput();
    }

    public static final class TextElement extends Element {
        private final String value;

        protected TextElement(String id, String value, Output output) {
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
