package com.knifedude.menuessentials.api.menu.components.buttons.navigation;

import com.knifedude.menuessentials.api.item.models.ItemType;
import com.knifedude.menuessentials.api.menu.components.buttons.Button;
import com.knifedude.menuessentials.api.menu.slot.SlotComponent;
import com.knifedude.menuessentials.api.text.models.Text;

import java.util.Collection;
import java.util.function.Supplier;

public interface NavigationButtonFactory {

    Button create(ItemType itemType, Text title, String target, Supplier<Collection<SlotComponent>> componentSupplier);

}
