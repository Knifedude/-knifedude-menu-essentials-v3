package com.knifedude.menuessentials.api.menu.components.buttons;

import com.knifedude.menuessentials.api.item.models.ItemStack;
import com.knifedude.menuessentials.api.item.models.ItemType;
import com.knifedude.menuessentials.api.menu.handlers.ClickHandler;
import com.knifedude.menuessentials.api.text.models.Text;

public interface ButtonBuilder<TInstance extends Button, TBuilder extends ButtonBuilder<TInstance,TBuilder>> {

    TBuilder withDisplayItem(ItemStack itemStack);

    TBuilder withDisplayItem(ItemType itemType);

    TBuilder withDisplayName(Text text);

    default TBuilder withDisplayName(String text) {
        return withDisplayName(Text.of(text));
    }

    TBuilder withOnClick(ClickHandler... clickHandler);

    TInstance build();

}
