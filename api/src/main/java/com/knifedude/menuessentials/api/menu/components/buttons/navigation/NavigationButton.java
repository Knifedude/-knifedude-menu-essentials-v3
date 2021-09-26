package com.knifedude.menuessentials.api.menu.components.buttons.navigation;

import com.google.common.collect.Lists;
import com.knifedude.menuessentials.api.common.models.PageSource;
import com.knifedude.menuessentials.api.item.models.ItemStack;
import com.knifedude.menuessentials.api.item.models.ItemType;
import com.knifedude.menuessentials.api.menu.ClickContext;
import com.knifedude.menuessentials.api.menu.components.buttons.Button;
import com.knifedude.menuessentials.api.menu.components.containers.item.PageableItemContainer;
import com.knifedude.menuessentials.api.menu.handlers.ClickHandler;
import com.knifedude.menuessentials.api.menu.slot.SlotComponent;
import com.knifedude.menuessentials.api.text.models.Text;
import javax.annotation.Nullable;
import java.util.Collection;
import java.util.List;

/**
 * The NavigationButton is a button to be used to replace the contents of a {@link PageableItemContainer}.
 */
public class NavigationButton extends Button {

    private PageSource<SlotComponent> pageSource;
    private PageableItemContainer targetContainer;

    /**
     * Constructor.
     * @param displayItem The displayItem
     * @param clickHandlers The {@link ClickHandler}'s to execute on click (optional)
     */
    public NavigationButton(ItemStack displayItem, ClickHandler... clickHandlers) {
        this(displayItem, Lists.newArrayList(), clickHandlers);
    }

    /**
     * Constructor.
     * @param displayItemType The {@link ItemType} to use as display for this button
     * @param displayName The displayname of this button
     * @param clickHandlers The {@link ClickHandler}'s to execute on click (optional)
     */
    public NavigationButton(ItemType displayItemType, Text displayName, ClickHandler... clickHandlers) {
        this(ItemStack.of(displayItemType, displayName), Lists.newArrayList(), clickHandlers);
    }

    /**
     * Constructor.
     * @param displayItemType The {@link ItemType} to use as display for this button
     * @param displayName The displayname of this button
     * @param tags The tags to add to this button
     * @param clickHandlers The {@link ClickHandler}'s to execute on click (optional)
     */
    public NavigationButton(ItemType displayItemType, Text displayName, List<String> tags, ClickHandler... clickHandlers) {
        this(ItemStack.of(displayItemType, displayName), tags, clickHandlers);
    }

    /**
     * Constructor.
     * @param displayItem The displayItem
     * @param tags The tags to add to this button
     * @param clickHandlers The {@link ClickHandler}'s to execute on click (optional)
     */
    public NavigationButton(ItemStack displayItem, List<String> tags, ClickHandler... clickHandlers) {
        super(displayItem, tags, clickHandlers);
    }

    /**
     * Sets the {@link PageSource} for this navigation button
     * @param pageSource The {@link PageSource} to use. Can be set to null for whatever reason
     */
    public void setPageSource(@Nullable PageSource<SlotComponent> pageSource) {
        this.pageSource = pageSource;
    }

    /**
     * Sets the {@link PageSource} for this navigation button
     * @param collection The {@link PageSource} to use. Can be set to null for whatever reason
     */
    public void setPageSource(@Nullable Collection<SlotComponent> collection) {
        this.pageSource = collection != null ? PageSource.from(collection) : null;
    }

    /**
     * Sets the target container. On click this button will replace the contents of the target container.<br></>
     * @param target The {@link PageableItemContainer} that will be targeted
     */
    public void setTargetContainer(PageableItemContainer target) {
        this.targetContainer = target;
    }

    @Override
    public void onClick(ClickContext context) {
        super.onClick(context);

        if (targetContainer != null) {
            targetContainer.setSource(pageSource); // accepts null
        }
    }
}
