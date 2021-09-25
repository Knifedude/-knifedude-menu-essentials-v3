package com.knifedude.menuessentials.api.menu.components.buttons.page.previous;

import com.knifedude.menuessentials.api.common.register.Register;
import com.knifedude.menuessentials.api.menu.components.buttons.page.PageButtonBuilder;
import com.knifedude.menuessentials.api.text.models.Text;

import java.util.function.Function;

public interface PreviousPageButtonBuilder<TInstance extends PreviousPageButton, TBuilder extends PreviousPageButtonBuilder<TInstance,TBuilder>> extends PageButtonBuilder<TInstance, TBuilder> {

    TBuilder withPreviousPageText(Function<Integer, Text> textFunction);

    static PreviousPageButtonBuilder<?,?> builder() {
        return Register.getBuilder(PreviousPageButtonBuilder.class);
    }

}
