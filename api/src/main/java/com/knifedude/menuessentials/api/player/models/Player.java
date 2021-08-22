package com.knifedude.menuessentials.api.player.models;

import com.knifedude.menuessentials.api.common.models.Identifiable;
import com.knifedude.menuessentials.api.inventory.model.Inventory;
import com.knifedude.menuessentials.api.inventory.model.InventoryTransactionResult;
import com.knifedude.menuessentials.api.item.models.ItemStack;

import java.util.UUID;

public interface Player extends Identifiable {

    /**
     * Gets the unique id of the viewer.
     * @return The unique id of the viewer
     */
    @Override
    UUID getUniqueId();

//    /**
//     * Offers an {@link ItemStack} to this viewer
//     * @param item The {@link ItemStack}
//     * @return The {@link InventoryTransactionResult}
//     */
//    InventoryTransactionResult offerItem(ItemStack item);

    /**
     * Closes the current inventory that is opened by this player
     */
    void closeInventory();

    void openInventory(Inventory inventory);

    InventoryTransactionResult giveItemStack(ItemStack itemStack);

}
