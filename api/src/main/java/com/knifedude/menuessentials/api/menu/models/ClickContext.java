package com.knifedude.menuessentials.api.menu.models;

import com.knifedude.menuessentials.api.player.models.Player;

import java.util.Optional;

public class ClickContext {

    private final Player player;
    private final MenuSlot slot;
    private final ClickType clickType;
    private final MenuView view;

    ClickContext(MenuSlot slot, MenuView view, Player player, ClickType clickType) {
        this.slot = slot;
        this.player = player;
        this.clickType = clickType;
        this.view = view;
    }

    public MenuSlot getSlot() {
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
