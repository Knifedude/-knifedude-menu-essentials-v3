package com.knifedude.menuessentials.api.item.models;

import com.knifedude.menuessentials.api.common.models.HasDisplayName;
import com.knifedude.menuessentials.api.common.register.Register;
import com.knifedude.menuessentials.api.text.models.Text;
import com.knifedude.menuessentials.api.text.models.lore.Lore;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface ItemStack extends HasDisplayName {

    int getQuantity();

    ItemType getItemType();

    Lore getLore();

    List<Enchantment> getEnchantments();

    Optional<Integer> getDurability();

    default ItemStack copy() {
        return toBuilder().build();
    }

    default ItemStack.Builder toBuilder() {
        ItemStack.Builder builder = builder().withDisplayName(getDisplayName().orElse(Text.empty()))
                        .withItemType(getItemType())
                        .withQuantity(getQuantity())
                        .withLore(getLore())
                        .withEnchantments(getEnchantments());
        getDurability().ifPresent(builder::withDurability);
        return builder;
    }

    static ItemStack.Builder builder() {
        return Register.getBuilder(ItemStack.Builder.class);
    }

    void setDisplayName(Text newName);

    void setItemType(ItemType itemType);

    void setQuantity(int quantity);

    void setLore(Lore newLore);

    void setDurability(int durability);

    interface Builder {

        Builder withItemType(ItemType itemType);

        Builder withQuantity(int quantity);

        Builder withDisplayName(String name);

        Builder withDisplayName(Text name);

        Builder withLore(Lore lore);

        Builder withEnchantments(Collection<Enchantment> enchantments);

        Builder withDurability(int durability);

        ItemStack build();

    }


}