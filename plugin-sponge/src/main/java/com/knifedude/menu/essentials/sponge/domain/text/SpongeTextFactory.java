package com.knifedude.menu.essentials.sponge.domain.text;

import com.knifedude.menuessentials.api.text.factories.TextFactory;
import com.knifedude.menuessentials.api.text.models.Text;

public class SpongeTextFactory implements TextFactory {
    @Override
    public Text createWithText(String content) {
        return new SpongeText(org.spongepowered.api.text.Text.of(content));
    }

    @Override
    public Text createEmpty() {
        return new SpongeText(org.spongepowered.api.text.Text.of());
    }
}
