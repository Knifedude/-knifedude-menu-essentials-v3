package com.knifedude.menuessentials.api.menu.handlers;

import com.knifedude.menuessentials.api.menu.ClickContext;

class WrappedClickHandler implements ClickHandler {

    private ClickHandler self, next;

    public WrappedClickHandler(ClickHandler self, ClickHandler next) {
        this.self = self;
        this.next = next;
    }

    @Override
    public void onClick(ClickContext clickContext) {
        self.onClick(clickContext);

    }

}
