package com.knifedude.menuessentials.api.menu;

import com.knifedude.menuessentials.api.common.models.Identifiable;

import java.util.UUID;

public class MenuComponent implements Identifiable {

    private final UUID componentUUID = UUID.randomUUID();

    public MenuComponent() {
    }

    /**
     * Gets the unique component id. The id is unique for each instance
     * @return
     */
    public final UUID getUniqueId() {
        return componentUUID;
    }


}



