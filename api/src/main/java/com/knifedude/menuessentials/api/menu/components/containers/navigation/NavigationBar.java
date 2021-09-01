package com.knifedude.menuessentials.api.menu.components.containers.navigation;

import com.knifedude.menuessentials.api.item.models.ItemType;
import com.knifedude.menuessentials.api.menu.components.buttons.Button;
import com.knifedude.menuessentials.api.menu.components.buttons.navigation.NavigationButtonBuilder;
import com.knifedude.menuessentials.api.menu.components.containers.ContainerComponent;
import com.knifedude.menuessentials.api.menu.slot.SlotComponent;
import com.knifedude.menuessentials.api.menu.slot.SlotRow;
import com.knifedude.menuessentials.api.text.models.Text;
import java.util.Collection;
import java.util.function.Supplier;

public class NavigationBar extends ContainerComponent<SlotRow> {

    private final String targetContainer;

    public NavigationBar(String targetContainer, int width) {
        super(width, 1);

        this.targetContainer = targetContainer;
    }

    public Button createNavigationButton(int index, Text title, ItemType itemType, Supplier<Collection<SlotComponent>> supplier) {
        Button navigationButton = NavigationButtonBuilder.builder()
                        .withDisplayName(title)
                        .withDisplayItem(itemType)
                        .withCollectionSupplier(supplier)
                        .withContainerTarget(targetContainer)
                        .build();

        setComponent(index, navigationButton);
        return navigationButton;
    }

    public Button createNavigationButton(int index, String title, ItemType itemType, Supplier<Collection<SlotComponent>> supplier) {
        return createNavigationButton(index, Text.of(title), itemType, supplier);
    }

}
