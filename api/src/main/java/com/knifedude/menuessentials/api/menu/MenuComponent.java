package com.knifedude.menuessentials.api.menu;

import com.knifedude.menuessentials.api.common.models.Identifiable;

import java.util.UUID;

public class MenuComponent implements Identifiable {

    private UUID componentUUID = UUID.randomUUID();

    public MenuComponent() {
    }

    public UUID getUniqueId() {
        return componentUUID;
    }
}



