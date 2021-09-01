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

    HorizontalScrollBar(int width, Button nextPageButton, Button previousPageButton) {
        super(width, 1);
        this.previousPageBtn = previousPageButton;
        this.nextPageBtn = nextPageButton;

        setComponent(0, previousPageButton);
        setComponent(width - 1, nextPageButton);
    }

}
