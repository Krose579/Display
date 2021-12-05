package com.krose.display;

import com.krose.io.Input;
import com.krose.io.Output;

import java.io.IOException;

public class BooleanField extends BaseField<Boolean> {
    public BooleanField(String label, Input input, Output output) {
        super(label, input, output);
    }

    @Override
    protected Boolean handleInput() {
        try {
            return getInput().getBoolean();
        } catch (IOException e) {
            throw new DisplayableException("A Technical Error Occurred.", e);
        }
    }
}
