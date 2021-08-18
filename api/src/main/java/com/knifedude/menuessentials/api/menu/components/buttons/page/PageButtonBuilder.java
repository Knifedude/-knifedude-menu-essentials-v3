package com.knifedude.menuessentials.api.menu.components.buttons.page;

import com.knifedude.menuessentials.api.menu.components.buttons.Button;
import com.knifedude.menuessentials.api.menu.components.buttons.ButtonBuilder;
import com.knifedude.menuessentials.api.text.models.Text;

public interface PageButtonBuilder<TInstance extends Button,TBuilder extends  PageButtonBuilder<TInstance,TBuilder>> extends ButtonBuilder<TInstance,TBuilder> {

    TBuilder withPrefix(Text text);

}
