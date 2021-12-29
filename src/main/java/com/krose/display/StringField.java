package com.krose.display;

import com.krose.io.Input;
import com.krose.io.Output;

import java.io.IOException;

public class StringField extends BaseField<String> {
    public StringField(String label, Input input, Output output) {
        super(label, input, output);
    }

    @Override
    protected String handleInput() {
        try {
            return getInput().getString();
        } catch (IOException e) {
            throw new DisplayableException("A Technical Error Occurred.", e);
        }
    }
}
