package com.knifedude.menuessentials.api.menu.models;

import com.knifedude.menuessentials.api.collection.TagCollection;
import com.knifedude.menuessentials.api.common.models.Taggable;

public final class MenuSlot implements Taggable {

    private MenuComponent component;
    private TagCollection tags;

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

    public void setComponent(MenuComponent component) {
        this.component = component;
    }



}
