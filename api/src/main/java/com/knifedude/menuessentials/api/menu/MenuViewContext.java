package com.knifedude.menuessentials.api.menu;

import com.knifedude.menuessentials.api.player.models.Player;

public interface MenuViewContext {

    Player getPlayer();

    MenuView getView();

}
