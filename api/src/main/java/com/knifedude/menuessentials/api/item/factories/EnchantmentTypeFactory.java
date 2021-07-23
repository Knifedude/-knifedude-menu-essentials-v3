package com.knifedude.menuessentials.api.item.factories;

import com.knifedude.menuessentials.api.item.models.EnchantmentType;

import java.util.Optional;

public interface EnchantmentTypeFactory {

    Optional<EnchantmentType> fromId(String id);

}
