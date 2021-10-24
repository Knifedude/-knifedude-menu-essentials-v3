package com.knifedude.menuessentials.api.text.models.lore;

import com.knifedude.menuessentials.api.common.register.Register;
import com.knifedude.menuessentials.api.text.factories.LoreFactory;
import com.knifedude.menuessentials.api.text.models.Text;

import java.util.Collection;
import java.util.stream.Stream;

public interface Lore extends Iterable<Text> {

    Lore copy();

    boolean containsPlain(Text text);

    boolean containsPlain(String text);

    Stream<Text> lines();

    static Lore from(Collection<Text> texts) {
        return Register.getFactory(LoreFactory.class).from(texts);
    }

    static Lore from(Text... texts) {
        return Register.getFactory(LoreFactory.class).from(texts);
    }

    static Lore empty() {
        return Register.getFactory(LoreFactory.class).empty();
    }
    
    

}
