package com.knifedude.menuessentials.api.menu.examples;

import com.knifedude.menuessentials.api.MenuEssentialsAPI;
import com.knifedude.menuessentials.api.item.models.ItemType;
import com.knifedude.menuessentials.api.menu.Menu;
import com.knifedude.menuessentials.api.menu.ToolBox;
import com.knifedude.menuessentials.api.menu.data.MenuHeight;
import com.knifedude.menuessentials.api.menu.data.MenuWidth;
import com.knifedude.menuessentials.api.menu.slot.SlotContainer;

public class Example {

    public static void main(String... args) {

        ToolBox tb = MenuEssentialsAPI.tools();

        Menu menu = tb.createMenu(MenuWidth.NINE, MenuHeight.SIX, menuView -> {
            // Init
            SlotContainer topBar = menuView.createFromRow("top-bar", 0);
            topBar.getSlot(0).setComponent(
                tb.newNavigationButton()
                  .withDisplayItem(ItemType.from("minecraft:nether_star"))
                        .w
            );



        });


    }
}
