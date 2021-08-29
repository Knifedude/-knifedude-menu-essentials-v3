package com.knifedude.menuessentials.api.menu;

import com.knifedude.menuessentials.api.inventory.model.Inventory;
import com.knifedude.menuessentials.api.player.models.Player;
import java.util.function.Consumer;
import java.util.function.Supplier;

class MenuViewFactory {

    private final Consumer<MenuView> init;
    private final Supplier<Inventory> inventorySupplier;
    private final MenuViewRegister viewRegister;

    MenuViewFactory(Consumer<MenuView> init, Supplier<Inventory> inventorySupplier, MenuViewRegister viewRegister) {
        this.init = init;
        this.inventorySupplier = inventorySupplier;
        this.viewRegister = viewRegister;
    }

    public MenuView create(Player player) {
        Inventory inventory = inventorySupplier.get();
        MenuView view = new MenuView(inventory, player, viewRegister);
        init.accept(view);
        return view;
    }



}
