package com.knifedude.menuessentials.api.text.models.lore;


import com.knifedude.menuessentials.api.text.exceptions.LoreDictionaryParsingException;

/**
 * Parses a {@link LoreDictionary} from a given {@link Lore}
 */
public interface LoreDictionaryParser {

    /**
     * Parses a {@link LoreDictionary} from a given {@link Lore}
     * @param lore The {@link Lore} to parse
     * @return The parsed {@link LoreDictionary}
     * @throws LoreDictionaryParsingException When unable to parse the {@link Lore} to a {@link LoreDictionary}
     */
    LoreDictionary parse(Lore lore) throws LoreDictionaryParsingException;



}
