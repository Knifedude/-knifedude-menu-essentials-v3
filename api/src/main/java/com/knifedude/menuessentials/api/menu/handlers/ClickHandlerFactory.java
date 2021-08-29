package com.knifedude.menuessentials.api.menu.handlers;

import com.knifedude.menuessentials.api.item.models.ItemStack;

public interface ClickHandlerFactory {

    ClickHandler giveItemStack(ItemStack itemStack);

    ClickHandler previousPage(String targetTag, String pageVariableKey);

    ClickHandler nextPage(String targetTag, String pageVariableKey);


}
