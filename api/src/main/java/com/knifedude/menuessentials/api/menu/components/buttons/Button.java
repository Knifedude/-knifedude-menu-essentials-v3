package com.knifedude.menuessentials.api.menu.components.buttons;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.knifedude.menuessentials.api.common.models.Clickable;
import com.knifedude.menuessentials.api.item.models.ItemStack;
import com.knifedude.menuessentials.api.item.models.ItemType;
import com.knifedude.menuessentials.api.menu.ClickContext;
import com.knifedude.menuessentials.api.menu.handlers.ClickHandler;
import com.knifedude.menuessentials.api.menu.slot.SlotComponent;
import com.knifedude.menuessentials.api.text.models.Text;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Button extends SlotComponent implements Clickable {

    private List<ClickHandler> onClickHandlers;

    public Button(ItemStack displayItem, ClickHandler... clickHandlers) {
        this(displayItem, Lists.newArrayList(), clickHandlers);
    }

    public Button(ItemType displayItemType, Text displayName, ClickHandler... clickHandlers) {
        this(displayItemType, displayName, Lists.newArrayList(), clickHandlers);
    }

    public Button(ItemType displayItemType, Text displayName, Collection<String>  tags, ClickHandler... clickHandlers) {
        this(ItemStack.of(displayItemType, displayName), tags, clickHandlers);

    }

    public Button(ItemStack displayItem, Collection<String> tags, ClickHandler... clickHandlers) {
        super(displayItem, tags);

        if (clickHandlers != null) {
            this.onClickHandlers = Lists.newArrayList(clickHandlers);
        }
    }

    public Button(ItemStack displayItem, Collection<String> tags, Iterable<ClickHandler> clickHandlers) {
        super(displayItem, tags);

        if (clickHandlers != null) {
            this.onClickHandlers = Lists.newArrayList(clickHandlers);
        }
    }




    public void addOnClick(ClickHandler clickHandler) {
        Preconditions.checkNotNull(clickHandler, "Argument 'clickHandler' can't be null");
        this.onClickHandlers.add(clickHandler);
    }

    @Override
    public void onClick(ClickContext context) {
        for (ClickHandler clickHandler : this.onClickHandlers) {
            clickHandler.onClick(context);
            if (context.isAborted()) break;
        }
    }
}
