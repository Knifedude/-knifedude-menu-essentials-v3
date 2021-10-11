package com.knifedude.menu.essentials.sponge.domain.item;

import com.google.common.base.Preconditions;
import com.knifedude.menuessentials.api.item.models.EnchantmentType;

public class SpongeEnchantmentType implements EnchantmentType {

    private final org.spongepowered.api.item.enchantment.EnchantmentType enchantmentType;

    public SpongeEnchantmentType(org.spongepowered.api.item.enchantment.EnchantmentType enchantmentType) {
        Preconditions.checkNotNull(enchantmentType);
        this.enchantmentType = enchantmentType;
    }

    @Override
    public String getId() {
        return enchantmentType.getId();
    }

    @Override
    public String getName() {
        return enchantmentType.getName();
    }
}
