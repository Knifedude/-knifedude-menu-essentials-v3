package com.knifedude.menuessentials.api.menu.components.buttons.item;

import com.knifedude.menuessentials.api.item.models.ItemStack;

public interface ItemStackFactory<T> {

    ItemStack create(T item);

}
