package com.krose.display;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.krose.display.guice.ApplicationModule;
import com.krose.display.guice.ElementFactory;
import com.krose.display.guice.ScreenFactory;
import com.krose.display.guice.SystemIOModule;

import java.util.Objects;

public class App {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new SystemIOModule(), new ApplicationModule());
        ScreenFactory screenFactory = injector.getInstance(ScreenFactory.class);
        // Create Screens
        Screen mainScreen = screenFactory.create("main");
        Screen booleanScreen = screenFactory.create("boolean");
        Screen doubleScreen = screenFactory.create("double");
        Screen integerScreen = screenFactory.create("integer");
        Screen stringScreen = screenFactory.create("string");
        // Create Elements
        ElementFactory elementFactory = injector.getInstance(ElementFactory.class);
        Menu mainMenu = elementFactory.createMenu("main-menu", "Main Menu", new String[]{"Boolean", "Double", "Integer", "String", "Exit"});
        BooleanField booleanField = elementFactory.createBooleanField("boolean-field", "Test Boolean");
        DoubleField doubleField = elementFactory.createDoubleField("double-field", "Test Double");
        IntegerField integerField = elementFactory.createIntegerField("integer-field", "Test Integer");
        StringField stringField = elementFactory.createStringField("string-field", "Test String");
        // Map Elements to Screens
        mainScreen.addElement(mainMenu);
        booleanScreen.addElement(booleanField);
        doubleScreen.addElement(doubleField);
        integerScreen.addElement(integerField);
        stringScreen.addElement(stringField);
        // Set Screen Listeners
        ScreenListener returnListener = new ScreenListener() {
            @Override
            public void onScreenEnter() { /* IGNORED */ }

            @Override
            public void onScreenExit() {
                mainScreen.display();
            }
        };
        booleanScreen.setListener(returnListener);
        doubleScreen.setListener(returnListener);
        integerScreen.setListener(returnListener);
        stringScreen.setListener(returnListener);
        mainScreen.setListener(new ScreenListener() {
            @Override
            public void onScreenEnter() { /* IGNORED */ }

            @Override
            public void onScreenExit() {
                int choice = ((Menu) Objects.requireNonNull(mainScreen.getElement("main-menu"))).getValue();
                switch (choice) {
                    case 1 -> booleanScreen.display();
                    case 2 -> doubleScreen.display();
                    case 3 -> integerScreen.display();
                    case 4 -> stringScreen.display();
                }
            }
        });
        // Start at Main Screen
        mainScreen.display();
    }
}
