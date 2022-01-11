package com.krose.display.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.assistedinject.FactoryModuleBuilder;

import java.io.*;

public class ApplicationModule extends AbstractModule {
    @Override
    protected void configure() {
        FactoryModuleBuilder builder = new FactoryModuleBuilder();
        install(builder.build(ScreenFactory.class));
        install(builder.build(ElementFactory.class));
    }

    @Provides
    public BufferedReader provideBufferedReader(Reader reader) {
        return new BufferedReader(reader);
    }

    @Provides
    public BufferedWriter provideBufferedWriter(Writer writer) {
        return new BufferedWriter(writer);
    }
}
