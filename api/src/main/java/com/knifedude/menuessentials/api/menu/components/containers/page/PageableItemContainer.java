package com.knifedude.menuessentials.api.menu.components.containers.page;

import com.google.common.collect.Lists;
import com.knifedude.menuessentials.api.collection.PageSource;
import com.knifedude.menuessentials.api.menu.behaviors.Pageable;
import com.knifedude.menuessentials.api.menu.components.containers.ContainerComponent;
import com.knifedude.menuessentials.api.menu.event.listeners.PageChangeListener;
import com.knifedude.menuessentials.api.menu.slot.SlotComponent;
import com.knifedude.menuessentials.api.menu.slot.SlotContainer;

import java.util.Collection;
import java.util.List;

public class PageableItemContainer extends ContainerComponent<SlotContainer> implements Pageable {

    private final List<PageChangeListener> pageChangeListeners;
    private PageSource<SlotComponent> pageSource;
    private int currentPageIndex = 0;

    public PageableItemContainer(int width, int height) {
        super(width, height);

        this.pageChangeListeners = Lists.newArrayList();
    }

    public void setSource(Collection<SlotComponent> components) {
        this.setSource(PageSource.from(components));
    }

    public void setSource(PageSource<SlotComponent> source) {
        this.pageSource = source;
        this.currentPageIndex = 0;
        clear();

        if (this.pageSource.hasPage(currentPageIndex, getNrOfItemsPerPage())) {
             setComponents(this.pageSource.getPage(currentPageIndex, getNrOfItemsPerPage()));
        }
    }

    public int getNrOfItemsPerPage() {
        return size() - 1;
    }

    @Override
    public int getCurrentPageIndex() {
        return currentPageIndex;
    }

    @Override
    public boolean hasNextPage() {
        return pageSource != null && pageSource.hasPage(currentPageIndex + 1, getNrOfItemsPerPage());
    }

    @Override
    public boolean hasPreviousPage() {
        return pageSource != null && pageSource.hasPage(currentPageIndex - 1, getNrOfItemsPerPage());
    }

    @Override
    public void nextPage() {
        if (hasNextPage()) {
            clear();
            setComponents(pageSource.getPage(currentPageIndex + 1, getNrOfItemsPerPage()));
            currentPageIndex++;
        }
    }

    @Override
    public void previousPage() {
        if (hasPreviousPage()) {
            clear();
            setComponents(pageSource.getPage(currentPageIndex -1, getNrOfItemsPerPage()));
            currentPageIndex--;
        }
    }

    private void setComponents(Collection<SlotComponent> components) {
        int index = 0;
        for (SlotComponent component : components) {
            setComponent(index++, component);
        }
    }


    @Override
    public void addPageListener(PageChangeListener listener) {
        this.pageChangeListeners.add(listener);
    }


}
