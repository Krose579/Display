package com.krose.display;

import com.krose.io.Input;
import com.krose.io.Output;

import java.io.IOException;

public class DoubleField extends BaseField<Double> {
    public DoubleField(String label, Input input, Output output) {
        super(label, input, output);
    }

    @Override
    protected Double handleInput() {
        try {
            return getInput().getDouble();
        } catch (IOException e) {
            throw new DisplayableException("A Technical Error Occurred.", e);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
