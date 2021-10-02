package com.knifedude.menu.essentials.sponge.domain.text;

import com.google.common.base.Preconditions;
import com.knifedude.menuessentials.api.text.models.Text;
import javax.annotation.Nonnull;

public class SpongeText implements Text {

    private org.spongepowered.api.text.Text underlyingText;

    public SpongeText(String content) {
        this(org.spongepowered.api.text.Text.of(content));
    }

    public SpongeText(org.spongepowered.api.text.Text spongeText) {
        this.underlyingText = spongeText;
    }

    public org.spongepowered.api.text.Text getUnderlyingText() {
        return underlyingText;
    }

    @Nonnull
    @Override
    public String getContent() {
        return underlyingText.toPlain();
    }

    @Override
    public Text concat(Text other) {
        Preconditions.checkArgument(other instanceof SpongeText, "Unexpected implementation of Text. Expected: SpongeText");
        SpongeText spongeText = (SpongeText) other;
        return new SpongeText(this.underlyingText.concat(spongeText.underlyingText));
    }

    @Override
    public Text copy() {
        return new SpongeText(underlyingText.toBuilder().build());
    }

    public Text.Builder toBuilder() {
        return new SpongeTextBuilderWrapper(underlyingText);
    }


}
