package com.knifedude.menuessentials.api.menu;

import com.knifedude.menuessentials.api.inventory.model.InventoryTransactionResult;
import com.knifedude.menuessentials.api.item.models.ItemStack;
import com.knifedude.menuessentials.api.menu.slot.Slot;
import com.knifedude.menuessentials.api.player.models.Player;

import java.util.Optional;

public class ClickContext {

    private final Player player;
    private final Slot slot;
    private final ClickType clickType;
    private final MenuView view;

    ClickContext(Slot slot, MenuView view, Player player, ClickType clickType) {
        this.slot = slot;
        this.player = player;
        this.clickType = clickType;
        this.view = view;
    }

    public Slot getSlot() {
        return slot;
    }

    public MenuView getView() {
        return view;
    }

    public Optional<Player> getPlayer() {
        return Optional.ofNullable(player);
    }

    public ClickType getClickType() {
        return clickType;
    }



}
