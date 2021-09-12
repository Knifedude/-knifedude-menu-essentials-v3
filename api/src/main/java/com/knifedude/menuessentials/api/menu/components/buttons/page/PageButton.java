package com.knifedude.menuessentials.api.menu.components.buttons.page;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.knifedude.menuessentials.api.item.models.ItemStack;
import com.knifedude.menuessentials.api.item.models.ItemType;
import com.knifedude.menuessentials.api.menu.ClickContext;
import com.knifedude.menuessentials.api.menu.behaviors.Pageable;
import com.knifedude.menuessentials.api.menu.components.buttons.Button;
import com.knifedude.menuessentials.api.menu.event.listeners.PageChangeListener;
import com.knifedude.menuessentials.api.menu.handlers.ClickHandler;
import com.knifedude.menuessentials.api.text.models.Text;
import com.knifedude.menuessentials.api.text.models.TextTemplate;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

public abstract class PageButton extends Button implements PageChangeListener {

    private static final String DEFAULT_CURRENT_PAGE_DISPLAYNAME = "Current page";

    private Pageable target;
    private TextTemplate currentPageTemplate;



    public PageButton(ItemStack displayItem, ClickHandler... clickHandlers) {
        this(displayItem, Lists.newArrayList(), clickHandlers);
    }

    public PageButton(ItemType displayItemType, Text displayName, ClickHandler... clickHandlers) {
        this(ItemStack.of(displayItemType, displayName), Lists.newArrayList(), clickHandlers);
    }

    public PageButton(ItemType displayItemType, Text displayName, List<String> tags, ClickHandler... clickHandlers) {
        this(ItemStack.of(displayItemType, displayName), tags, clickHandlers);
    }

    public PageButton(ItemStack displayItem, List<String> tags, ClickHandler... clickHandlers) {
        super(displayItem, tags, clickHandlers);

        this.currentPageTemplate = PageTextTemplate.currentPageTemplate(Text.of(DEFAULT_CURRENT_PAGE_DISPLAYNAME));
    }

    public TextTemplate getCurrentPageTemplate() {
        return currentPageTemplate;
    }

    public void setCurrentPageTemplate(Text keyDisplayName, Function<Text, Text> valueStyling) {
        this.currentPageTemplate = PageTextTemplate.currentPageTemplate(keyDisplayName, valueStyling);
    }

    public Optional<Pageable> getTarget() {
        return Optional.ofNullable(target);
    }

    public void setTarget(Pageable newTarget) {
        if (this.target != null) {
            this.target.unregisterPageButton(this);
        }
        this.target = newTarget;

        if (newTarget != null) {
            newTarget.registerPageButton(this);
        }

        update();
    }

    protected final Text createCurrentPageText() {
        return getTarget().map(pageable -> {
            Map<String,Object> args = Maps.newHashMap();
            args.put(PageArgs.CURRENT_PAGE, pageable.getCurrentPageIndex() + 1);
            return currentPageTemplate.toText(args);
        }).orElse(Text.empty());
    }

    protected abstract void update();

    @Override
    public void onClick(ClickContext context) {
        super.onClick(context);
    }



}
