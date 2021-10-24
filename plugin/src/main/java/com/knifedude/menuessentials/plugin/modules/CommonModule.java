package com.knifedude.menuessentials.plugin.modules;

import com.google.inject.AbstractModule;
import com.knifedude.menuessentials.api.MenuEssentialsAPI;
import com.knifedude.menuessentials.api.common.register.BuilderRegister;
import com.knifedude.menuessentials.api.common.register.FactoryRegister;
import com.knifedude.menuessentials.core.common.register.BuilderRegisterImpl;
import com.knifedude.menuessentials.core.common.register.FactoryRegisterImpl;

public class CommonModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(BuilderRegister.class).to(BuilderRegisterImpl.class);
        bind(FactoryRegister.class).to(FactoryRegisterImpl.class);

        requestStaticInjection(MenuEssentialsAPI.class);
    }

}
