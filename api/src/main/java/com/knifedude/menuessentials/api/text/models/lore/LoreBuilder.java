package com.knifedude.menuessentials.api.text.models.lore;

import com.knifedude.menuessentials.api.common.register.Register;
import com.knifedude.menuessentials.api.text.models.Text;

import java.util.function.Predicate;

public interface LoreBuilder {

    LoreBuilder clear();

    LoreBuilder remove(String text);

    LoreBuilder remove(Predicate<Text> criteria);

    LoreBuilder addLine(Text line);

    default LoreBuilder concat(Lore lore) {
        lore.lines().forEach(this::addLine);
        return this;
    }

    Lore build();

    static LoreBuilder builder() {
        return Register.getBuilder(LoreBuilder.class);
    }

    static LoreBuilder from(Lore lore) {
        return builder().concat(lore);
    }


}
