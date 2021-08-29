package com.knifedude.menuessentials.api.menu;

import com.knifedude.menuessentials.api.inventory.model.InventoryFactory;
import com.knifedude.menuessentials.api.menu.data.MenuHeight;
import com.knifedude.menuessentials.api.menu.data.MenuWidth;

import java.util.function.Consumer;

public final class MenuFactory {

    private final InventoryFactory inventoryFactory;

    public MenuFactory(InventoryFactory inventoryFactory) {
        this.inventoryFactory = inventoryFactory;
    }

    public Menu createFrom(MenuWidth width, MenuHeight height, Consumer<MenuView> init) {
        MenuViewFactory menuViewFactory = new MenuViewFactory(init, () -> inventoryFactory.create(width.getValue(),height.getValue()));
        return new Menu(menuViewFactory, viewRegister);
    }

    public Menu createFrom(MenuTemplate template) {
        throw new UnsupportedOperationException();
    }

}
