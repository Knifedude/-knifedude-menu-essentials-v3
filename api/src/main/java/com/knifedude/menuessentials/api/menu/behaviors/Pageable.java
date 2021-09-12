package com.knifedude.menuessentials.api.menu.behaviors;

import com.knifedude.menuessentials.api.menu.MenuComponent;
import com.knifedude.menuessentials.api.menu.components.buttons.page.PageButton;
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

    void registerPageButton(PageButton button);

    void unregisterPageButton(PageButton button);

}
