package com.knifedude.menuessentials.api.menu.components.buttons.page;

import com.knifedude.menuessentials.api.menu.components.buttons.Button;
import com.knifedude.menuessentials.api.text.models.Text;

import java.util.function.Function;

public interface NextPageButtonBuilder<TInstance extends Button, TBuilder extends NextPageButtonBuilder<TInstance,TBuilder>> extends PageButtonBuilder<TInstance,TBuilder> {

    TBuilder withNextPageText(Function<Integer, Text> textFunction);

}
