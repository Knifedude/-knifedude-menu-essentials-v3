package com.knifedude.menuessentials.api.menu.components.buttons.page;

import com.knifedude.menuessentials.api.menu.behaviors.Pageable;
import com.knifedude.menuessentials.api.menu.components.buttons.Button;
import com.knifedude.menuessentials.api.menu.components.buttons.ButtonBuilder;
import com.knifedude.menuessentials.api.text.models.Text;

import java.util.function.Function;

public interface PageButtonBuilder<TInstance extends Button,TBuilder extends  PageButtonBuilder<TInstance,TBuilder>> extends ButtonBuilder<TInstance,TBuilder> {

    TBuilder withCurrentPageText(Function<Integer,Text> textFunction);

    TBuilder withTarget(Pageable container);

}
