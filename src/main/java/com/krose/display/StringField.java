package com.krose.display;

import com.google.inject.assistedinject.Assisted;
import com.google.inject.assistedinject.AssistedInject;
import com.krose.io.Input;
import com.krose.io.Output;

import javax.inject.Inject;
import java.io.IOException;

public class StringField extends BaseField<String> {
    @Inject
    protected StringField(@Assisted("id") String id, @Assisted("label") String label, Output output, Input input) {
        super(id, label, output, input);
    }

    @Override
    protected UserInput<String> requestUserInput() {
        try {
            return UserInput.successful(getInput().getString());
        } catch (IOException e) {
            return UserInput.failure("Could not get input.", false);
        }
    }
}
