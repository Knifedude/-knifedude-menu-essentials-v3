package com.knifedude.menuessentials.api.menu.examples;

import com.google.common.collect.Lists;
import com.knifedude.menuessentials.api.MenuEssentialsAPI;
import com.knifedude.menuessentials.api.item.models.ItemType;
import com.knifedude.menuessentials.api.menu.Menu;
import com.knifedude.menuessentials.api.menu.ToolBox;
import com.knifedude.menuessentials.api.menu.components.buttons.page.next.NextPageButton;
import com.knifedude.menuessentials.api.menu.components.buttons.page.next.NextPageButtonBuilder;
import com.knifedude.menuessentials.api.menu.components.buttons.page.previous.PreviousPageButton;
import com.knifedude.menuessentials.api.menu.components.buttons.page.previous.PreviousPageButtonBuilder;
import com.knifedude.menuessentials.api.menu.components.containers.item.PageableItemContainer;
import com.knifedude.menuessentials.api.menu.components.containers.item.PageableItemContainerBuilder;
import com.knifedude.menuessentials.api.menu.components.containers.navigation.NavigationBar;
import com.knifedude.menuessentials.api.menu.data.MenuHeight;
import com.knifedude.menuessentials.api.menu.data.MenuWidth;
import com.knifedude.menuessentials.api.menu.slot.SlotComponent;

import java.util.List;

public class Example {

    public static void main(String... args) {

        ToolBox tb = MenuEssentialsAPI.tools();

        List<SlotComponent> dummy = Lists.newArrayList();
        ItemType dummyType = null;

        Menu menu = tb.createMenu(MenuWidth.NINE, MenuHeight.SIX, menuView -> {
            // Init
            NavigationBar topBar = menuView.createFromRow("top-bar", 0, (row) ->
                tb.newNavigationBar()
                    .withContainer(row)
                    .withTarget("item-container")
                    .withNavigationButton(0, "All", dummyType, dummy)
                    .withNavigationButton(1, "Category-1", dummyType, dummy)
                    .withNavigationButton(2, "Category-2", dummyType, dummy)
                    .withNavigationButton(3, "Category-3", dummyType, dummy)
                    .withNavigationButton(4, "Category-4", dummyType, dummy)
                    .withNavigationButton(5, "Category-5", dummyType, dummy)
                    .withNavigationButton(6, "Category-6", dummyType, dummy)
                    .withNavigationButton(7, "Category-7", dummyType, dummy)
                    .withNavigationButton(8, "Category-8", dummyType, dummy)
                    .build()
            );

            NextPageButton nextPageButton = NextPageButtonBuilder.builder()
                    .withDisplayItem(ItemType.from("minecraft:coal"))
                    .withDisplayName("Next page")
                    .withTargetContainer("item-container")
                    .build();
            menuView.

            PreviousPageButton previousPageButton = PreviousPageButtonBuilder.builder()
                    .withDisplayItem(ItemType.from("minecraft:coal"))
                    .withDisplayName("Previous page")
                    .withTargetContainer("item-container")
                    .build();

            PageableItemContainer itemContainer = menuView.createFromRowsRange("item-container", 2, 5, (box -> PageableItemContainerBuilder.builder().withContainer(box).build()));







        });


    }
}
