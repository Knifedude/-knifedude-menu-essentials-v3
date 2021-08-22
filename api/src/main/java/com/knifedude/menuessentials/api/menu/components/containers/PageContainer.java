package com.knifedude.menuessentials.api.menu.components.containers;

import com.google.common.collect.Lists;
import com.knifedude.menuessentials.api.collection.PageSource;
import com.knifedude.menuessentials.api.menu.MenuViewContext;
import com.knifedude.menuessentials.api.menu.events.Listener;
import com.knifedude.menuessentials.api.menu.events.PageChangedEvent;
import com.knifedude.menuessentials.api.menu.slot.Slot;
import com.knifedude.menuessentials.api.menu.slot.SlotComponent;
import com.knifedude.menuessentials.api.menu.slot.SlotContainer;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class PageContainer extends ContainerComponent<SlotContainer> {

    private int currentPage = 0;
    private PageSource<SlotComponent> source;
    private SlotContainer container;
    private List<Listener<PageChangedEvent>> pageChangeListeners;

    public PageContainer() {
        this.pageChangeListeners = Lists.newArrayList();
    }

    public void setSource(Collection<SlotComponent> source) {
        this.source = PageSource.from(source);
        currentPage = 0;
        setComponents();
    }

    private boolean goToPage(int index) {
        if (container != null && index != currentPage && source.hasPage(index)) {
            setSource(source.getPage(index, container.size()));

            PageChangedEvent event = new PageChangedEvent(currentPage, index);
            this.currentPage = index;
            pageChangeListeners.forEach(listener -> listener.onEvent(event));

            return true;
        }
        return false;
    }

    public void goToPreviousPage() {
        goToPage(currentPage - 1);
    }

    public void goToNextPage() {
        goToPage(currentPage + 1);
    }

    @Override
    protected void init(SlotContainer slotContainer, MenuViewContext context) {
        this.container = slotContainer;
        this.currentPage = 0;
        setComponents();
    }

    private void setComponents() {
        if (this.source != null && this.container != null) {
            Collection<SlotComponent> components = source.getPage(currentPage, container.size());

            Iterator<SlotComponent> componentIterator = components.iterator();
            Iterator<Slot> slotIterator = container.iterator();

            while(componentIterator.hasNext() && slotIterator.hasNext()) {
                SlotComponent component = componentIterator.next();
                Slot slot = slotIterator.next();
                slot.setComponent(component);
            }
        }
    }

}
