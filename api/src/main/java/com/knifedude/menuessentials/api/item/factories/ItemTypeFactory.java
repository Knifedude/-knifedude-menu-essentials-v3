package com.knifedude.menuessentials.api.item.factories;

import com.knifedude.menuessentials.api.item.models.ItemType;

import java.util.Optional;

public interface ItemTypeFactory {

    Optional<ItemType> fromId(String id);

}
