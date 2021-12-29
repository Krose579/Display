package com.krose.display;

import com.krose.io.Input;
import com.krose.io.Output;

import java.io.IOException;

public class IntegerField extends BaseField<Integer> {
    public IntegerField(String label, Input input, Output output) {
        super(label, input, output);
    }

    @Override
    protected Integer handleInput() {
        try {
            return getInput().getInteger();
        } catch (IOException e) {
            throw new DisplayableException("A Technical Error Occurred.", e);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
