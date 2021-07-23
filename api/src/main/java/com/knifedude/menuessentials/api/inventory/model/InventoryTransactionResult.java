/*
 * Copyright (C) 2019 ching
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.knifedude.menuessentials.api.inventory.model;

import com.knifedude.menuessentials.api.item.models.ItemStack;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Represents the result of a transaction, which has two states: accepted or rejected
 * @author knifedude
 */
public final class InventoryTransactionResult {
    
    private final Collection<ItemStack> rejected;

    /**
     * Private constructor.
     * @param rejected The rejected items
     */
    private InventoryTransactionResult(Collection<ItemStack> rejected) {
        this.rejected = rejected != null ? rejected : new ArrayList<>();
    }

    /**
     * Determines if the transaction was accepted.
     * @return True if the transaction was accepted
     */
    public boolean isAccepted() {
        return rejected.isEmpty();
    }

    /**
     * Determines if the transaction was rejected.
     * @return True if the transaction was rejected
     */
    public boolean isRejected() {return !isAccepted(); }

    /**
     * Gets the rejected items (if any)
     * @return The rejected items
     */
    public List<ItemStack> getRejectedItems() {
        return new ArrayList<>(rejected);
    }

    /**
     * Creates a transaction result that has been accepted
     * @return The transaction result
     */
    public static InventoryTransactionResult accepted() {
        return new InventoryTransactionResult(null);
    }

    /**
     * Creates a transaction result with the items that have been rejected
     * @param rejected The rejected items
     * @return The transaction result
     */
    public static InventoryTransactionResult ofRejected(Collection<ItemStack> rejected) {
        return new InventoryTransactionResult(rejected);
    }

    /**
     * Creates a transaction result with a single item that has been rejected
     * @param rejected The rejected item
     * @return The transaction result
     */
     public static InventoryTransactionResult ofRejected(ItemStack rejected) {
        return new InventoryTransactionResult(Collections.singletonList(rejected));
    }
    
}
