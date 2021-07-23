package com.knifedude.menuessentials.api.text.factories;

import com.knifedude.menuessentials.api.text.models.TextTemplate;

public interface TextTemplateFactory {

    TextTemplate of(Object... elements);

}
