package com.knifedude.menuessentials.api.item.models;

import java.util.stream.Stream;

public interface ItemsProvider<TItem> {

    Stream<TItem> items();

}
