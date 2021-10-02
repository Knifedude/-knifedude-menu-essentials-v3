package com.knifedude.menuessentials.api.menu;

import com.knifedude.menuessentials.api.inventory.model.InventoryFactory;
import com.knifedude.menuessentials.api.menu.data.MenuHeight;
import com.knifedude.menuessentials.api.menu.data.MenuWidth;

import java.util.function.Consumer;

public final class MenuFactory {

    private final InventoryFactory inventoryFactory;
    private final MenuViewRegister viewRegister;

    public MenuFactory(InventoryFactory inventoryFactory, MenuViewRegister viewRegister) {
        this.inventoryFactory = inventoryFactory;
        this.viewRegister = viewRegister;
    }

    public Menu createFrom(MenuWidth width, MenuHeight height, Consumer<MenuView> init) {
        MenuViewFactory menuViewFactory = new MenuViewFactory(init, () -> inventoryFactory.create(width.getValue(),height.getValue()), viewRegister);
        return new Menu(menuViewFactory, viewRegister);
    }


}
