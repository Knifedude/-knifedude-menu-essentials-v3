package com.knifedude.menuessentials.api.menu.models;

import com.knifedude.menuessentials.api.collection.TagCollection;
import com.knifedude.menuessentials.api.common.models.Taggable;
import com.knifedude.menuessentials.api.inventory.model.InventorySlot;
import com.knifedude.menuessentials.api.item.models.ItemStack;

public final class MenuSlot implements Taggable {

    private SlotComponent component;
    private TagCollection tags;
    private InventorySlot inventorySlot;

    MenuSlot() {
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
            this.component.detach();

        // case-3: The slot already has this exact component -> UPDATE
        } else if (this.component.matchesId(newComponent)) {
            this.component = newComponent;
            this.render(newComponent);
        } else {
            clear();

        }


        if (this.component != null && newComponent != null && newComponent.getUniqueId().equals(this.component.getUniqueId())) {
            update(newComponent);
        } else {

            // 2) If we already have an component: detach!
            clear();
            this.component = newComponent;

            // 3) If the new component is not null. Attach and update
            if (this.component != null) {
                update(newComponent);
                this.component.attach(this);
            }
        }
    }

    private void render(SlotComponent component) {
        if (component.isVisible()) {
            this.inventorySlot.setItemStack(component.get());
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
