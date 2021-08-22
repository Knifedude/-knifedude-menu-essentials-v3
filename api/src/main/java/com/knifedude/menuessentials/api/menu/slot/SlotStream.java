package com.knifedude.menuessentials.api.menu.slot;

import com.knifedude.menuessentials.api.menu.Matching;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SlotStream {

    public Stream<Slot> slotStream;

    public SlotStream(Stream<Slot> slotStream) {
        this.slotStream = slotStream;
    }

    public Stream<Slot> raw() {
        return slotStream;
    }

    public SlotStream hasComponent() {
        this.slotStream = slotStream.filter(Slot::hasComponent);
        return this;
    }

    public SlotStream isEmpty() {
        this.slotStream = slotStream.filter(Slot::isEmpty);
        return this;
    }

    public SlotStream matching(Predicate<Slot> criteria) {
        this.slotStream = slotStream.filter(criteria);
        return this;
    }

    public SlotStream matchingAllTags(String... tags) {
        this.slotStream = slotStream.filter(Matching.allTags(tags));
        return this;
    }

    public SlotStream matchingAnyTags(String... tags) {
        this.slotStream = slotStream.filter(Matching.anyTags(tags));
        return this;
    }

    public Optional<Slot> collectFirst() {
        return slotStream.findFirst();
    }

    public Optional<Slot> collectAny() {
        return slotStream.findAny();
    }

    public List<Slot> collectList() {
        return slotStream.collect(Collectors.toList());
    }

    public void forEach(Consumer<Slot> csr) {
        slotStream.forEach(csr);
    }

}
