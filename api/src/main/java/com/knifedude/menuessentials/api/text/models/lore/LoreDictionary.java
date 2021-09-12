package com.knifedude.menuessentials.api.text.models.lore;

import com.google.common.base.Preconditions;
import com.knifedude.menuessentials.api.common.register.Register;
import com.knifedude.menuessentials.api.text.exceptions.LoreDictionaryParsingException;
import com.knifedude.menuessentials.api.text.models.Text;
import com.knifedude.menuessentials.api.text.models.font.FontFormat;

import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * A lore dictionary can be used to create an entry based with styling lore more easily. <br/>
 * Each entry gets it's own line <br/>
 *
 * Entries could look like this: <br/>
 * Name: Example <br/>
 * Category: Default <br/>
 * Price: 100<br/>
 */
public interface LoreDictionary extends Supplier<Lore> {

    /**
     * Creates a new Lore using the entries of this dictionary
     * @return The lore
     */
    @Override
    Lore get();

    /**
     * Creates a new Lore using the entries of this dictionary. Executes the {@link #get()}
     * @return The lore
     */
    default Lore toLore() {
        return get();
    }

    /**
     * Sets the {@link FontFormat} for the value
     * @param format The {@link FontFormat}
     */
    void setKeyFormat(FontFormat format);

    /**
     * Sets the {@link FontFormat} for the value
     * @param format The {@link FontFormat}
     */
    void setValueFormat(FontFormat format);

    /**
     * Sets the separator. Default is ':' and using the same {@link FontFormat} as the key
     * @param separator The separator to be used
     */
    void setSeparator(Text separator);

    /**
     * Adds an entry to this dictionary
     * @param key The key
     * @param value The value
     */
    void addEntry(String key, String value);



    /**
     * Adds an entry to this dictionary
     * @param key The key
     * @param value The value
     */
    void addEntry(Text key, Text value);

    /**
     * Adds an entry to this dictionary
     * @param key The key
     * @param value The value
     */
    void addEntryCustomValue(String key, Text value);

    /**
     * Adds an entry to this dictionary
     * @param key The key
     * @param value The value
     */
    void addEntryCustomKey(Text key, String value);

    /**
     * Gets all the entries within this dictionary
     * @return The entries
     */
    Stream<Entry> entries();

    /**
     * Gets the first {@link Entry} that matches the given key
     * @param key The key
     * @return The {@link Entry} wrapped in an {@link Optional}. If no {@link} was found then the optional is empty
     */
    default Optional<Entry> findFirst(String key) {
        Preconditions.checkNotNull(key, "Argument 'key' may not be null");
        return entries().filter(e -> key.equals(e.getKey().getContent())).findFirst();
    }

    /**
     * Parses a {@link LoreDictionary} from the given {@link Lore}
     * @param lore The {@link Lore} to parse
     * @return The {@link LoreDictionary}
     * @throws LoreDictionaryParsingException
     */
    static LoreDictionary from(Lore lore) throws LoreDictionaryParsingException {
        return Register.getFactory(LoreDictionaryParser.class).parse(lore);
    }

    interface Entry {

        /**
         * Gets the key of this {@link Entry}
         * @return The key
         */
        Text getKey();

        /**
         * Gets the value of this {@link Entry}
         * @return The
         */
        Text getValue();

    }

    /**
     * Defines a builder for creating a {@link LoreDictionary}
     */
    interface Builder {

        /**
         * Sets the {@link FontFormat} for the keys used by this lore
         * @param format The {@link FontFormat}
         * @return this builder
         */
         Builder withKeyFormat(FontFormat format);

        /**
         * Sets the {@link FontFormat} for the keys used by this lore
         * @param format The {@link FontFormat}
         * @return this builder
         */
         Builder withValueFormat(FontFormat format);

        /**
         * Sets the separator to be used. Default is ':' and using the same {@link FontFormat} as the key
         * @param separator The separator
         * @return this builder
         */
         Builder withSeparator(Text separator);

        /**
         * Builds the {@link LoreDictionary}
         * @return The {@link LoreDictionary}
         */
         LoreDictionary build();

    }

}
