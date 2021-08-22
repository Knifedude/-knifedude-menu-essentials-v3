package com.knifedude.menuessentials.api.menu;

import com.knifedude.menuessentials.api.inventory.model.Inventory;
import com.knifedude.menuessentials.api.player.models.Player;
import java.util.function.Consumer;
import java.util.function.Supplier;

class MenuViewFactory {

    private final Consumer<MenuView> init;
    private final Supplier<Inventory> inventorySupplier;

    MenuViewFactory(Consumer<MenuView> init, Supplier<Inventory> inventorySupplier) {
        this.init = init;
        this.inventorySupplier = inventorySupplier;
    }

    public MenuView create(Player player) {
        Inventory inventory = inventorySupplier.get();
        MenuView view = new MenuView(inventory, player);
        init.accept(view);
        return view;
    }



}
