package com.knifedude.menuessentials.api.item.models;

public interface Item {

    /**
     * Creates an {@link ItemStack} of this item
     * @return The ItemStack that was created
     */
    ItemStack toItemStack();

}
