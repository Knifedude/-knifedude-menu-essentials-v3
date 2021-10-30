package com.knifedude.menuessentials.core.menu.button;

import com.google.common.base.Preconditions;
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

public abstract class AbstractButtonBuilderImpl<TButtonType extends Button, TButtonBuilder extends ButtonBuilder<TButtonType, TButtonBuilder>> implements ButtonBuilder<TButtonType, TButtonBuilder> {

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
    public TButtonBuilder withDisplayItem(ItemStack itemStack) {
        this.itemStack = itemStack;
        return (TButtonBuilder) this;
    }

    @Override
    public TButtonBuilder withDisplayItem(ItemType itemType) {
        this.itemStack = this.itemStack == null ? ItemStack.of(itemType) : this.itemStack.toBuilder().withItemType(itemType).build();

        return (TButtonBuilder) this;
    }

    public TButtonBuilder withDisplayName(Text text) {
        this.displayName = text;
        return (TButtonBuilder) this;
    }

    @Override
    public TButtonBuilder withTags(String... tags) {
        for (String t : tags) {
            this.tags.add(t);
        }
        return (TButtonBuilder) this;
    }

    @Override
    public TButtonBuilder withLore(Lore lore) {
        this.lore = lore;
        return (TButtonBuilder) this;
    }

    @Override
    public TButtonBuilder withOnClick(ClickHandler... clickHandler) {
        for (ClickHandler h : clickHandler) {
            this.handlers.add(h);
        }
        return (TButtonBuilder) this;
    }

    protected ItemStack createDisplayItem() {
        Preconditions.checkNotNull(this.itemStack, "No itemtype or itemstack provided");
        return this.itemStack.toBuilder()
                .withDisplayName(this.displayName)
                .withLore(this.lore)
                .build();
    }

    protected void apply(TButtonType instance) {
        this.handlers.forEach(instance::addOnClick);
        instance.tags().addAll(this.tags);
    }


}
