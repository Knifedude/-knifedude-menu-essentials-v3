package com.knifedude.menuessentials.api.menu;

import com.knifedude.menuessentials.api.player.models.Player;

public class Menu {

    private MenuViewFactory viewFactory;

    public Menu(MenuViewFactory viewFactory) {
        this.viewFactory = viewFactory;
    }


    public MenuView createView(Player player) {
        return this.viewFactory.create(player);
    }

}
