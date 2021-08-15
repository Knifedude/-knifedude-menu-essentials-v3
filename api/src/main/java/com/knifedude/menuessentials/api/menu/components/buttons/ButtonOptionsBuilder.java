package com.knifedude.menuessentials.api.menu.components.buttons;

import com.knifedude.menuessentials.api.item.models.ItemStack;
import com.knifedude.menuessentials.api.item.models.ItemType;
import com.knifedude.menuessentials.api.menu.handlers.ClickHandler;
import com.knifedude.menuessentials.api.text.models.Text;

public interface ButtonOptionsBuilder<TInstance extends ButtonOptions, TBuilder extends ButtonOptionsBuilder<TInstance,TBuilder>> {

    TBuilder withDisplayItem(ItemStack itemStack);

    TBuilder withDisplayItem(ItemType itemType);

    TBuilder withDisplayName(Text text);

    TBuilder withOnClick(ClickHandler clickHandler);

    TInstance build();

}
