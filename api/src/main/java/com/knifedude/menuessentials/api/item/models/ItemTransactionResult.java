package com.knifedude.menuessentials.api.item.models;

import com.google.common.base.Preconditions;
import com.knifedude.menuessentials.api.inventory.model.InventoryTransactionResult;
import com.knifedude.menuessentials.api.player.models.Player;

public class ItemTransactionResult<TItem> {

    private final InventoryTransactionResult inventoryTransactionResult;
    private final TItem item;
    private final Player player;

    public ItemTransactionResult(InventoryTransactionResult inventoryTransactionResult, TItem item, Player player) {
        Preconditions.checkNotNull(player, "Argument 'player' is mandatory");
        Preconditions.checkNotNull(inventoryTransactionResult, "Argument 'inventoryTransactionResult' is mandatory");
        Preconditions.checkNotNull(item, "Argument 'item' is mandatory");

        this.inventoryTransactionResult = inventoryTransactionResult;
        this.item = item;
        this.player = player;
    }

    public InventoryTransactionResult getInventoryTransactionResult() {
        return inventoryTransactionResult;
    }

    public Player getPlayer() {
        return player;
    }

    public TItem getItem() {
        return item;
    }
}
