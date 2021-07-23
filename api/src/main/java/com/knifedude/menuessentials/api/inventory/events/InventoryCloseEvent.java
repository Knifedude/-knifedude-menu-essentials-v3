package com.knifedude.menuessentials.api.inventory.events;

import com.google.common.base.Preconditions;
import com.knifedude.menuessentials.api.player.models.Player;

public class InventoryCloseEvent {

    private final Player player;

    public InventoryCloseEvent(Player player) {
        Preconditions.checkNotNull(player);
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }
}
