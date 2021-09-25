package com.knifedude.menuessentials.api.menu.components.buttons.page.next;

import com.knifedude.menuessentials.api.common.register.Register;
import com.knifedude.menuessentials.api.menu.components.buttons.page.PageButtonBuilder;
import com.knifedude.menuessentials.api.text.models.Text;

import java.util.function.Function;

public interface NextPageButtonBuilder<TInstance extends NextPageButton, TBuilder extends NextPageButtonBuilder<TInstance,TBuilder>> extends PageButtonBuilder<TInstance, TBuilder> {

    TBuilder withNextPageText(Function<Integer, Text> textFunction);

    static NextPageButtonBuilder<?,?> builder() {
        return Register.getBuilder(NextPageButtonBuilder.class);
    }

}
