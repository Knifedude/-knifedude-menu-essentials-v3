package com.knifedude.menuessentials.core.menu.button;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.knifedude.menuessentials.api.item.models.ItemStack;
import com.knifedude.menuessentials.api.item.models.ItemType;
import com.knifedude.menuessentials.api.menu.components.buttons.Button;
import com.knifedude.menuessentials.api.menu.components.buttons.ButtonBuilder;
import com.knifedude.menuessentials.api.menu.handlers.ClickHandler;
import com.knifedude.menuessentials.api.text.models.Text;
import com.knifedude.menuessentials.api.text.models.lore.Lore;

import java.util.List;
import java.util.Set;

public abstract class AbstractButtonBuilderImpl<TInstance extends Button, TBuilder extends AbstractButtonBuilderImpl<TInstance,TBuilder>> implements ButtonBuilder<TInstance,TBuilder> {

    protected ItemStack itemStack;
    protected Text displayName;
    protected List<ClickHandler> handlers;
    protected Set<String> tags;
    protected Lore lore;

    public AbstractButtonBuilderImpl() {
        this.handlers = Lists.newArrayList();
        this.tags = Sets.newHashSet();
    }

    @Override
    public TBuilder withDisplayItem(ItemStack itemStack) {
        this.itemStack = itemStack;
        return (TBuilder) this;
    }

    @Override
    public TBuilder withDisplayItem(ItemType itemType) {
        this.itemStack = this.itemStack == null ? ItemStack.of(itemType) : this.itemStack.toBuilder().withItemType(itemType).build();

        return (TBuilder) this;
    }

    public TBuilder withDisplayName(Text text) {
        this.displayName = text;
        return (TBuilder) this;
    }

    @Override
    public TBuilder withTags(String... tags) {
        for (String t : tags) {
            this.tags.add(t);
        }
        return (TBuilder) this;
    }

    @Override
    public TBuilder withLore(Lore lore) {
        this.lore = lore;
        return (TBuilder) this;
    }

    @Override
    public TBuilder withOnClick(ClickHandler... clickHandler) {
        for (ClickHandler h : clickHandler) {
            this.handlers.add(h);
        }
        return (TBuilder) this;
    }


}
