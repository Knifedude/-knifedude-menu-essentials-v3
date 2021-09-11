package com.knifedude.menuessentials.api.menu.components.buttons.page;

import com.google.common.collect.Lists;
import com.knifedude.menuessentials.api.item.models.ItemStack;
import com.knifedude.menuessentials.api.item.models.ItemType;
import com.knifedude.menuessentials.api.menu.ClickContext;
import com.knifedude.menuessentials.api.menu.components.buttons.Button;
import com.knifedude.menuessentials.api.menu.handlers.ClickHandler;
import com.knifedude.menuessentials.api.text.models.Text;
import java.util.List;
import java.util.function.Function;

public class PageButton extends Button {

    private Function<Integer,Text> currentPageDisplayFunction;

    public PageButton(ItemStack displayItem, Function<Integer,Text> currentPageDisplayFunction, ClickHandler... clickHandlers) {
        this(displayItem, Lists.newArrayList(), currentPageDisplayFunction, clickHandlers);
    }

    public PageButton(ItemType displayItemType, Text displayName, Function<Integer,Text> currentPageDisplayFunction, ClickHandler... clickHandlers) {
        this(ItemStack.builder().withItemType(displayItemType).withDisplayName(displayName).build(), Lists.newArrayList(), currentPageDisplayFunction, clickHandlers);
    }

    public PageButton(ItemType displayItemType, Text displayName, List<String> tags, Function<Integer,Text> currentPageDisplayFunction, ClickHandler... clickHandlers) {
        this(ItemStack.builder().withItemType(displayItemType).withDisplayName(displayName).build(), tags, currentPageDisplayFunction, clickHandlers);
    }

    public PageButton(ItemStack displayItem, List<String> tags, Function<Integer,Text> currentPageDisplayFunction, ClickHandler... clickHandlers) {
        super(displayItem, tags, clickHandlers);

        this.currentPageDisplayFunction = currentPageDisplayFunction;
    }

    @Override
    public void onClick(ClickContext context) {
        super.onClick(context);
    }

}
