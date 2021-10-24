package com.knifedude.menuessentials.core.menu;

import com.knifedude.menuessentials.api.menu.Menu;
import com.knifedude.menuessentials.api.menu.MenuView;
import com.knifedude.menuessentials.api.menu.ToolBox;
import com.knifedude.menuessentials.api.menu.components.buttons.ButtonBuilder;
import com.knifedude.menuessentials.api.menu.components.buttons.navigation.NavigationButtonBuilder;
import com.knifedude.menuessentials.api.menu.components.containers.navigation.NavigationBarBuilder;
import com.knifedude.menuessentials.api.menu.data.MenuHeight;
import com.knifedude.menuessentials.api.menu.data.MenuWidth;

import java.util.function.Consumer;

public class ToolBoxImpl implements ToolBox {
    @Override
    public ButtonBuilder<?, ?> newButton() {
        return null;
    }

    @Override
    public NavigationButtonBuilder<?, ?> newNavigationButton() {
        return null;
    }

    @Override
    public NavigationBarBuilder newNavigationBar() {
        return null;
    }

    @Override
    public Menu createMenu(MenuWidth width, MenuHeight height, Consumer<MenuView> init) {
        return null;
    }
}
