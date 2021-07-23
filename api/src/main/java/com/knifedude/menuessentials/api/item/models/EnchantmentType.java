package com.knifedude.menuessentials.api.item.models;

import com.google.common.base.Preconditions;
import com.knifedude.menuessentials.api.common.register.Register;
import com.knifedude.menuessentials.api.item.factories.EnchantmentTypeFactory;

public interface EnchantmentType {

    String getId();

    String getName();

    static EnchantmentType from(String id) {
        Preconditions.checkNotNull(id, "Given argument 'id' may not be null");
        return Register.getFactory(EnchantmentTypeFactory.class).fromId(id).orElseThrow(() -> new IllegalArgumentException(String.format("No enchantment registered with id '%s''", id)));
    }

}
