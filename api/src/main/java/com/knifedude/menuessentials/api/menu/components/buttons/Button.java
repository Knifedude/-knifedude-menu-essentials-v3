package com.knifedude.menuessentials.api.menu.components.buttons;

import com.knifedude.menuessentials.api.common.models.Clickable;
import com.knifedude.menuessentials.api.item.models.ItemStack;
import com.knifedude.menuessentials.api.item.models.ItemType;
import com.knifedude.menuessentials.api.menu.slot.SlotComponent;
import com.knifedude.menuessentials.api.text.models.Text;

public abstract class Button extends SlotComponent implements Clickable {

    public Button(ItemStack displayItem) {
        super(displayItem);
    }

    public Button(ItemType displayItemType, Text displayName) {
        super(displayItemType, displayName);
    }

}
