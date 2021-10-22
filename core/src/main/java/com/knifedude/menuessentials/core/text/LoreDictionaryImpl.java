package com.knifedude.menuessentials.core.text;

import com.google.common.collect.Maps;
import com.knifedude.menuessentials.api.text.models.lore.Lore;
import com.knifedude.menuessentials.api.text.models.lore.LoreDictionary;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LoreDictionaryImpl implements LoreDictionary {

    private Map<String, Entry> entries;



    public LoreDictionaryImpl() {
        this.entries = Maps.newHashMap();
    }

    @Override
    public Lore toLore() {
        return Lore.from(entries.values().stream().map(Entry::toText).collect(Collectors.toList()));
    }

    @Override
    public Stream<Entry> entries() {
        return entries.values().stream();
    }
}
