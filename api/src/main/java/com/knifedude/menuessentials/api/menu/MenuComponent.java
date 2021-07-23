package com.knifedude.menuessentials.api.menu;

import com.knifedude.menuessentials.api.collection.TagCollection;
import com.knifedude.menuessentials.api.common.models.Identifiable;

import java.util.UUID;

public class MenuComponent implements Identifiable {

    private final UUID componentUUID = UUID.randomUUID();
    private final TagCollection tags;


    public MenuComponent() {
        this.tags = new TagCollection();
    }

    /**
     * Gets the unique component id. The id is unique for each instance
     * @return
     */
    public final UUID getUniqueId() {
        return componentUUID;
    }

    public TagCollection tags() {
        return tags;
    }

}



