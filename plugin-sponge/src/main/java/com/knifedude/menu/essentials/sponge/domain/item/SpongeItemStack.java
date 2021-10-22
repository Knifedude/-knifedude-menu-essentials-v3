package com.knifedude.menu.essentials.sponge.domain.item;

import com.knifedude.menuessentials.api.item.models.Enchantment;
import com.knifedude.menuessentials.api.item.models.ItemStack;
import com.knifedude.menuessentials.api.item.models.ItemType;
import com.knifedude.menuessentials.api.text.models.Text;
import com.knifedude.menuessentials.api.text.models.lore.Lore;
import org.spongepowered.api.data.key.Keys;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class SpongeItemStack implements ItemStack {

    private org.spongepowered.api.item.inventory.ItemStack itemStack;


    public SpongeItemStack(org.spongepowered.api.item.inventory.ItemStack underlyingItemSack) {
        this.itemStack = underlyingItemSack;
    }

    public org.spongepowered.api.item.inventory.ItemStack getItemStack() {
        return itemStack;
    }

    @Override
    public Optional<Text> getDisplayName() {
        return Optional.empty();
    }

    @Override
    public int getQuantity() {
        return itemStack.getQuantity();
    }

    @Override
    public ItemType getItemType() {
        return null;
    }

    @Override
    public Lore getLore() {
        return itemStack.get(Keys.ITEM_LORE).map(texts -> Lore.from(texts));
    }

    @Override
    public List<Enchantment> getEnchantments() {
        return itemStack.get(Keys.ITEM_ENCHANTMENTS).orElse(new ArrayList<>())
                        .stream()
                        .map(SpongeEnchantment::new)
                        .collect(Collectors.toList());
    }

    @Override
    public Optional<Integer> getDurability() {
        return itemStack.get(Keys.ITEM_DURABILITY);
    }




}
