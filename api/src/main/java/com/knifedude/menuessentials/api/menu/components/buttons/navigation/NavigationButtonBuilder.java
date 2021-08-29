package com.knifedude.menuessentials.api.menu.components.buttons.navigation;

import com.knifedude.menuessentials.api.menu.components.buttons.Button;
import com.knifedude.menuessentials.api.menu.components.buttons.ButtonBuilder;
import com.knifedude.menuessentials.api.menu.slot.SlotComponent;

import java.util.Collection;
import java.util.function.Supplier;

public interface NavigationButtonBuilder <TInstance extends Button,TBuilder extends NavigationButtonBuilder<TInstance,TBuilder>> extends ButtonBuilder<TInstance,TBuilder> {

    TBuilder withCollectionSupplier(Supplier<Collection<SlotComponent>> componentSupplier);

    TBuilder withContainerTarget(String containerName);

}
