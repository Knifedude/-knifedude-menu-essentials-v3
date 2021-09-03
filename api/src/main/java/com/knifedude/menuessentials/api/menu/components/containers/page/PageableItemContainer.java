package com.knifedude.menuessentials.api.menu.components.containers.page;

import com.knifedude.menuessentials.api.collection.PageSource;
import com.knifedude.menuessentials.api.menu.behaviors.Pageable;
import com.knifedude.menuessentials.api.menu.components.containers.ContainerComponent;
import com.knifedude.menuessentials.api.menu.event.listeners.PageChangeListener;
import com.knifedude.menuessentials.api.menu.slot.SlotComponent;
import com.knifedude.menuessentials.api.menu.slot.SlotContainer;

public class PageableItemContainer extends ContainerComponent<SlotContainer> implements Pageable {

    private PageSource<SlotComponent> pageSource;

    public PageableItemContainer(int width, int height) {
        super(width, height);
    }

    public void setSource(PageSource<SlotComponent> components) {

    }

    @Override
    public int getCurrentPageIndex() {
        return 0;
    }

    @Override
    public boolean hasNextPage() {
        return false;
    }

    @Override
    public boolean hasPreviousPage() {
        return false;
    }

    @Override
    public void nextPage() {

    }

    @Override
    public void previousPage() {

    }

    @Override
    public void addPageListener(PageChangeListener listener) {

    }

}
