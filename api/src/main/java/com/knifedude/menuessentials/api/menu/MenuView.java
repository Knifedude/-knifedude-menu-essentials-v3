package com.knifedude.menuessentials.api.menu;

import com.knifedude.menuessentials.api.common.validation.Assert;
import com.knifedude.menuessentials.api.inventory.model.Inventory;

public final class MenuView {

    private final Inventory inventory;

    MenuView(Inventory inventory) {
        Assert.notNull(inventory, "inventory");
        this.inventory = inventory;
    }

    public int size() {
        return width() * height();
    }

    public int width() {
        return inventory.width();
    }

    public int height() {
        return inventory.height();
    }







}
