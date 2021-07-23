package com.knifedude.menuessentials.api.inventory.model;

import com.knifedude.menuessentials.api.item.models.ItemStack;

public interface InventorySlot {

    int getIndex();

    void clear();

    void setItemStack(ItemStack itemStack);

    Inventory getInventory();

}
