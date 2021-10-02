package com.knifedude.menu.essentials.sponge.domain.item;

import com.knifedude.menuessentials.api.item.models.Enchantment;
import com.knifedude.menuessentials.api.item.models.ItemStack;
import com.knifedude.menuessentials.api.item.models.ItemType;
import com.knifedude.menuessentials.api.text.models.Text;
import com.knifedude.menuessentials.api.text.models.lore.Lore;

import java.util.List;
import java.util.Optional;

public class SpongeItemStack implements ItemStack {

    private

    public SpongeItemStack(org.spongepowered.api.item.inventory.ItemStack underlyingItemSack) {
    }

    @Override
    public Optional<Text> getDisplayName() {
        return Optional.empty();
    }

    @Override
    public int getQuantity() {
        return 0;
    }

    @Override
    public ItemType getItemType() {
        return null;
    }

    @Override
    public Lore getLore() {
        return null;
    }

    @Override
    public List<Enchantment> getEnchantments() {
        return null;
    }

    @Override
    public Optional<Integer> getDurability() {
        return Optional.empty();
    }


}
