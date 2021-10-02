package com.knifedude.menu.essentials.sponge.domain.player;

import com.knifedude.menuessentials.api.inventory.model.Inventory;
import com.knifedude.menuessentials.api.inventory.model.InventoryTransactionResult;
import com.knifedude.menuessentials.api.item.models.ItemStack;
import com.knifedude.menuessentials.api.player.models.Player;

import java.util.UUID;

public class SpongePlayer implements Player {

    @Override
    public UUID getUniqueId() {
        return null;
    }

    @Override
    public void closeInventory() {

    }

    @Override
    public void openInventory(Inventory inventory) {

    }

    @Override
    public InventoryTransactionResult giveItemStack(ItemStack itemStack) {
        return null;
    }

}
