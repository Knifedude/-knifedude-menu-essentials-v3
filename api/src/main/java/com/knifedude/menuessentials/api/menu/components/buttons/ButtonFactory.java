package com.knifedude.menuessentials.api.menu.components.buttons;

import com.knifedude.menuessentials.api.item.models.ItemStack;
import com.knifedude.menuessentials.api.menu.components.buttons.item.ItemStackFactory;

import java.util.List;

public interface ButtonFactory {

    Button createButton(ButtonOptions options);

    Button createGiveItemStackButton(ButtonOptions options, ItemStack itemStackToGive);

    <TItem> List<Button> createMultipleGiveItemStackButton(ButtonOptions options, ItemStackFactory<TItem> itemStackFactory, List<TItem> items);

}
