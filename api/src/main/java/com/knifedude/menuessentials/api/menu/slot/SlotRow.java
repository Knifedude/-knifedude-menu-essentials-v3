package com.knifedude.menuessentials.api.menu.slot;

import com.knifedude.menuessentials.api.menu.shapes.Point;
import com.knifedude.menuessentials.api.menu.shapes.Rectangle;

public class SlotRow extends SlotContainer {

    SlotRow(SlotContainer container, int width) {
        super(container, Rectangle.of(Point.of(0,0), Point.of(width, 0)));
    }

}
