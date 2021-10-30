package com.knifedude.menuessentials.api.menu.slot;

import com.google.common.collect.Sets;
import com.knifedude.menuessentials.api.common.validation.Assert;
import com.knifedude.menuessentials.api.item.models.ItemStack;
import com.knifedude.menuessentials.api.item.models.ItemType;
import com.knifedude.menuessentials.api.menu.MenuComponent;
import com.knifedude.menuessentials.api.text.models.Text;
import com.knifedude.menuessentials.api.text.models.lore.Lore;

import java.util.*;

public class SlotComponent extends MenuComponent {

    private ItemStack displayItem;
    private Slot menuSlot;
    private boolean isHidden;
    private Set<String> tags;

    public SlotComponent(ItemStack displayItem) {
        this(displayItem, null);

    }

    public SlotComponent(ItemStack displayItem, Collection<String> tags) {
        Assert.notNull(displayItem, "displayItem");

        this.displayItem = displayItem.copy();
        this.tags = tags != null ? new HashSet<>(tags)  : new HashSet<>();
    }

    public SlotComponent(ItemType displayItemType, Text displayName) {
        Assert.notNull(displayItemType, "displayItemType");
        Assert.notNull(displayName, "displayName");

        this.displayItem = ItemStack.builder()
                .withDisplayName(displayName)
                .withItemType(displayItemType)
                .build();
    }

    public void hide() {
        if (!isHidden) {
            this.isHidden = true;
            slot().ifPresent(slot -> slot.setComponent(this));
        }
    }

    public void show() {
        if (isHidden) {
            this.isHidden = false;
            slot().ifPresent(slot -> slot.setComponent(this));
        }
    }

    public boolean isHidden() {
        return isHidden;
    }

    public boolean isVisible() {
        return !isHidden;
    }

    public ItemStack getDisplayItem() {
        return displayItem.copy();
    }

    public Text getDisplayName() {
        return displayItem.getDisplayName().orElse(Text.empty());
    }

    public int getQuantity() {
        return displayItem.getQuantity();
    }

    public ItemType getDisplayItemType() {
        return displayItem.getItemType();
    }

    public Lore getLore() {
        Lore lore = displayItem.getLore();
        return lore.copy();
    }

    public void setDisplayItem(ItemStack itemStack) {
        Assert.notNull(itemStack, "itemStack");
        this.displayItem = itemStack;
        update();
    }

    public void setDisplayItemType(ItemType itemType) {
        Assert.notNull(itemType, "itemType");
        this.displayItem.setItemType(itemType);
        update();
    }

    public void setDisplayName(Text name) {
        Assert.notNull(name, "name");
        this.displayItem.setDisplayName(name);
        update();
    }

    public void setDisplayQuantity(int quantity) {
        Assert.greaterThanZero(quantity, "quantity");
        this.displayItem.setQuantity(quantity);
        update();
    }

    public void setDisplayLore(Lore lore) {
        this.displayItem.setLore(lore);
        update();
    }

    public Optional<Slot> slot() {
        return Optional.ofNullable(menuSlot);
    }

    private void update() {
        slot().ifPresent(s -> {
            s.setComponent(this);
        });
    }


    void detach() {
        if (menuSlot != null) {
            Slot tempSlot = menuSlot;
            this.menuSlot = null;
            tempSlot.clear();
        }
    }

    void attach(Slot menuSlot) {
        detach();
        if (this.menuSlot == null) {
            this.menuSlot = menuSlot;
            this.menuSlot.setComponent(this);
        }
    }

    public boolean matchesId(SlotComponent other) {
        if (other == null) return false;
        return Objects.equals(this.getUniqueId(), other.getUniqueId());
    }

}
