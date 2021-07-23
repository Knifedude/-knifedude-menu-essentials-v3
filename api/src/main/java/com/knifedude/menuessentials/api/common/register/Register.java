package com.knifedude.menuessentials.api.common.register;

import com.google.inject.Inject;

public class Register {

    @Inject private static BuilderRegister builderRegister;
    @Inject private static FactoryRegister factoryRegister;

    private Register() {}

    public static <T> T getBuilder(Class<T> clazz) {
        return builderRegister.getBuilder(clazz);
    }

    public static <T> T getFactory(Class<T> clazz) {
        return factoryRegister.getInstance(clazz);
    }

}
