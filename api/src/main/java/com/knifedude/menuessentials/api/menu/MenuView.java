package com.knifedude.menuessentials.api.menu;

import com.knifedude.menuessentials.api.common.validation.Assert;
import com.knifedude.menuessentials.api.inventory.model.Inventory;
import com.knifedude.menuessentials.api.menu.slot.SlotContainer;
import com.knifedude.menuessentials.api.player.models.Player;

public final class MenuView {

    private final Inventory inventory;
    private final Player player;

    MenuView(Inventory inventory, Player player) {
        Assert.notNull(inventory, "inventory");
        this.inventory = inventory;
        this.player = player;
    }

    public int size() {
        return width() * height();
    }

    public int width() {
        return inventory.width();
    }

    public int height() {
        return inventory.height();
    }

    public Player getPlayer() {
        return player;
    }

    public void open() {
        player.openInventory(inventory);
    }

    public SlotContainer createFromRowsRange(String containerName, int fromRow, int toRow) {
        throw new UnsupportedOperationException();
    }

    public SlotContainer createRow(String containerName, int rowIndex) {
        throw new UnsupportedOperationException();
    }


}
