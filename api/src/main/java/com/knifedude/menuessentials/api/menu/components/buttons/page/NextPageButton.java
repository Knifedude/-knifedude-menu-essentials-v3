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

public class NextPageButton extends PageButton {

    private static final String DEFAULT_NEXT_PAGE_DISPLAYNAME = "Next page";
    private TextTemplate nextPageTemplate;

    public NextPageButton(ItemStack displayItem, ClickHandler... clickHandlers) {
        this(displayItem, Lists.newArrayList(), clickHandlers);
    }

    public NextPageButton(ItemType displayItemType, Text displayName, ClickHandler... clickHandlers) {
        this(ItemStack.of(displayItemType, displayName), Lists.newArrayList(), clickHandlers);
    }

    public NextPageButton(ItemType displayItemType, Text displayName, List<String> tags, ClickHandler... clickHandlers) {
        this(ItemStack.of(displayItemType, displayName), tags, clickHandlers);

        this.nextPageTemplate = PageTextTemplate.nextPageTemplate(Text.of(DEFAULT_NEXT_PAGE_DISPLAYNAME));
    }

    public NextPageButton(ItemStack displayItem, List<String> tags, ClickHandler... clickHandlers) {
        super(displayItem, tags, clickHandlers);
    }

    protected final Text createNextPageText() {
        return getTarget().map(pageable -> {
            PageArgs args = new PageArgs();
            args.setNextPageByIndex(pageable.getNextPageIndex());
            return nextPageTemplate.toText(args.toMap());
        }).orElse(Text.empty());
    }

    @Override
    protected final void update() {
        Lore lore = getLore();
        lore.clear();

        Text currentPageText = createCurrentPageText();
        Text nextPageText = createNextPageText();
        lore.addLines(currentPageText, nextPageText);

        setDisplayLore(lore);
    }

    @Override
    public void onPageChange(PageChangedEvent event) {
        update();
    }
}
