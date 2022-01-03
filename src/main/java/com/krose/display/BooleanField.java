package com.krose.display;

import com.google.inject.assistedinject.Assisted;
import com.krose.io.Input;
import com.krose.io.Output;

import javax.inject.Inject;
import java.io.IOException;

public class BooleanField extends BaseField<Boolean> {
    @Inject
    protected BooleanField(@Assisted("id") String id, @Assisted("label") String label, Output output, Input input) {
        super(id, label, output, input);
    }

    @Override
    protected UserInput<Boolean> requestUserInput() {
        try {
            return UserInput.successful(getInput().getBoolean());
        } catch (IOException e) {
            return UserInput.failure("Could not get input.", false);
        }
    }
}
