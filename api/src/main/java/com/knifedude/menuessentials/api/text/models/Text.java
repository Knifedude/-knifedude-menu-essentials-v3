package com.knifedude.menuessentials.api.text.models;

import com.knifedude.menuessentials.api.common.register.Register;
import com.knifedude.menuessentials.api.text.factories.TextFactory;
import com.knifedude.menuessentials.api.text.models.font.FontColor;
import com.knifedude.menuessentials.api.text.models.font.FontStyle;

import javax.annotation.Nonnull;
import java.util.List;

public interface Text extends Comparable<Text> {

    @Nonnull String getContent();

    default boolean isEmpty() {
        return getContent().isEmpty();
    }

    Text concat(Text other);

    Text copy();

    Text.Builder toBuilder();

    default Text concat(String other) {
        return concat(Text.of(other));
    }

    @Override
    default int compareTo(Text otherText) {
        return this.getContent().compareTo(otherText.getContent());
    }

    static Text of(Object content) {
        return of(String.valueOf(content));
    }

    static Text of(String content) {
        return Register.getFactory(TextFactory.class).createWithText(content);
    }

    static Text toStyledText(String text, FontColor color, FontStyle... styles) {
        return Text.builder()
                   .content(text)
                   .color(color)
                   .style(styles != null ? styles :  new FontStyle[]{})
                   .build();
    }



    static Text empty() {
        return Register.getFactory(TextFactory.class).createEmpty();
    }

    static Builder builder() {
        return Register.getBuilder(Text.Builder.class);
    }


    interface Builder {

        Builder content(String content);

        Builder content(Text text);

        Builder color(FontColor color);

        Builder style(FontStyle... styles);

        Text build();

    }



}
