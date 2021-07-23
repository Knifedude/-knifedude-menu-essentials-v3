package com.knifedude.menuessentials.api.text.models;

import com.knifedude.menuessentials.api.common.register.Register;
import com.knifedude.menuessentials.api.text.factories.TextFactory;
import com.knifedude.menuessentials.api.text.models.font.FontColor;
import com.knifedude.menuessentials.api.text.models.font.FontStyle;

import javax.annotation.Nonnull;
import java.util.List;

public interface Text extends TextElement, Comparable<Text> {

    Iterable<Text> getChildren();

    /**
     * Gets the text without any formatting
     * @return The text
     */
    @Nonnull String getContent();

    default boolean isEmpty() {
        return getContent().isEmpty();
    }

    Text concat(Text other);

    default Builder toBuilder() {
        return Text.builder()
                .content(getContent())
                .color(getColor())
                .style(getStyle());
    }

    default Text copy() {
        return toBuilder()
                   .build();
    }

    default Text toLowerCase() {
        return toBuilder()
                .content(getContent().toLowerCase())
                .build();
    }

    default Text toUpperCase() {
        return toBuilder()
                .content(getContent().toUpperCase())
                .build();
    }

    /**
     * Compares this text's plaintext lower-cased value to another text's plaintext lowercase value
     * @param otherText The other text
     * @return the value {@code 0} if the argument plaintext-lowercase-value is equal to
     *          this plaintext-lowercase-value; a value less than {@code 0} if this plaintext-lowercase-value
     *          is lexicographically less than the plaintext-lowercase-value argument; and a
     *          value greater than {@code 0} if this plaintext-lowercase-value is
     *          lexicographically greater than the plaintext-lowercase-value argument.
     */
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

    static Text empty() {
        return Register.getFactory(TextFactory.class).createEmpty();
    }

    static Builder builder() {
        return Register.getBuilder(Text.Builder.class);
    }


    interface Builder {

        Builder content(String content);

        Builder color(FontColor color);

        Builder style(FontStyle... styles);

        Builder style(List<FontStyle> styles);

        Text build();

    }



}
