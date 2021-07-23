package com.knifedude.menuessentials.api.inventory.events;

import com.knifedude.menuessentials.api.menu.ClickType;
import com.knifedude.menuessentials.api.player.models.Player;

public class InventoryClickEvent {

    private int clickedSlot;
    private ClickType clickType;
    private Player viewer;

    public InventoryClickEvent(int clickedSlot, ClickType clickType, Player viewer) {
        this.clickedSlot = clickedSlot;
        this.clickType = clickType;
        this.viewer = viewer;
    }

    public int getClickedIndex() {
        return clickedSlot;
    }

    public ClickType getClickType() {
        return clickType;
    }

    public Player getViewer() {
        return viewer;
    }
}
