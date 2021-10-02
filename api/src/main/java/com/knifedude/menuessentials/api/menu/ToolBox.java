package com.knifedude.menuessentials.api.menu;

import com.knifedude.menuessentials.api.menu.components.buttons.ButtonBuilder;
import com.knifedude.menuessentials.api.menu.components.buttons.navigation.NavigationButtonBuilder;
import com.knifedude.menuessentials.api.menu.components.containers.navigation.NavigationBarBuilder;
import com.knifedude.menuessentials.api.menu.data.MenuHeight;
import com.knifedude.menuessentials.api.menu.data.MenuWidth;

import java.util.function.Consumer;

public interface ToolBox {

    ButtonBuilder<?,?> newButton();

    NavigationButtonBuilder<?,?> newNavigationButton();

    NavigationBarBuilder newNavigationBar();

    Menu createMenu(MenuWidth width, MenuHeight height, Consumer<MenuView> init);

}
