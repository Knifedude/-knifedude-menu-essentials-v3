package com.knifedude.menu.essentials.sponge.domain.text;

import com.knifedude.menuessentials.api.text.models.Text;
import com.knifedude.menuessentials.api.text.models.font.FontColor;
import com.knifedude.menuessentials.api.text.models.font.FontStyle;

public class SpongeTextBuilderWrapper implements Text.Builder {

    private final org.spongepowered.api.text.Text.Builder spongeBuilder;

    public SpongeTextBuilderWrapper() {
        this(org.spongepowered.api.text.Text.builder());
    }

    public SpongeTextBuilderWrapper(org.spongepowered.api.text.Text.Builder spongeBuilder) {
        this.spongeBuilder = spongeBuilder;
    }

    @Override
    public Text.Builder content(String content) {
        spongeBuilder.append(org.spongepowered.api.text.Text.of(content));
        return this;
    }

    @Override
    public Text.Builder content(Text content) {
        spongeBuilder.append(((SpongeTextWrapper) content).getSpongeText());
        return this;
    }

    @Override
    public Text.Builder color(FontColor color) {
        spongeBuilder.color(SpongeTextColorMapper.mapFontColor(color));
        return this;
    }

    @Override
    public Text.Builder style(FontStyle... styles) {
        spongeBuilder.style(SpongeTextStyleMapper.mapFontStyleToTextStyle(styles));
        return this;
    }

    @Override
    public Text build() {
        return new SpongeTextWrapper(spongeBuilder.build());
    }
}
