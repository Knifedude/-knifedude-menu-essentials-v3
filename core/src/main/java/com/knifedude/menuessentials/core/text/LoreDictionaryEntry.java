package com.knifedude.menuessentials.core.text;

import com.knifedude.menuessentials.api.text.models.Text;
import com.knifedude.menuessentials.api.text.models.lore.LoreDictionary;

import java.util.Objects;
import java.util.Optional;

public class LoreDictionaryEntry implements LoreDictionary.Entry {

    private Text key;
    private Text value;

    public LoreDictionaryEntry(Text key) {
        this.key = key;
    }

    public LoreDictionaryEntry(Text key, Text value) {
        this.key = key;
        this.value = value;
    }

    public Text getKey() {
        return key;
    }

    @Override
    public Text toText() {
        return key.concat(value);
    }

    @Override
    public Optional<Text> getValue() {
        return Optional.ofNullable(value);
    }

}
