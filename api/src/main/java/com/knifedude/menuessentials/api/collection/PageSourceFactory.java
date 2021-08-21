package com.knifedude.menuessentials.api.collection;

import java.util.Collection;

public interface PageSourceFactory {

    <TElement> PageSource<TElement> create(Collection<TElement> elements, int pageSize);

}
