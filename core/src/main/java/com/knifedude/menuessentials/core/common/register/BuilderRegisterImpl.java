package com.knifedude.menuessentials.core.common.register;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.knifedude.menuessentials.api.common.register.BuilderRegister;

import java.util.Map;
import java.util.function.Supplier;

public class BuilderRegisterImpl implements BuilderRegister {

    private final Map<Class<?>,Supplier<?>> suppliers;

    public BuilderRegisterImpl() {
        this.suppliers = Maps.newHashMap();
    }

    @Override
    public <T> void register(Class<T> builderClass, Supplier<T> supplier) {
        Preconditions.checkArgument(!suppliers.containsKey(builderClass), String.format("Already registered '%s'", builderClass.getName()));
        this.suppliers.put(builderClass, supplier);
    }

    @Override
    public <T> T getBuilder(Class<T> builderClass) {
        Preconditions.checkArgument(suppliers.containsKey(builderClass), String.format("Builder for class '%s' was not registered", builderClass.getName()));
        Supplier<?> supplier = suppliers.get(builderClass);
        return (T) supplier.get();
    }

}
