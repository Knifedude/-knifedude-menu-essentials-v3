package com.knifedude.menuessentials.api.menu.slot;

import com.knifedude.menuessentials.api.menu.shapes.Point;
import com.knifedude.menuessentials.api.menu.shapes.Rectangle;

public class SlotColumn extends SlotContainer {

    SlotColumn(SlotContainer container, int height) {
        super(container, Rectangle.of(Point.of(0,0), Point.of(0, height)));
    }

}
