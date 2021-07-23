package com.knifedude.menuessentials.api.item.factories;

import com.knifedude.menuessentials.api.item.models.Enchantment;
import com.knifedude.menuessentials.api.item.models.EnchantmentType;

public interface EnchantmentFactory {

    Enchantment create(EnchantmentType type, int level);

}
