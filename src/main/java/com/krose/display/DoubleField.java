package com.krose.display;

import com.google.inject.assistedinject.Assisted;
import com.google.inject.assistedinject.AssistedInject;
import com.krose.io.Input;
import com.krose.io.Output;

import javax.inject.Inject;
import java.io.IOException;

public class DoubleField extends BaseField<Double> {
    @Inject
    protected DoubleField(@Assisted("id") String id, @Assisted("label") String label, Output output, Input input) {
        super(id, label, output, input);
    }

    @Override
    protected UserInput<Double> requestUserInput() {
        try {
            return UserInput.successful(getInput().getDouble());
        } catch (IOException e) {
            return UserInput.failure("Could not get input.", false);
        } catch (NumberFormatException e) {
            return UserInput.failure("Double expected.", true);
        }
    }
}
