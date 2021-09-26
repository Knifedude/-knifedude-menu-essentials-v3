package com.knifedude.menu.essentials.sponge.domain.text;

import com.google.common.collect.Sets;
import com.knifedude.menuessentials.api.text.models.font.FontStyle;
import org.spongepowered.api.text.format.TextStyle;
import java.util.Collection;
import java.util.Set;

public class SpongeTextStyleMapper {

    private SpongeTextStyleMapper() {
    }

    public static TextStyle mapFontStyleToTextStyle(Collection<FontStyle> styles) {
        return mapFontStyleToTextStyle(Sets.newHashSet(styles));
    }

    public static TextStyle mapFontStyleToTextStyle(Set<FontStyle> styles) {
        boolean italic = styles.contains(FontStyle.ITALIC);
        boolean bold = styles.contains(FontStyle.BOLD);
        boolean underline = styles.contains(FontStyle.UNDERLINE);
        boolean strikethrough = styles.contains(FontStyle.STRIKETHROUGH);
        boolean obfuscated = styles.contains(FontStyle.OBFUSCATED);
        return new TextStyle(bold, italic, underline, strikethrough, obfuscated);
    }

    public static TextStyle mapFontStyleToTextStyle(FontStyle... styles) {
        return mapFontStyleToTextStyle(Sets.newHashSet(styles));
    }


}
