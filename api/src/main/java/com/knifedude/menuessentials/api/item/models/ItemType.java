package com.knifedude.menuessentials.api.item.models;

import com.knifedude.menuessentials.api.common.register.Register;
import com.knifedude.menuessentials.api.item.exceptions.ItemTypeNotFoundException;
import com.knifedude.menuessentials.api.item.factories.ItemTypeFactory;

import javax.annotation.Nonnull;

/**
 * Represents an item type
 */
public interface ItemType {

    /**
     * The minecraft id of the item type
     * @return The id
     */
    String getId();

    /**
     * The name of the item type
     * @return The name
     */
    String getName();

    /**
     * The max quantity an {@link ItemStack} of this ItemType can have
     * @return The max quantity
     */
    int getMaxQuantity();

    /**
     * Gets an item type from given an minecraft id
     * @param id The minecraft id
     * @throws ItemTypeNotFoundException if there was no ItemType registered for given minecraft id
     * @return The ItemType that matches the id
     */
    static @Nonnull ItemType from(String id) throws ItemTypeNotFoundException {
        return Register.getFactory(ItemTypeFactory.class).fromId(id).orElseThrow(() -> new ItemTypeNotFoundException(String.format("No item type found for '%s'", id)));
    }

}
