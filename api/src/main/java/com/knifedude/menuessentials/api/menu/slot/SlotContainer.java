package com.knifedude.menuessentials.api.menu.slot;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.knifedude.menuessentials.api.inventory.model.Inventory;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SlotContainer implements Iterable<Slot> {

    private final Map<Integer, Slot> slots;
    private final int width, height;
    private final SlotSource slotSource;

    SlotContainer(List<Slot> slots, int width, int height) {
        this.slots = new HashMap<>();
        this.width = width;
        this.height = height;
        this.slotSource = new ListSlotSource(slots); // Lazy init
    }

    public SlotContainer(Inventory inventory) {
        this.slots = Maps.newHashMap();
        this.width = inventory.width();
        this.height = inventory.height();
        this.slotSource = new InventorySlotSource(inventory); // Lazy init
    }

    public int size() {
        return width() * height();
    }

    public int width() {
        return width;
    }

    public int height() {
        return height;
    }

    public Slot getSlot(int index) {
        Preconditions.checkArgument(index >= 0, "Index must be >= 0");
        Preconditions.checkArgument(index <= size(), "Index must be < size()");

        slots.computeIfAbsent(index, slotSource::getSlot);
        return slots.get(index);
    }

    public Optional<Slot> first() {
        return Optional.ofNullable(getSlot(0));
    }

    public Optional<Slot> last() {
        return Optional.ofNullable(getSlot((width() * height()) - 1));
    }

    public SlotStream slots() {
        return new SlotStream(IntStream.range(0, size()).mapToObj(this::getSlot));
    }

    public SlotRow getSingleRow(int row) {
        if (row < 0) throw new IndexOutOfBoundsException(String.format("Argument 'row' was not within bounds (min: 0 and max:%d)", height()));
        if (row >= height()) throw new IndexOutOfBoundsException(String.format("Argument 'row' was not within bounds (min: 0 and max:%d)", height()));

        int start = row * width();
        List<Slot> slots = IntStream.range(start, start + width())
                .mapToObj(this::getSlot)
                .collect(Collectors.toList());

        return new SlotRow(slots, width);
    }

    public SlotColumn getSingleColumn(int column) {
        if (column < 0) throw new IndexOutOfBoundsException(String.format("Argument 'row' was not within bounds (min: 0 and max:%d)", height()));
        if (column >= width()) throw new IndexOutOfBoundsException(String.format("Argument 'row' was not within bounds (min: 0 and max:%d)", height()));

        List<Slot> slots = IntStream.range(0, height())
                .map(i -> (i * width()) + column)
                .mapToObj(this::getSlot)
                .collect(Collectors.toList());

        return new SlotColumn(slots, height);
    }

    public List<SlotColumn> getColumnsInRange(int fromColumnIndex, int toColumnIndex) {
        Preconditions.checkArgument(fromColumnIndex >= 0, "The argument 'fromColumnIndex' must be >= 0");
        Preconditions.checkArgument(toColumnIndex < width, String.format("The argument 'toColumnIndex' must be within bounds (between 0 and %d)", width));
        return IntStream.range(fromColumnIndex, toColumnIndex).mapToObj(this::getSingleColumn).collect(Collectors.toList());
    }

    public List<SlotContainer> getRowsInRange(int fromRowIndex, int toRowIndex) {
        Preconditions.checkArgument(fromRowIndex >= 0, "The argument 'fromColumnIndex' must be >= 0");
        Preconditions.checkArgument(toRowIndex < height, String.format("The argument 'toColumnIndex' must be within bounds (between 0 and %d)", width));



    }

    public void clear() {
        slots().forEach(Slot::clear);
    }

    @Override
    public Iterator<Slot> iterator() {
        return new SlotSourceIterator(slotSource);
    }

    private static class SlotSourceIterator implements Iterator<Slot> {

        private final SlotSource slotSource;
        private int count = -1;

        public SlotSourceIterator(SlotSource slotSource) {
            this.slotSource = slotSource;
        }

        @Override
        public boolean hasNext() {
            return slotSource.hasSlot(count + 1);
        }

        @Override
        public Slot next() {
            return slotSource.getSlot(++count);
        }
    }

    private interface SlotSource {

        Slot getSlot(int index);

        boolean hasSlot(int index);

    }

    private static class InventorySlotSource implements SlotSource {

        private final Inventory inventory;

        public InventorySlotSource(Inventory inventory) {
            this.inventory = inventory;
        }

        @Override
        public Slot getSlot(int index) {
            return new Slot(inventory.getSlot(index));
        }

        @Override
        public boolean hasSlot(int index) {
            return inventory.findSlot(index).isPresent();
        }

    }

    private static class ListSlotSource implements SlotSource {

        private final List<Slot> slots;

        public ListSlotSource(List<Slot> slots) {
            this.slots = slots;
        }

        @Override
        public Slot getSlot(int index) {
            return slots.get(index);
        }

        @Override
        public boolean hasSlot(int index) {
            return index >= 0 && index < slots.size();
        }
    }



}
