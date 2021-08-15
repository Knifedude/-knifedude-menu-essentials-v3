package com.knifedude.menuessentials.api.menu.components;

import com.knifedude.menuessentials.api.item.models.ItemStack;
import com.knifedude.menuessentials.api.item.models.ItemType;
import com.knifedude.menuessentials.api.menu.SlotComponent;
import com.knifedude.menuessentials.api.text.models.Text;

public class Button extends SlotComponent {

    public Button(ItemStack displayItem) {
        super(displayItem);
    }

    public Button(ItemType displayItemType, Text displayName) {
        super(displayItemType, displayName);
    }


}
