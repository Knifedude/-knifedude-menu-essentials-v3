package com.knifedude.menuessentials.api.text.models.font;

import com.google.common.base.Preconditions;
import com.google.common.collect.Sets;

import java.util.Set;

public class FontFormat {

    private final FontColor color;
    private final Set<FontStyle> styles;

    private FontFormat(FontColor color, FontStyle... styles) {
        this.color = color;
        this.styles = styles != null ? Sets.newHashSet(styles) : Sets.newHashSet();
    }

    public FontColor getColor() {
        return color;
    }

    public boolean hasStyle(FontStyle style) {
        Preconditions.checkNotNull(style, "Argument 'style' was null");
        return styles.contains(style);
    }

    public void removeStyle(FontStyle style) {
        Preconditions.checkNotNull(style, "Argument 'style' was null");
        this.styles.remove(style);
    }

    public void addStyle(FontStyle style) {
        Preconditions.checkNotNull(style, "Argument 'style' was null");
        this.styles.add(style);
    }

    public void setColor(FontColor color) {
        Preconditions.checkNotNull(color, "Argument 'color' was null");
    }

    /**
     * Creates a {@link FontFormat} with {@link FontColor#WHITE} and {@link FontStyle#NONE}
     * @return FontFormat
     */
    public static FontFormat defaultFormat() {
        return new FontFormat(FontColor.WHITE, FontStyle.NONE);
    }

    /**
     * Creates a {@link FontFormat} with given {@link FontColor} and {@link FontStyle#NONE}
     * @return FontFormat
     */
    public static FontFormat withColor(FontColor fontColor) {
        return new FontFormat(fontColor, FontStyle.NONE);
    }

    /**
     * Creates a {@link FontFormat} with {@link FontColor#WHITE} and given {@link FontStyle}
     * @return FontFormat
     */
    public static FontFormat withStyles(FontStyle... fontStyles) {
        return new FontFormat(FontColor.WHITE, fontStyles);
    }

    /**
     * Creates a {@link FontFormat} with given {@link FontColor} and {@link FontStyle}
     * @return FontFormat
     */
    public static FontFormat with(FontColor fontColor, FontStyle... fontStyles) {
        return new FontFormat(fontColor, fontStyles);
    }


}
