package com.knifedude.menuessentials.core.common.register;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.knifedude.menuessentials.api.common.register.FactoryRegister;

import java.util.Map;
import java.util.function.Supplier;

public class FactoryRegisterImpl implements FactoryRegister {

    private final Map<Class<?>,Object> instances;

    public FactoryRegisterImpl() {
        this.instances = Maps.newHashMap();
    }

    @Override
    public <T> void register(Class<T> factoryClass, T factoryInstance) {
        Preconditions.checkArgument(!instances.containsKey(factoryClass), String.format("Already registered '%s'", factoryClass.getName()));
        this.instances.put(factoryClass, factoryInstance);
    }

    @Override
    public <T> T getInstance(Class<T> factoryClass) {
        Preconditions.checkArgument(instances.containsKey(factoryClass), String.format("Builder for class '%s' was not registered", factoryClass.getName()));
        Object instance = instances.get(factoryClass);
        return (T) instance;
    }

}
