package com.krose.display;

import com.google.inject.assistedinject.Assisted;
import com.google.inject.assistedinject.AssistedInject;
import com.krose.io.Input;
import com.krose.io.Output;

import javax.inject.Inject;
import java.io.IOException;

public class IntegerField extends BaseField<Integer> {
    @Inject
    protected IntegerField(@Assisted("id") String id, @Assisted("label") String label, Output output, Input input) {
        super(id, label, output, input);
    }

    @Override
    protected UserInput<Integer> requestUserInput() {
        try {
            return UserInput.successful(getInput().getInteger());
        } catch (IOException e) {
            return UserInput.failure("Could not get input.", false);
        } catch (NumberFormatException e) {
            return UserInput.failure("Integer expected.", true);
        }
    }
}
