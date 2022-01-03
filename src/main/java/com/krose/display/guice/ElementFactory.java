package com.krose.display.guice;

import com.google.inject.assistedinject.Assisted;
import com.krose.display.BooleanField;
import com.krose.display.DoubleField;
import com.krose.display.IntegerField;
import com.krose.display.StringField;
import com.krose.display.Menu;

public interface ElementFactory {
    BooleanField createBooleanField(@Assisted("id") String id, @Assisted("label") String label);
    DoubleField createDoubleField(@Assisted("id") String id, @Assisted("label") String label);
    IntegerField createIntegerField(@Assisted("id") String id, @Assisted("label") String label);
    StringField createStringField(@Assisted("id") String id, @Assisted("label") String label);
    Menu createMenu(@Assisted("id") String id, @Assisted("title") String title, @Assisted("options") String[] options);
}
