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
public interface LoreDictionary  {

    Lore toLore();

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
    static LoreDictionary from(Lore lore) {
        return Register.getFactory(LoreDictionaryParser.class).parse(lore);
    }

    interface Entry {

        /**
         * Gets the key of this {@link Entry}
         * @return The key
         */
        Text getKey();

        Text toText();

        /**
         * Gets the value of this {@link Entry}
         * @return The
         */
        Optional<Text> getValue();

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
