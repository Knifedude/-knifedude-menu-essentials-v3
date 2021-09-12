package com.knifedude.menuessentials.api.menu.components.buttons.page;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.knifedude.menuessentials.api.item.models.ItemStack;
import com.knifedude.menuessentials.api.item.models.ItemType;
import com.knifedude.menuessentials.api.menu.event.events.PageChangedEvent;
import com.knifedude.menuessentials.api.menu.handlers.ClickHandler;
import com.knifedude.menuessentials.api.text.models.Text;
import com.knifedude.menuessentials.api.text.models.TextTemplate;
import com.knifedude.menuessentials.api.text.models.lore.Lore;

import java.util.List;
import java.util.Map;

public class PreviousPageButton extends PageButton {

    private static final String DEFAULT_PREVIOUS_PAGE_DISPLAYNAME = "Next page";
    private TextTemplate previousPageTemplate;

    public PreviousPageButton(ItemStack displayItem, ClickHandler... clickHandlers) {
        this(displayItem, Lists.newArrayList(), clickHandlers);
    }

    public PreviousPageButton(ItemType displayItemType, Text displayName, ClickHandler... clickHandlers) {
        this(ItemStack.of(displayItemType, displayName), Lists.newArrayList(), clickHandlers);
    }

    public PreviousPageButton(ItemType displayItemType, Text displayName, List<String> tags, ClickHandler... clickHandlers) {
        this(ItemStack.of(displayItemType, displayName), tags, clickHandlers);

        this.previousPageTemplate = PageTextTemplate.previousPageTemplate(Text.of(DEFAULT_PREVIOUS_PAGE_DISPLAYNAME));
    }

    public PreviousPageButton(ItemStack displayItem, List<String> tags, ClickHandler... clickHandlers) {
        super(displayItem, tags, clickHandlers);
    }

    protected final Text createPreviousPageText() {
        return getTarget().map(pageable -> {
            Map<String,Object> args = Maps.newHashMap();
            args.put(PageArgs.PREVIOUS_PAGE, pageable.getPreviousPageIndex() + 1);
            return previousPageTemplate.toText(args);
        }).orElse(Text.empty());
    }

    @Override
    protected final void update() {
        Lore lore = getLore();
        lore.clear();

        Text currentPageText = createCurrentPageText();
        Text nextPageText = createPreviousPageText();
        lore.addText(currentPageText);
        lore.addText(nextPageText);

        setDisplayLore(lore);
    }

    @Override
    public void onPageChange(PageChangedEvent event) {
        update();
    }
}
