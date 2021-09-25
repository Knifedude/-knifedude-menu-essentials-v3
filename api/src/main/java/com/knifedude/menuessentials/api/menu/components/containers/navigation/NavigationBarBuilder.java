package com.knifedude.menuessentials.api.menu.components.containers.navigation;

import com.knifedude.menuessentials.api.item.models.ItemType;
import com.knifedude.menuessentials.api.menu.slot.SlotComponent;
import com.knifedude.menuessentials.api.menu.slot.SlotRow;
import com.knifedude.menuessentials.api.text.models.Text;

import java.util.Collection;
import java.util.function.Supplier;

public interface NavigationBarBuilder {

    NavigationBarBuilder withContainer(SlotRow slots);

    NavigationBarBuilder withTarget(String targetContainer);

    NavigationBarBuilder withNavigationButton(int index, Text title, ItemType itemType, Collection<SlotComponent> collection);

    default NavigationBarBuilder withNavigationButton(int index, String title, ItemType itemType, Collection<SlotComponent> collection) {
        return withNavigationButton(index, Text.of(title), itemType, collection);
    }

    NavigationBar build();

}
