package com.knifedude.menuessentials.core.text;

import com.knifedude.menuessentials.api.text.factories.LoreFactory;
import com.knifedude.menuessentials.api.text.models.Text;
import com.knifedude.menuessentials.api.text.models.lore.Lore;

import java.util.Collection;

public class LoreFactoryImpl implements LoreFactory {

    @Override
    public Lore from(Collection<Text> texts) {
        return new LoreImpl(texts);
    }

    @Override
    public Lore from(Text... texts) {
        return new LoreImpl(texts);
    }

    @Override
    public Lore empty() {
        return new LoreImpl();
    }

    @Override
    public Lore create() {
        return null;
    }

}
