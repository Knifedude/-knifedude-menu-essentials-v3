package com.knifedude.menuessentials.api.menu.components.containers.horizontalbar;

import com.knifedude.menuessentials.api.item.models.ItemType;
import com.knifedude.menuessentials.api.menu.components.containers.PageContainer;
import com.knifedude.menuessentials.api.text.models.Text;

import java.util.function.Function;

public interface HorizontalScrollBarBuilder<TInstance extends HorizontalScrollBar, TBuilder extends HorizontalScrollBarBuilder<TInstance,TBuilder>> {

    TBuilder withPageButtonDisplayItem(ItemType itemType);

    TBuilder withPreviousPageDisplayName(Text text);

    TBuilder withNextPageDisplayName(Text text);

    TBuilder withCurrentPageText(Function<Integer, Text> textFunction);

    TBuilder withTarget(PageContainer target);

    TInstance build();

}
