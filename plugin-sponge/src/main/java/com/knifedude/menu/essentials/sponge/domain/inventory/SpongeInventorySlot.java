package com.knifedude.menu.essentials.sponge.domain.inventory;

import com.knifedude.menu.essentials.sponge.domain.item.SpongeItemStack;
import com.knifedude.menuessentials.api.inventory.model.Inventory;
import com.knifedude.menuessentials.api.inventory.model.InventorySlot;
import com.knifedude.menuessentials.api.item.models.ItemStack;
import org.spongepowered.api.item.inventory.Slot;

public class SpongeInventorySlot implements InventorySlot {

    private Inventory inventory;
    private Slot slot;
    private int index;

    SpongeInventorySlot(Inventory inventory, Slot slot, int index) {
        this.inventory = inventory;
        this.slot = slot;
        this.index = index;
    }

    @Override
    public int getIndex() {
        return index;
    }

    @Override
    public void clear() {
        this.slot.clear();
    }

    @Override
    public void setItemStack(ItemStack itemStack) {
        SpongeItemStack spongeItemStack

        this.slot.set(itemStack)
    }

    @Override
    public Inventory getInventory() {
        return null;
    }
}
