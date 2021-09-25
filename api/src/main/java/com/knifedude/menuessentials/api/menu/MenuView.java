package com.knifedude.menuessentials.api.menu;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.knifedude.menuessentials.api.common.validation.Assert;
import com.knifedude.menuessentials.api.inventory.model.Inventory;
import com.knifedude.menuessentials.api.menu.components.containers.item.ItemContainer;
import com.knifedude.menuessentials.api.menu.slot.SlotContainer;
import com.knifedude.menuessentials.api.menu.slot.SlotRow;
import com.knifedude.menuessentials.api.player.models.Player;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;

public final class MenuView {

    private final Inventory inventory;
    private final Player player;
    private final MenuViewRegister viewRegister;
    private final UUID uniqueID;
    private final Map<String, ItemContainer<?>> containerComponents;
    private final SlotContainer root;

    MenuView(Inventory inventory, Player player, MenuViewRegister viewRegister) {
        Assert.notNull(inventory, "inventory");
        Assert.notNull(player, "player");
        Assert.notNull(viewRegister, "viewRegister");

        this.inventory = inventory;
        this.player = player;
        this.viewRegister = viewRegister;
        this.uniqueID = UUID.randomUUID();
        this.containerComponents = Maps.newHashMap();
        this.root = new SlotContainer(inventory);
    }

    public Optional<ItemContainer<?>> getContainer(String name) {
        return Optional.ofNullable(containerComponents.get(name));
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

    public <TItemContainer extends ItemContainer<SlotRow>> TItemContainer createFromRow(String containerName, int rowIndex, Function<SlotRow, TItemContainer> containerFunction) {
        Preconditions.checkArgument(!containerExists(containerName), String.format("Container with name '%s' already exists", containerName));

        SlotRow slotRow = root.getSingleRow(rowIndex);
        TItemContainer rowContainer = containerFunction.apply(slotRow);
        containerComponents.put(containerName, rowContainer);

        return rowContainer;
    }

    public <TItemContainer extends ItemContainer<SlotContainer>> TItemContainer createFromRowsRange(String containerName, int fromRow, int toRow, Function<SlotContainer, TItemContainer> containerFunction) {
        Preconditions.checkArgument(!containerExists(containerName), String.format("Container with name '%s' already exists", containerName));

        SlotRow slotRow = root.getRowsInRange(fromRow, toRow);
        TItemContainer rowContainer = containerFunction.apply(slotRow);
        containerComponents.put(containerName, rowContainer);

        return rowContainer;
    }

    public boolean containerExists(String containerName) {
        return containerComponents.containsKey(containerName);
    }

}
