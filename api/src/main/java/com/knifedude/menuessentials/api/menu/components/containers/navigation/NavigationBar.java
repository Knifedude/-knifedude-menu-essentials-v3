package com.knifedude.menuessentials.api.menu.components.containers.navigation;

import com.knifedude.menuessentials.api.item.models.ItemType;
import com.knifedude.menuessentials.api.menu.components.buttons.Button;
import com.knifedude.menuessentials.api.menu.slot.SlotComponent;
import com.knifedude.menuessentials.api.text.models.Text;

import java.util.Collection;
import java.util.function.Supplier;

public interface NavigationBar {

    Button createNavigationButton(int index, Text title, ItemType itemType, Supplier<Collection<SlotComponent>> supplier);

    default Button createNavigationButton(int index, String title, ItemType itemType, Supplier<Collection<SlotComponent>> supplier) {
        return createNavigationButton(index, Text.of(title), itemType, supplier);
    }

}
