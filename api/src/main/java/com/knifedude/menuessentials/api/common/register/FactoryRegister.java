package com.knifedude.menuessentials.api.common.register;

public interface FactoryRegister {

    <T> void register(Class<T> clazz, T instance);

    <T> T getInstance(Class<T> clazz);

}
