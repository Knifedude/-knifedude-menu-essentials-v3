package com.knifedude.menuessentials.api.menu;

import com.google.common.base.Preconditions;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class SlotComponentContainer extends MenuComponent {

    private final Map<String, MenuComponent> componentsByID;
    private final Map<UUID, MenuComponent> componentsByUUID;

    public SlotComponentContainer() {
        this.componentsByID = new HashMap<>();
        this.componentsByUUID = new HashMap<>();
    }

    public void addComponent(MenuComponent component) {
        this.componentsByUUID.put(component.getUniqueId(), component);
    }





}
