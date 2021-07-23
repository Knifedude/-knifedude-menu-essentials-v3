package com.knifedude.menuessentials.api.text.models;

public interface TextArg extends TextElement {

    String getName();

    Text toText(String value);

    void setOptional(boolean optional);

    boolean isOptional();

}
