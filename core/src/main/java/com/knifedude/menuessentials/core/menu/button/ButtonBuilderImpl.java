package com.knifedude.menuessentials.core.menu.button;

import com.google.common.base.Preconditions;
import com.knifedude.menuessentials.api.item.models.ItemStack;
import com.knifedude.menuessentials.api.menu.components.buttons.Button;

public class ButtonBuilderImpl extends AbstractButtonBuilderImpl<Button, ButtonBuilderImpl> {

    @Override
    public Button build() {
        Preconditions.checkNotNull(this.itemStack, "No itemtype or itemstack provided");

        ItemStack is = this.itemStack.toBuilder()
                                     .withDisplayName(this.displayName)
                                     .withLore(this.lore)
                                     .build();

        Button b = new Button(is);
        b.tags().addAll(this.tags);
        this.handlers.forEach(b::addOnClick);

        return b;
    }
}
