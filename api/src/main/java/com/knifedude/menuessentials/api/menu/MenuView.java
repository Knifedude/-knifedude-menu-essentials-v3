package com.knifedude.menuessentials.api.menu;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.knifedude.menuessentials.api.common.validation.Assert;
import com.knifedude.menuessentials.api.inventory.model.Inventory;
import com.knifedude.menuessentials.api.menu.components.containers.item.ItemContainer;
import com.knifedude.menuessentials.api.menu.shapes.Point;
import com.knifedude.menuessentials.api.menu.shapes.Rectangle;
import com.knifedude.menuessentials.api.menu.slot.Slot;
import com.knifedude.menuessentials.api.menu.slot.SlotComponent;
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
    private final Map<UUID, ItemContainer<?>> containerComponents;
    private final SlotContainer root;

    MenuView(Inventory inventory, Player player, MenuViewRegister viewRegister) {
        Assert.notNull(inventory, "inventory");
        Assert.notNull(player, "player");
        Assert.notNull(viewRegister, "viewRegister");

        this.uniqueID = UUID.randomUUID();
        this.inventory = inventory;
        this.player = player;
        this.viewRegister = viewRegister;
        this.containerComponents = Maps.newHashMap();
        this.root = new SlotContainer(inventory);
    }

    public UUID getUniqueID() {
        return uniqueID;
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

    public void setComponent(int x, int y, SlotComponent component) {
        int index = y * width() + x;
        setComponent(index, component);
    }

    public void setComponent(int index, SlotComponent component) {
        Slot slot = root.find(index).orElseThrow(() -> new IndexOutOfBoundsException("Index is not within bounds of this view"));
        slot.setComponent(component);
    }

    public <TItemContainer extends ItemContainer<SlotRow>> TItemContainer createRow(int rowIndex, Function<SlotRow, TItemContainer> containerFunction) {
        SlotRow slotRow = root.getSingleRow(rowIndex);
        TItemContainer rowContainer = containerFunction.apply(slotRow);
        containerComponents.put(rowContainer.getUniqueId(), rowContainer);

        return rowContainer;
    }

    public <TItemContainer extends ItemContainer<SlotContainer>> TItemContainer createContainer(int fromRow, int toRow, Function<SlotContainer, TItemContainer> containerFunction) {

        int startX = 0;
        int startY = fromRow * width();
        int endX = toRow * width() + width();
        int endY = toRow;

        SlotContainer container = new SlotContainer(root, Rectangle.of(Point.of(startX, startY), Point.of(endX, endY)));

        TItemContainer itemContainer = containerFunction.apply(container);
        containerComponents.put(itemContainer.getUniqueId(), itemContainer);

        return itemContainer;
    }


}
