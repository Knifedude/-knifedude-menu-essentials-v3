package com.knifedude.menuessentials.api.text.factories;

import com.knifedude.menuessentials.api.text.models.Text;
import com.knifedude.menuessentials.api.text.models.lore.Lore;

import java.util.Collection;

public interface LoreFactory {

    Lore from(Collection<Text> texts);

    Lore from(Text... texts);

    Lore empty();

}
