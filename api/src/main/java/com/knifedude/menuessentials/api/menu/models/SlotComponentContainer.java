package com.knifedude.menuessentials.api.menu.models;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SlotComponentContainer extends MenuComponent {
    private final Map<UUID, SlotComponent> componentsByUUID;
    private final Map<Integer, SlotComponent> componentsBySlotIndex;
    private final int width, height;

    public SlotComponentContainer(int width, int height) {
        this.componentsByUUID = new HashMap<>();
        this.componentsBySlotIndex = new HashMap<>();
        this.width = width;
        this.height = height;
    }

    void attach() {

    }

    void detach() {

    }

    public int height() {
        return height;
    }

    public int width() {
        return width;
    }

    public int size() {
        return height * width;
    }

    private void checkIndexWithinBounds(int index) {
        if (index < 0 || index >= (width * height)) throw new IndexOutOfBoundsException(String.format("Index must be within bounds (>= 0 and < %d) but was (%d)", size(), index));
    }

    public Optional<SlotComponent> findByUUID(UUID componentUUID) {
        return Optional.ofNullable(componentsByUUID.get(componentUUID));
    }

    public Optional<SlotComponent> findByIndex(int slotIndex) {
        return Optional.ofNullable(componentsBySlotIndex.get(slotIndex));
    }

    public Stream<SlotComponent> find(Predicate<SlotComponent> criteria) {
        return componentsByUUID.values().stream().filter(criteria);
    }

    public void addComponent(int index, SlotComponent component) {
        checkIndexWithinBounds(index);
        this.componentsByUUID.put(component.getUniqueId(), component);
    }

    public void addComponent(int index, SlotComponent component, String... tags) {
        checkIndexWithinBounds(index);
        this.componentsByUUID.put(component.getUniqueId(), component);
        if (tags != null && tags.length > 0) {
            for (String tag : tags) {
                component.tags().add(tag);
            }
        }
    }

    public void removeComponent(Predicate<MenuComponent> criteria) {
        Map<UUID,MenuComponent> components = componentsByUUID.entrySet()
                        .stream()
                        .filter(entry -> criteria.test(entry.getValue()))
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        if (components.isEmpty()) return;

        components.forEach();

    }

    public void removeMenuComponent(UUID componentId) {

    }







}
