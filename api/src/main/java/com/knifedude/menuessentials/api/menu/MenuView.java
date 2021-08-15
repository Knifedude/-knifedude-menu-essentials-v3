package com.knifedude.menuessentials.api.menu;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.Maps;
import com.knifedude.menuessentials.api.common.validation.Assert;
import com.knifedude.menuessentials.api.inventory.model.Inventory;

import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public final class MenuView {

    private final Inventory inventory;
    private final Map<Integer,MenuSlot> slots;
    private final Function<Integer, MenuSlot> slotFactory;

    MenuView(Inventory inventory) {
        Assert.notNull(inventory, "inventory");

        this.inventory = inventory;
        this.slotFactory = (i) -> new MenuSlot(inventory.getSlot(i));
        this.slots = Maps.newHashMap();
    }

    public int size() {
        return width() * height();
    }

    public int width() {
        return inventory.width();
    }

    public int height() {
        return inventory.height();
    }

    public MenuSlot getSlot(int index) {
        Preconditions.checkArgument(index >= 0, "Index must be >= 0");
        Preconditions.checkArgument(index <= size(), "Index must be < size()");
        slots.computeIfAbsent(index, slotFactory);
        return slots.get(index);
    }

    public Stream<MenuSlot> slots() {
        return IntStream.range(0, size()).mapToObj(this::getSlot);
    }

    public Collection<MenuSlot> getRow(int row) {
        if (row < 0) throw new IndexOutOfBoundsException(String.format("Argument 'row' was not within bounds (min: 0 and max:%d)", height()));
        if (row >= height()) throw new IndexOutOfBoundsException(String.format("Argument 'row' was not within bounds (min: 0 and max:%d)", height()));

         int start = row * width();
         return IntStream.range(start, start + width())
                 .mapToObj(this::getSlot)
                 .collect(Collectors.toList());
    }

    public Collection<MenuSlot> getColumn(int column) {
        if (column < 0) throw new IndexOutOfBoundsException(String.format("Argument 'row' was not within bounds (min: 0 and max:%d)", height()));
        if (column >= width()) throw new IndexOutOfBoundsException(String.format("Argument 'row' was not within bounds (min: 0 and max:%d)", height()));

        return IntStream.range(0, height())
                 .map(i -> (i * width()) + column)
                 .mapToObj(this::getSlot)
                 .collect(Collectors.toList());
    }




}
