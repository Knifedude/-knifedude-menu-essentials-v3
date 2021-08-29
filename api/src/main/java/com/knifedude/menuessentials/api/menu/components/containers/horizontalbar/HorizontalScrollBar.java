package com.knifedude.menuessentials.api.menu.components.containers.horizontalbar;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.knifedude.menuessentials.api.menu.ClickContext;
import com.knifedude.menuessentials.api.menu.MenuViewContext;
import com.knifedude.menuessentials.api.menu.components.buttons.Button;
import com.knifedude.menuessentials.api.menu.components.containers.ContainerComponent;
import com.knifedude.menuessentials.api.menu.slot.Slot;
import com.knifedude.menuessentials.api.menu.slot.SlotRow;

import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

public class HorizontalScrollBar extends ContainerComponent<SlotRow> {

    private Button previousPageBtn, nextPageBtn;
    private Map<Integer,Button> buttons;


    HorizontalScrollBar(Button previousPage, Button nextPage) {
        this.previousPageBtn = previousPage;
        this.nextPageBtn = nextPage;
        this.buttons = Maps.newHashMap();
    }

    @Override
    protected void init(SlotRow slotContainer, MenuViewContext context) {
        Slot first = slotContainer.first().orElseThrow(() -> new NoSuchElementException("Given slotContainer was empty"));
        Slot last = slotContainer.last().orElseThrow(() -> new NoSuchElementException("Given slotContainer was empty"));

        Preconditions.checkArgument(first.getRawIndex() != last.getRawIndex(), "Minimum size of horizontal scrollbar is 2");

        first.setComponent(previousPageBtn);
        buttons.put(first.getRawIndex(), previousPageBtn);

        last.setComponent(nextPageBtn);
        buttons.put(last.getRawIndex(), nextPageBtn);
    }
}
