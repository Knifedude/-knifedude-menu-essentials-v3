package com.knifedude.menuessentials.api.inventory.model;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Stream;

public interface Inventory {

    /**
     * Gets the width of this inventory
     * @return The width of this inventory
     */
    int width();

    /**
     * Gets the height of this inventory
     * @return The height of this inventory
     */
    int height();

    /**
     * Gets the number of slots of this inventory
     * @return The number of slots
     */
    default int size() {
        return width() * height();
    }

    /**
     * Gets all the {@link InventorySlot}s of this inventory
     * @return The {@link InventorySlot}s
     */
    Stream<InventorySlot> slots();

    default InventorySlot getSlot(int index) {
        return findSlot(index).orElseThrow(() -> new NoSuchElementException("No inventory slot at index:" + index));
    }

    Optional<InventorySlot> findSlot(int index);

}
