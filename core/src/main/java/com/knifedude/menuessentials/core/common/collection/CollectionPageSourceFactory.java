package com.knifedude.menuessentials.core.common.collection;

import com.knifedude.menuessentials.api.common.models.PageSource;
import com.knifedude.menuessentials.api.common.models.PageSourceFactory;

import java.util.Collection;

public class CollectionPageSourceFactory implements PageSourceFactory {
    @Override
    public <TElement> PageSource<TElement> create(Collection<TElement> elements) {
        return new CollectionPageSource<>(elements);
    }
}
