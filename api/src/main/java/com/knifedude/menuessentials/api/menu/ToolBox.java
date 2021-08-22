package com.knifedude.menuessentials.api.menu;

import com.knifedude.menuessentials.api.menu.components.buttons.ButtonBuilder;
import com.knifedude.menuessentials.api.menu.components.containers.HorizontalScrollBar;
import com.knifedude.menuessentials.api.menu.components.containers.HorizontalScrollBarBuilder;
import com.knifedude.menuessentials.api.menu.data.MenuHeight;
import com.knifedude.menuessentials.api.menu.data.MenuWidth;

import java.util.function.Consumer;

public interface ToolBox {

    ButtonBuilder<?,?> newButton();

    HorizontalScrollBarBuilder<?,?> newHorizontalScrollBar();



    Menu createMenu(MenuWidth width, MenuHeight height, Consumer<MenuView> init);

}
