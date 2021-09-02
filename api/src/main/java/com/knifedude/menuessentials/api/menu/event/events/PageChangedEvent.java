package com.knifedude.menuessentials.api.menu.event.events;

public class PageChangedEvent {

    private int fromPageIndex, toPageIndex;

    public PageChangedEvent(int fromPageIndex, int toPageIndex) {
        this.fromPageIndex = fromPageIndex;
        this.toPageIndex = toPageIndex;
    }

    public int getFromPageIndex() {
        return fromPageIndex;
    }

    public int getToPageIndex() {
        return toPageIndex;
    }


}
