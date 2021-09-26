package com.knifedude.menuessentials.core.common.collection;

import com.google.common.base.Preconditions;
import com.knifedude.menuessentials.api.common.models.PageSource;

import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class CollectionPageSource<TElement> implements PageSource<TElement> {

    private Collection<TElement> collection;

    public CollectionPageSource(Collection<TElement> collection) {
        Preconditions.checkNotNull(collection, "Constructor argument 'collection' is mandatory but was null");
        this.collection = collection;
    }

    public Collection<TElement> getPage(int pageIndex, int pageSize) throws NoSuchElementException {
        return collection.stream()
                         .skip((long) pageIndex * pageSize)
                         .limit(pageSize)
                         .collect(Collectors.toList());
    }

    public boolean hasPage(int pageIndex, int pageSize) {
        return (pageIndex * pageSize) < collection.size();
    }
}
