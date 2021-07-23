package com.knifedude.menuessentials.api.item.adapters;

import com.knifedude.menuessentials.api.inventory.model.InventoryTransactionResult;
import com.knifedude.menuessentials.api.item.models.ItemStack;
import com.knifedude.menuessentials.api.player.exceptions.PlayerNotAvailableException;

import java.util.UUID;

public interface ItemStackAdapter {

    InventoryTransactionResult offerItem(UUID player, ItemStack itemStack) throws PlayerNotAvailableException;

}
