package com.krose.display;

import com.google.inject.assistedinject.Assisted;
import com.google.inject.assistedinject.AssistedInject;
import com.krose.io.Input;
import com.krose.io.Output;

import javax.inject.Inject;

public abstract class BaseField<T> extends Screen.ValueElement<T> {
    @Inject
    protected BaseField(@Assisted("id") String id, @Assisted("label") String label, Output output, Input input) {
        super(id, label, output, input);
    }

    @Override
    protected final void displayOutput() { /* IGNORE FOR FIELDS */ }
}
