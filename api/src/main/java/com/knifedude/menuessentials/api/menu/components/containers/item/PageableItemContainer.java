package com.knifedude.menuessentials.api.menu.components.containers.item;

import com.google.common.collect.Maps;
import com.knifedude.menuessentials.api.collection.PageSource;
import com.knifedude.menuessentials.api.menu.behaviors.Pageable;
import com.knifedude.menuessentials.api.menu.components.buttons.page.PageButton;
import com.knifedude.menuessentials.api.menu.event.events.PageChangedEvent;
import com.knifedude.menuessentials.api.menu.slot.SlotComponent;
import com.knifedude.menuessentials.api.menu.slot.SlotContainer;

import javax.annotation.Nullable;
import java.util.Collection;
import java.util.Map;
import java.util.UUID;

public class PageableItemContainer extends ItemContainer<SlotContainer> implements Pageable {

    private final Map<UUID,PageButton> pageButtons;
    private PageSource<SlotComponent> pageSource;
    private int currentPageIndex = 0;

    public PageableItemContainer(int width, int height) {
        super(width, height);

        this.pageButtons = Maps.newHashMap();
    }

    public void goToPage(int pageIndex) {
        if (pageSource != null && pageSource.hasPage(pageIndex, getNrOfItemsPerPage())) {
            clear();
            Collection<SlotComponent> components = pageSource.getPage(pageIndex, getNrOfItemsPerPage());
            setComponents(components);
            triggerPageChangeEvent();
        }
    }

    public void setSource(@Nullable Collection<SlotComponent> components) {
        this.setSource(components != null ? PageSource.from(components) : null);
    }

    public void setSource(@Nullable PageSource<SlotComponent> source) {
        this.pageSource = source;
        this.currentPageIndex = 0;

        if (pageSource != null) {
            goToPage(currentPageIndex);
        } else {
            clear();
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
            currentPageIndex++;
            goToPage(currentPageIndex);
        }
    }

    @Override
    public void previousPage() {
        if (hasPreviousPage()) {
            currentPageIndex--;
            goToPage(currentPageIndex);
        }
    }

    private void setComponents(Collection<SlotComponent> components) {
        int index = 0;
        for (SlotComponent component : components) {
            setComponent(index++, component);
        }
    }

    @Override
    public void registerPageButton(PageButton pageButton) {
        this.pageButtons.put(pageButton.getUniqueId(), pageButton);
    }

    @Override
    public void unregisterPageButton(PageButton button) {
        this.pageButtons.remove(button.getUniqueId());
    }

    private void triggerPageChangeEvent() {
        PageChangedEvent event = new PageChangedEvent(this);
        this.pageButtons.values().forEach(pageButton -> pageButton.onPageChange(event));
    }

}

