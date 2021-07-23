package com.knifedude.menuessentials.api.text.models;

import com.knifedude.menuessentials.api.common.register.Register;
import com.knifedude.menuessentials.api.text.factories.TextTemplateFactory;

import java.util.Map;

public interface TextTemplate {

    Text toText(Map<String, ?> args);

    static TextTemplate of(Object... elements) {
        return Register.getFactory(TextTemplateFactory.class).of(elements);
    }

}
