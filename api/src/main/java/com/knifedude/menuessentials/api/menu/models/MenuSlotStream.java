package com.knifedude.menuessentials.api.menu.models;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MenuSlotStream {

    public Stream<MenuSlot> slotStream;

    public MenuSlotStream(Stream<MenuSlot> slotStream) {
        this.slotStream = slotStream;
    }

    public Stream<MenuSlot> raw() {
        return slotStream;
    }

    public MenuSlotStream hasComponent() {
        this.slotStream = slotStream.filter(MenuSlot::hasComponent);
        return this;
    }

    public MenuSlotStream isEmpty() {
        this.slotStream = slotStream.filter(MenuSlot::isEmpty);
        return this;
    }

    public MenuSlotStream matching(Predicate<MenuSlot> criteria) {
        this.slotStream = slotStream.filter(criteria);
        return this;
    }

    public MenuSlotStream matchingAllTags(String... tags) {
        this.slotStream = slotStream.filter(Matching.allTags(tags));
        return this;
    }

    public MenuSlotStream matchingAnyTags(String... tags) {
        this.slotStream = slotStream.filter(Matching.anyTags(tags));
        return this;
    }

    public Optional<MenuSlot> collectFirst() {
        return slotStream.findFirst();
    }

    public Optional<MenuSlot> collectAny() {
        return slotStream.findAny();
    }

    public List<MenuSlot> collectList() {
        return slotStream.collect(Collectors.toList());
    }

    public void forEach(Consumer<MenuSlot> csr) {
        slotStream.forEach(csr);
    }

}
