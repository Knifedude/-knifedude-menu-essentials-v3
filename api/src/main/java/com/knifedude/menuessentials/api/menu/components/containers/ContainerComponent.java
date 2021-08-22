package com.knifedude.menuessentials.api.menu.components.containers;

import com.knifedude.menuessentials.api.menu.MenuViewContext;
import com.knifedude.menuessentials.api.menu.slot.SlotContainer;

public abstract class ContainerComponent<TSlotContainer extends SlotContainer>  {

    protected abstract void init(TSlotContainer slotContainer, MenuViewContext context);

}
