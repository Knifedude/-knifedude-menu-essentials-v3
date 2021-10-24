package com.knifedude.menu.essentials.sponge.plugin;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.knifedude.menu.essentials.sponge.modules.TextModule;
import com.knifedude.menuessentials.plugin.modules.CommonModule;
import org.slf4j.Logger;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
import org.spongepowered.api.plugin.Plugin;

@Plugin(id = "knifedude-menu-essentials", name = "Knifedude Menu Essentials", version = "1.0", description = "Developer tool for creating inventory menus")
public class MenuEssentialsSpongePlugin {

    @Inject
    private Logger logger;

    @Listener
    public void onServerStart(GameStartedServerEvent event) {
        Injector injector = Guice.createInjector(
            new CommonModule(),
            new TextModule()
        );

    }

}
