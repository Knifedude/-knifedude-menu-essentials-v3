package com.knifedude.menuessentials.api.menu.slot;

import java.util.List;

public class SlotRow extends SlotContainer {

    private List<Slot> slots;

    SlotRow(List<Slot> slots, int width) {
        super(slots, width, 1);
        this.slots = slots;
    }

}
