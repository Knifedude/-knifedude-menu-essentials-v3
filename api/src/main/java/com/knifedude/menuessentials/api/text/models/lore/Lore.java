package com.knifedude.menuessentials.api.text.models.lore;

import com.knifedude.menuessentials.api.common.register.Register;
import com.knifedude.menuessentials.api.text.factories.LoreFactory;
import com.knifedude.menuessentials.api.text.models.Text;

import java.util.Collection;
import java.util.List;

public interface Lore {

    Lore copy();

    List<Text> getLines();

    boolean containsPlain(Text text);

    boolean containsPlain(String text);

    LoreDictionary toDictionary(String separator);

    static Lore from(Collection<Text> texts) {
        return Register.getFactory(LoreFactory.class).from(texts);
    }

    static Lore from(Text... texts) {
        return Register.getFactory(LoreFactory.class).from(texts);
    }

    static Lore empty() {
        return Register.getFactory(LoreFactory.class).empty();
    }

    void concat(Lore originalLore);
}
