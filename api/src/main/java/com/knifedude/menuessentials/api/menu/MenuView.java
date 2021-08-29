package com.knifedude.menuessentials.api.menu;

import com.google.common.collect.Maps;
import com.knifedude.menuessentials.api.common.validation.Assert;
import com.knifedude.menuessentials.api.inventory.model.Inventory;
import com.knifedude.menuessentials.api.menu.slot.SlotContainer;
import com.knifedude.menuessentials.api.menu.slot.SlotRow;
import com.knifedude.menuessentials.api.player.models.Player;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public final class MenuView {

    private final Inventory inventory;
    private final Player player;
    private final MenuViewRegister viewRegister;
    private final UUID uniqueID;
    private final Map<String,SlotContainer> containers;

    MenuView(Inventory inventory, Player player, MenuViewRegister viewRegister) {
        Assert.notNull(inventory, "inventory");
        Assert.notNull(player, "player");
        Assert.notNull(viewRegister, "viewRegister");

        this.inventory = inventory;
        this.player = player;
        this.viewRegister = viewRegister;
        this.uniqueID = UUID.randomUUID();
        this.containers = Maps.newHashMap();
    }

    public Optional<SlotContainer> getContainer(String name) {
        return Optional.ofNullable(containers.get(name));
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
        viewRegister.registerView(player.getUniqueId(), this);
        player.openInventory(inventory);
    }

    public  void close() {
        viewRegister.removeView(player.getUniqueId())
                    .ifPresent(view -> player.closeInventory());
    }

    public SlotRow createFromRow(String containerName, int row) {
        throw new UnsupportedOperationException();
    }

    public SlotContainer createFromRowsRange(String containerName, int fromRow, int toRow) {
        throw new UnsupportedOperationException();
    }

    public SlotContainer createRow(String containerName, int rowIndex) {
        throw new UnsupportedOperationException();
    }


}
