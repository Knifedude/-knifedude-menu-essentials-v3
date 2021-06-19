package com.knifedude.menuessentials.api.menu;

import com.google.common.base.Preconditions;

import java.util.Map;
import java.util.UUID;

public class MenuContainer {

    private final Map<String, MenuComponent> componentsByID;
    private final Map<UUID, MenuComponent> componentsByUUID;

    public MenuContainer() {
        this.componentsByID = new HashMap<>();
        this.componentsByUUID = new HashMap<>();
    }

    public void addComponent(MenuComponent component) {
        this.componentsByUUID.put(component.getUniqueId(), component);
    }

    public void addComponent(MenuComponent component, String id) {
        Preconditions.checkNotNull(id, "Argument 'id' is can't be null");
        Preconditions.checkArgument(hasComponentWithId(id), String.format("Already has a component with id"));

        this.addComponent(component);

    }

    public boolean hasComponentWithId(String id) {
        return componentsByID.containsKey(id);
    }



}
