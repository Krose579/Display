package com.krose.display.guice;

import com.google.inject.AbstractModule;
import com.google.inject.assistedinject.FactoryModuleBuilder;

public class DefaultScreenModule extends AbstractModule {
    @Override
    protected void configure() {
        FactoryModuleBuilder builder = new FactoryModuleBuilder();
        install(builder.build(ScreenFactory.class));
        install(builder.build(ElementFactory.class));
    }
}
