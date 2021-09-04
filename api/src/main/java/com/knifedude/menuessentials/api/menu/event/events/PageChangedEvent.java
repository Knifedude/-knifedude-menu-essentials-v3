package com.knifedude.menuessentials.api.menu.event.events;

import com.knifedude.menuessentials.api.menu.behaviors.Pageable;

public class PageChangedEvent {

    private Pageable target;

    public PageChangedEvent(Pageable target) {
        this.target = target;
    }

    public Pageable getTarget() {
        return target;
    }
}
