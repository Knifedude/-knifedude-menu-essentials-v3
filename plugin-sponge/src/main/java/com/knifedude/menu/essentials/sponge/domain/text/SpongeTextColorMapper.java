package com.knifedude.menu.essentials.sponge.domain.text;

import com.knifedude.menuessentials.api.text.models.font.FontColor;
import org.spongepowered.api.text.format.TextColor;
import org.spongepowered.api.text.format.TextColors;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class SpongeTextColorMapper {

    private static final EnumMap<com.knifedude.menuessentials.api.text.models.font.FontColor, TextColor> FONT_COLOR_MAP;
    private static final TextColor DEFAULT_TEXTCOLOR = TextColors.RESET;

    static {
        FONT_COLOR_MAP = new EnumMap<>(com.knifedude.menuessentials.api.text.models.font.FontColor.class);
        FONT_COLOR_MAP.put(com.knifedude.menuessentials.api.text.models.font.FontColor.AQUA, TextColors.AQUA);
        FONT_COLOR_MAP.put(com.knifedude.menuessentials.api.text.models.font.FontColor.BLACK, TextColors.BLACK);
        FONT_COLOR_MAP.put(com.knifedude.menuessentials.api.text.models.font.FontColor.DARK_BLUE, TextColors.DARK_BLUE);
        FONT_COLOR_MAP.put(com.knifedude.menuessentials.api.text.models.font.FontColor.DARK_GREEN, TextColors.DARK_GREEN);
        FONT_COLOR_MAP.put(com.knifedude.menuessentials.api.text.models.font.FontColor.DARK_AQUA, TextColors.DARK_AQUA);
        FONT_COLOR_MAP.put(com.knifedude.menuessentials.api.text.models.font.FontColor.DARK_RED, TextColors.DARK_RED);
        FONT_COLOR_MAP.put(com.knifedude.menuessentials.api.text.models.font.FontColor.DARK_PURPLE, TextColors.DARK_PURPLE);
        FONT_COLOR_MAP.put(com.knifedude.menuessentials.api.text.models.font.FontColor.GOLD, TextColors.GOLD);
        FONT_COLOR_MAP.put(com.knifedude.menuessentials.api.text.models.font.FontColor.GRAY, TextColors.GRAY);
        FONT_COLOR_MAP.put(com.knifedude.menuessentials.api.text.models.font.FontColor.DARK_GRAY, TextColors.DARK_GRAY);
        FONT_COLOR_MAP.put(com.knifedude.menuessentials.api.text.models.font.FontColor.BLUE, TextColors.BLUE);
        FONT_COLOR_MAP.put(com.knifedude.menuessentials.api.text.models.font.FontColor.GREEN, TextColors.GREEN);
        FONT_COLOR_MAP.put(com.knifedude.menuessentials.api.text.models.font.FontColor.RED, TextColors.RED);
        FONT_COLOR_MAP.put(com.knifedude.menuessentials.api.text.models.font.FontColor.LIGHT_PURPLE, TextColors.LIGHT_PURPLE);
        FONT_COLOR_MAP.put(com.knifedude.menuessentials.api.text.models.font.FontColor.YELLOW, TextColors.YELLOW);
        FONT_COLOR_MAP.put(com.knifedude.menuessentials.api.text.models.font.FontColor.WHITE, TextColors.WHITE);
    }

    private SpongeTextColorMapper() {}

    public static TextColor mapFontColor(FontColor fontColor) {
        return Optional.ofNullable(FONT_COLOR_MAP.get(fontColor)).orElse(DEFAULT_TEXTCOLOR);
    }

}
