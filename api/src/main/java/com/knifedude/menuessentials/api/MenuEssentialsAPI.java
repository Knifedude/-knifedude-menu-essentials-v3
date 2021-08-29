package com.knifedude.menuessentials.api;

import com.knifedude.menuessentials.api.menu.MenuView;
import com.knifedude.menuessentials.api.menu.MenuViewRegister;
import com.knifedude.menuessentials.api.menu.ToolBox;

import javax.inject.Inject;
import java.util.Optional;
import java.util.UUID;

public class MenuEssentialsAPI {

    @Inject private static ToolBox toolBox;
    @Inject private static MenuViewRegister viewRegister;

    public static ToolBox tools() {
        return toolBox;
    }

    public static Optional<MenuView> findView(UUID player) {
        return viewRegister.findView(player);
    }


}
