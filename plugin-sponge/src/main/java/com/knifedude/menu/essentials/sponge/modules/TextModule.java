package com.knifedude.menu.essentials.sponge.modules;

import com.google.inject.AbstractModule;
import com.knifedude.menu.essentials.sponge.domain.text.SpongeTextFactory;
import com.knifedude.menuessentials.api.text.factories.LoreFactory;
import com.knifedude.menuessentials.api.text.factories.TextFactory;
import com.knifedude.menuessentials.core.text.LoreFactoryImpl;

public class TextModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(LoreFactory.class).to(LoreFactoryImpl.class);

        // Platform specific
        bind(TextFactory.class).to(SpongeTextFactory.class);
    }

}
