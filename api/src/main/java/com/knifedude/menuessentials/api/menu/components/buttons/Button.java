package com.knifedude.menuessentials.api.menu.components.buttons;

import com.google.common.base.Preconditions;
import com.knifedude.menuessentials.api.common.models.Clickable;
import com.knifedude.menuessentials.api.item.models.ItemStack;
import com.knifedude.menuessentials.api.item.models.ItemType;
import com.knifedude.menuessentials.api.menu.ClickContext;
import com.knifedude.menuessentials.api.menu.handlers.ClickHandler;
import com.knifedude.menuessentials.api.menu.slot.SlotComponent;
import com.knifedude.menuessentials.api.text.models.Text;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Button extends SlotComponent implements Clickable {

    private List<ClickHandler> onClickHandlers;

    public Button(ItemStack displayItem, ClickHandler... clickHandlers) {
        super(displayItem);

        this.onClickHandlers = clickHandlers != null ? Arrays.asList(clickHandlers) : new ArrayList<>();
    }

    public Button(ItemType displayItemType, Text displayName, ClickHandler... clickHandlers) {
        super(displayItemType, displayName);

        this.onClickHandlers = clickHandlers != null ? Arrays.asList(clickHandlers) : new ArrayList<>();
    }

    public Button(ItemStack displayItem, List<String> tags, ClickHandler... clickHandlers) {
        this(displayItem, clickHandlers);

        this.tags().addAll(tags);
    }

    public Button(ItemType displayItemType, Text displayName, List<String>  tags, ClickHandler... clickHandlers) {
        this(displayItemType, displayName, clickHandlers);

        this.tags().addAll(tags);
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
