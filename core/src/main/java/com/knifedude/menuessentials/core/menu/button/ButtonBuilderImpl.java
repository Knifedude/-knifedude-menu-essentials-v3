package com.knifedude.menuessentials.core.menu.button;

import com.knifedude.menuessentials.api.item.models.ItemStack;
import com.knifedude.menuessentials.api.menu.components.buttons.Button;

public class ButtonBuilderImpl extends AbstractButtonBuilderImpl<Button, ButtonBuilderImpl> {

    @Override
    public Button build() {
        ItemStack is = createDisplayItem();
        Button b = new Button(is);
        apply(b);

        return b;
    }
}
