package com.knifedude.menu.essentials.sponge.domain.item;


import com.knifedude.menuessentials.api.item.models.Enchantment;
import com.knifedude.menuessentials.api.item.models.EnchantmentType;

public class SpongeEnchantment implements Enchantment  {

    private final org.spongepowered.api.item.enchantment.Enchantment spongeEnchantment;
    private final EnchantmentType type;

    public SpongeEnchantment(org.spongepowered.api.item.enchantment.Enchantment spongeEnchantment) {
        this.spongeEnchantment = spongeEnchantment;
        this.type = new SpongeEnchantmentType(spongeEnchantment.getType());
    }

    @Override
    public EnchantmentType getEnchantmentType() {
        return type;
    }

    @Override
    public int getLevel() {
        return spongeEnchantment.getLevel();
    }
}
