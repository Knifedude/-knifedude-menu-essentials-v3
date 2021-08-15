package com.knifedude.menuessentials.api.menu;

import com.knifedude.menuessentials.api.collection.TagCollection;
import com.knifedude.menuessentials.api.common.models.Taggable;
import com.knifedude.menuessentials.api.inventory.model.InventorySlot;

public final class MenuSlot implements Taggable {

    private SlotComponent component;
    private TagCollection tags;
    private InventorySlot inventorySlot;

    public MenuSlot(InventorySlot inventorySlot) {
        this.inventorySlot = inventorySlot;
        this.tags = new TagCollection();
    }

    public TagCollection tags() {
        return tags;
    }

    public boolean hasComponent() {
        return component != null;
    }

    public boolean isEmpty() {
        return component == null;
    }

    public void setComponent(SlotComponent newComponent) {

        // case-1: The slot is empty
        if (this.component == null) {
            this.component = newComponent;
            this.component.attach(this);
            this.render(component);

        // case-2: The incoming component is null
        } else if (newComponent == null) {
            clear();

        // case-3: The slot already has this exact component -> UPDATE
        } else if (this.component.matchesId(newComponent)) {
            this.render(newComponent);

        // case-4: Replace existing component
        } else {
            clear();
            this.component = newComponent;
            component.attach(this);
            this.render(component);
        }
    }

    private void render(SlotComponent component) {
        if (component.isVisible()) {
            this.inventorySlot.setItemStack(component.getDisplayItem());
        } else {
            this.inventorySlot.clear();
        }
    }

    public void clear() {
        inventorySlot.clear();
        if (this.component != null) {
            SlotComponent old = component;
            this.component = null;
            old.detach();
        }
    }

}
