package com.knifedude.menuessentials.api.text.factories;

import com.knifedude.menuessentials.api.text.models.Text;

public interface TextFactory {

    Text createWithText(String content);

    Text createEmpty();

}
