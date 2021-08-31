package com.knifedude.menuessentials.api.menu.components.containers;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.knifedude.menuessentials.api.menu.MenuViewContext;
import com.knifedude.menuessentials.api.menu.slot.SlotComponent;
import com.knifedude.menuessentials.api.menu.slot.SlotContainer;

import java.util.Map;

public abstract class ContainerComponent<TSlotContainer extends SlotContainer>  {

    private int width, height;
    private Map<Integer, SlotComponent> components;
    private SlotContainer container;

    public ContainerComponent(int width, int height) {
        this.width = width;
        this.height = height;
        this.components = Maps.newHashMap();
    }

    void setContainer(SlotContainer container) {
        Preconditions.checkArgument(container.width() == this.width, "Given container didn't match this components width");
        Preconditions.checkArgument(container.height() == this.height, "Given container didn't match this components height");

        if (this.container != null) {
            this.container.clear();
        }
        this.container = container;


    }



}
