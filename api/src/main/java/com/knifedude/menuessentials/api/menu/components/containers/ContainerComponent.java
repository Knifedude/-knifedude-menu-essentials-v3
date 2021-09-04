package com.knifedude.menuessentials.api.menu.components.containers;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.knifedude.menuessentials.api.menu.slot.SlotComponent;
import com.knifedude.menuessentials.api.menu.slot.SlotContainer;

import java.util.Map;

public abstract class ContainerComponent<TSlotContainer extends SlotContainer>  {

    private final int width, height;
    private final Map<Integer, SlotComponent> components;
    private SlotContainer container;

    public ContainerComponent(int width, int height) {
        Preconditions.checkArgument(width >= 1, "Width must be >= 1");
        Preconditions.checkArgument(height >= 1, "Height must be >= 1");
        this.width = width;
        this.height = height;
        this.components = Maps.newHashMap();
    }

    public final int size() {
        return width * height;
    }

    void detach() {
        if (this.container != null) {
            this.container.clear();
            this.container = null;
        }
    }

    void attach(SlotContainer container) {
        Preconditions.checkNotNull(container, "Can't attach to null container, user detach() instead");
        Preconditions.checkArgument(container.width() == this.width, "Given container didn't match this components width");
        Preconditions.checkArgument(container.height() == this.height, "Given container didn't match this components height");

        detach();

        this.container = container;
        components.forEach((key, value) -> container.getSlot(key).setComponent(value));
    }

    protected final void setComponent(int index, SlotComponent component) {
        Preconditions.checkArgument(index >= 0, "Index must be >= 0");
        Preconditions.checkArgument(index < (width * height), String.format("Index must be within bounds (<%d) but was %d", width * height, index));

        if (component != null) {
            this.components.put(index, component);
            if (container != null) {
                container.getSlot(index).setComponent(component);
            }
        } else {
            this.components.remove(index);
            if (container != null) {
                container.getSlot(index).clear();
            }
        }
    }

    protected final void setComponent(int x, int y, SlotComponent component) {
        int index = y * width + x;
        setComponent(index, component);
    }

    protected final void setFirstSlot(SlotComponent slotComponent) {
        setComponent(0, slotComponent);
    }

    protected final void setLastSlot(SlotComponent slotComponent) {

    }

    protected final void removeComponent(int index) {
        setComponent(index, null);
    }

    protected final void clear() {
        this.components.clear();
        if (container != null) {
            container.clear();
        }
    }



}
