package com.knifedude.menuessentials.api.menu.components.containers.navigation;

import com.google.common.base.Preconditions;
import com.knifedude.menuessentials.api.item.models.ItemType;
import com.knifedude.menuessentials.api.menu.components.buttons.Button;
import com.knifedude.menuessentials.api.menu.components.buttons.navigation.NavigationButton;
import com.knifedude.menuessentials.api.menu.components.buttons.navigation.NavigationButtonBuilder;
import com.knifedude.menuessentials.api.menu.components.containers.item.ItemContainer;
import com.knifedude.menuessentials.api.menu.components.containers.item.PageableItemContainer;
import com.knifedude.menuessentials.api.menu.slot.SlotComponent;
import com.knifedude.menuessentials.api.menu.slot.SlotRow;
import com.knifedude.menuessentials.api.text.models.Text;
import java.util.Collection;
import java.util.stream.Collectors;

public class NavigationBar extends ItemContainer<SlotRow> {

    private PageableItemContainer target;

    public NavigationBar(int width) {
        super(width, 1);
    }

    public Button createNavigationButton(int index, Text title, ItemType itemType, Collection<SlotComponent> collection) {
        Preconditions.checkArgument(index >= 0, "Index must be >= 0");
        Preconditions.checkArgument(index < width(), String.format("Index must be < width(%d)", width()));

        Button navigationButton = NavigationButtonBuilder.builder()
                        .withDisplayName(title)
                        .withDisplayItem(itemType)
                        .withTarget(target)
                        .withPageSource(collection)
                        .build();

        setComponent(index, navigationButton);
        return navigationButton;
    }

    public Button createNavigationButton(int index, String title, ItemType itemType, Collection<SlotComponent> collection) {
        return createNavigationButton(index, Text.of(title), itemType, collection);
    }

    public Collection<NavigationButton> getNavigationButtons() {
        return streamComponents()
                .filter(component -> (component instanceof NavigationButton))
                .map(component -> (NavigationButton) component)
                .collect(Collectors.toList());
    }

    public void setTarget(PageableItemContainer target) {
        this.target = target;
        getNavigationButtons().forEach(button -> button.setTargetContainer(target));
    }

}
