package com.knifedude.menuessentials.api.common.models;

import java.util.Collection;

public interface PageSourceFactory {

    <TElement> PageSource<TElement> create(Collection<TElement> elements);

}
