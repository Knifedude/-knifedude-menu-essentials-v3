package com.knifedude.menuessentials.api.menu.models;

import com.google.common.base.Preconditions;
import com.knifedude.menuessentials.api.common.validation.Assert;
import com.knifedude.menuessentials.api.item.models.ItemType;
import com.knifedude.menuessentials.api.text.models.Text;

public class SlotComponent extends MenuComponent {

    private static final int DEFAULT_QUANTITY = 1;

    private ItemType displayItemType;
    private Text displayName;
    private int displayQuantity;

    private MenuSlot slot;


    public SlotComponent(ItemType displayItemType, Text displayName) {
        this.displayItemType = displayItemType;
        this.displayName = displayName;
        this.displayQuantity = DEFAULT_QUANTITY;
    }

    public void setDisplayItemType(ItemType itemType) {
        this.displayItemType = itemType;
    }

    public void setDisplayName(Text name) {
        this.displayName = displayName;
    }

    public void setDisplayQuantity(int quantity) {
        Assert.checkArgumentGreaterThanZero(quantity, "quantity");
        this.displayQuantity = quantity;
    }

    


}
