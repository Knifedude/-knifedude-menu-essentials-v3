package com.knifedude.menuessentials.api.menu.components.buttons.navigation;

import com.google.common.collect.Lists;
import com.knifedude.menuessentials.api.collection.PageSource;
import com.knifedude.menuessentials.api.item.models.ItemStack;
import com.knifedude.menuessentials.api.item.models.ItemType;
import com.knifedude.menuessentials.api.menu.components.buttons.Button;
import com.knifedude.menuessentials.api.menu.handlers.ClickHandler;
import com.knifedude.menuessentials.api.menu.slot.SlotComponent;
import com.knifedude.menuessentials.api.text.models.Text;

import java.util.List;

public class NavigationButton extends Button {

    private PageSource<SlotComponent> pageSource;

    public NavigationButton(ItemStack displayItem, ClickHandler... clickHandlers) {
        this(displayItem, Lists.newArrayList(), clickHandlers);
    }

    public NavigationButton(ItemType displayItemType, Text displayName, ClickHandler... clickHandlers) {
        this(ItemStack.of(displayItemType, displayName), Lists.newArrayList(), clickHandlers);
    }

    public NavigationButton(ItemType displayItemType, Text displayName, List<String> tags, ClickHandler... clickHandlers) {
        this(ItemStack.of(displayItemType, displayName), tags, clickHandlers);
    }

    public NavigationButton(ItemStack displayItem, List<String> tags, ClickHandler... clickHandlers) {
        super(displayItem, tags, clickHandlers);
    }

    public void setPageSource(PageSource<SlotComponent> pageSource) {
        this.pageSource = pageSource;
    }
}
