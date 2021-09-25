package com.knifedude.menuessentials.api.menu.components.containers.item;

import com.knifedude.menuessentials.api.common.register.Register;
import com.knifedude.menuessentials.api.menu.slot.SlotContainer;

public interface PageableItemContainerBuilder {

    PageableItemContainerBuilder withContainer(SlotContainer container);

    PageableItemContainer build();

    static PageableItemContainerBuilder builder() {
        return Register.getBuilder(PageableItemContainerBuilder.class);
    }

}
