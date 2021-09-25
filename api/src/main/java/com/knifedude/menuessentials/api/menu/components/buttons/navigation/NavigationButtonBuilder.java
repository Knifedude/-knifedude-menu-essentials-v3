package com.knifedude.menuessentials.api.menu.components.buttons.navigation;

import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.knifedude.menuessentials.api.collection.PageSource;
import com.knifedude.menuessentials.api.common.register.Register;
import com.knifedude.menuessentials.api.menu.components.buttons.ButtonBuilder;
import com.knifedude.menuessentials.api.menu.components.containers.item.PageableItemContainer;
import com.knifedude.menuessentials.api.menu.slot.SlotComponent;
import java.util.Collection;

public interface NavigationButtonBuilder <TInstance extends NavigationButton,TBuilder extends NavigationButtonBuilder<TInstance,TBuilder>> extends ButtonBuilder<TInstance,TBuilder> {

    TBuilder withPageSource(PageSource<SlotComponent> pageSource);

    default TBuilder withPageSource(Collection<SlotComponent> pageSource) {
        Preconditions.checkNotNull(pageSource, "Can't create pageSource from null collection");
        return withPageSource(PageSource.from(pageSource));
    }

    TBuilder withTarget(PageableItemContainer container);

    static NavigationButtonBuilder<?,?> builder() {
        return Register.getBuilder(NavigationButtonBuilder.class);
    }

}
