package com.knifedude.menuessentials.api.text.models.lore;

import com.knifedude.menuessentials.api.common.register.Register;
import com.knifedude.menuessentials.api.text.factories.LoreFactory;
import com.knifedude.menuessentials.api.text.models.Text;

import java.util.Collection;
import java.util.List;

public interface Lore {

    void addText(Text text);

    void addLines(Text... line);

    void removeText(Text text);

    void clear();

    Lore copy();

    List<Text> getLines();

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
