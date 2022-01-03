package com.krose.display.guice;

import com.google.inject.assistedinject.Assisted;
import com.krose.display.Screen;

public interface ScreenFactory {
    Screen create(@Assisted("id") String id);
}
