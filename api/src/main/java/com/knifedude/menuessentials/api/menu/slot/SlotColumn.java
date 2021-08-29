package com.knifedude.menuessentials.api.menu.slot;

import java.util.List;

public class SlotColumn extends SlotContainer {

    private List<Slot> slots;

    SlotColumn(List<Slot> slots, int height) {
        super(slots, 1, height);
        this.slots = slots;
    }

}
