package com.knifedude.menuessentials.core.text;

import com.google.common.collect.Lists;
import com.knifedude.menuessentials.api.text.models.Text;
import com.knifedude.menuessentials.api.text.models.lore.Lore;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LoreImpl implements Lore {

    private List<Text> texts;

    public LoreImpl(Iterable<Text> texts) {
        this.texts = Lists.newArrayList(texts);
    }

    public LoreImpl(Text... texts) {
        this.texts = Lists.newArrayList(texts);
    }


    @Override
    public Lore copy() {
        return new LoreImpl(texts.stream().map(Text::copy).collect(Collectors.toList()));
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
    public Stream<Text> lines() {
        return texts.stream();
    }

    @Override
    public Iterator<Text> iterator() {
        return texts.iterator();
    }
}
