package com.knifedude.menuessentials.api.text.models;

import com.knifedude.menuessentials.api.text.models.font.FontColor;
import com.knifedude.menuessentials.api.text.models.font.FontStyle;

import java.util.List;

public interface TextElement {

    /**
     * Gets the color of the text
     * @return The color
     */
    FontColor getColor();

    /**
     * Get the style of the text
     * @return The style
     */
    List<FontStyle> getStyle();

    /**
     * Determines if this text has given format
     * @param style The style
     * @return True if this text has given format
     */
    boolean hasFormat(FontStyle style);

}
