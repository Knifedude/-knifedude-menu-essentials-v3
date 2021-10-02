package com.knifedude.menu.essentials.sponge.domain.text;


import com.knifedude.menuessentials.api.text.models.Text;
import com.knifedude.menuessentials.api.text.models.font.FontColor;
import com.knifedude.menuessentials.api.text.models.font.FontStyle;

import javax.annotation.Nonnull;
import java.util.List;

public class SpongeTextWrapper implements Text {

    private org.spongepowered.api.text.Text spongeText;

    public SpongeTextWrapper(String content) {
        this(org.spongepowered.api.text.Text.of(content));
    }

    public SpongeTextWrapper(org.spongepowered.api.text.Text spongeText) {
        this.spongeText = spongeText;
    }

    public org.spongepowered.api.text.Text getSpongeText() {
        return spongeText;
    }


    @Nonnull
    @Override
    public String getContent() {
        return null;
    }

    @Override
    public Text concat(Text other) {
        return null;
    }

    @Override
    public Text copy() {
        return null;
    }

    @Override
    public FontColor getColor() {
        return null;
    }

    @Override
    public List<FontStyle> getStyle() {
        return null;
    }

    @Override
    public boolean hasFormat(FontStyle style) {
        return false;
    }
}
