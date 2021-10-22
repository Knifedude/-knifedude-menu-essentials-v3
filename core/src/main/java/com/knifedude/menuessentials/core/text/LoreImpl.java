package com.knifedude.menuessentials.core.text;

import com.knifedude.menuessentials.api.text.models.Text;
import com.knifedude.menuessentials.api.text.models.lore.Lore;
import com.knifedude.menuessentials.api.text.models.lore.LoreDictionary;
import com.sun.javafx.UnmodifiableArrayList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LoreImpl implements Lore {

    private List<Text> texts;

    public LoreImpl(List<Text> texts) {
        this.texts = new ArrayList<>(texts);
    }

    @Override
    public Lore copy() {
        return new LoreImpl(texts.stream().map(Text::copy).collect(Collectors.toList()));
    }

    @Override
    public List<Text> getLines() {
        return Collections.unmodifiableList(texts) ;
    }

    @Override
    public boolean containsPlain(Text text) {
        return texts.stream().anyMatch(t -> t.getContent().equals(text.getContent()));
    }

    @Override
    public boolean containsPlain(String text) {
        return texts.stream().anyMatch(t -> t.getContent().equals(text));
    }

    @Override
    public LoreDictionary toDictionary(String separator) {
        return LoreDictionary.from(this);
    }

    @Override
    public void concat(Lore originalLore) {

    }
}
