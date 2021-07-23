package com.knifedude.menuessentials.api.common.register;

import java.util.function.Supplier;

public interface BuilderRegister {

    <T> void register(Class<T> builderClass, Supplier<T> supplier);

    <T> T getBuilder(Class<T> clazz);

}
