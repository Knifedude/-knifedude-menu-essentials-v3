package com.knifedude.menu.essentials.sponge.domain.inventory;

import com.google.common.base.Preconditions;
import com.knifedude.menuessentials.api.inventory.model.Inventory;
import com.knifedude.menuessentials.api.inventory.model.InventorySlot;
import org.spongepowered.api.item.inventory.Slot;
import org.spongepowered.api.item.inventory.property.InventoryDimension;
import org.spongepowered.api.item.inventory.property.SlotIndex;
import org.spongepowered.api.item.inventory.query.QueryOperation;
import org.spongepowered.api.item.inventory.query.QueryOperationTypes;

import java.util.Optional;
import java.util.stream.Stream;

public class SpongeInventory implements Inventory {

    private final org.spongepowered.api.item.inventory.Inventory spongeInventory;

    public SpongeInventory(org.spongepowered.api.item.inventory.Inventory spongeInventory) {
        Preconditions.checkNotNull(spongeInventory, "Constructor parameter 'spongeInventory' is mandatory, but was null");
        this.spongeInventory = spongeInventory;
    }

    @Override
    public int width() {
        InventoryDimension dimension = spongeInventory.getInventoryProperty(InventoryDimension.class).orElseThrow(() -> new AssertionError("Property 'InventoryDimension' is not available"));
        return dimension.getColumns();
    }

    @Override
    public int height() {
        InventoryDimension dimension = spongeInventory.getInventoryProperty(InventoryDimension.class).orElseThrow(() -> new AssertionError("Property 'InventoryDimension' is not available"));
        return dimension.getRows();
    }

    @Override
    public Stream<InventorySlot> slots() {



        return null;
    }

    @Override
    public Optional<InventorySlot> findSlot(int index) {
        Slot s = spongeInventory.query(QueryOperationTypes.INVENTORY_PROPERTY.of(SlotIndex.of(index)));
        s.
        return Optional.ofNullable(s).map(new SpongeInventorySlot(s));
    }

}
