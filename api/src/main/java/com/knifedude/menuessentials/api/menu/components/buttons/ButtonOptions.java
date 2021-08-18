package com.knifedude.menuessentials.api.menu.components.buttons;

import com.knifedude.menuessentials.api.item.models.ItemStack;
import com.knifedude.menuessentials.api.item.models.ItemType;
import com.knifedude.menuessentials.api.text.models.Text;

public interface ButtonOptions {

    ItemStack getItemStack();

    ItemType getItemType();

    Text getDisplayName();

    ButtonBuilder<?,?> toBuilder();

}
