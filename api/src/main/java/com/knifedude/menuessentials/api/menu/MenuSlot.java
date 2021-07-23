package com.knifedude.menuessentials.api.menu;

import com.knifedude.menuessentials.api.collection.TagCollection;

public final class MenuSlot {

    private MenuComponent component;
    private TagCollection tags;

    MenuSlot() {
        this.tags = new TagCollection();
    }

    public TagCollection tags() {
        return tags;
    }


}
