package com.knifedude.menuessentials.api.menu;

import com.knifedude.menuessentials.api.player.models.Player;

public class Menu {

    private MenuViewFactory viewFactory;
    private MenuViewRegister viewRegister;

    Menu(MenuViewFactory viewFactory, MenuViewRegister viewRegister) {
        this.viewFactory = viewFactory;
        this.viewRegister = viewRegister;
    }


    public MenuView createView(Player player) {
        return this.viewFactory.create(player);
    }


}
