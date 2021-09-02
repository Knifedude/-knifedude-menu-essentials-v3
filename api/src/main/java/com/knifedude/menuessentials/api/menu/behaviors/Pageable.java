package com.knifedude.menuessentials.api.menu.behaviors;

import com.knifedude.menuessentials.api.menu.event.listeners.PageChangeListener;

public interface Pageable {

    int getCurrentPageIndex();

    default int getNextPageIndex() {
        return getCurrentPageIndex() + 1;
    }

    default int getPreviousPageIndex() {
        return getCurrentPageIndex() - 1;
    }

    boolean hasNextPage();

    boolean hasPreviousPage();

    void nextPage();

    void previousPage();

    void addPageListener(PageChangeListener listener);

}
