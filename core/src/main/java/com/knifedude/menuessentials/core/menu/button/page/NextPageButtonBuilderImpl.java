package com.knifedude.menuessentials.core.menu.button.page;

import com.knifedude.menuessentials.api.menu.components.buttons.page.next.NextPageButton;
import com.knifedude.menuessentials.api.menu.components.buttons.page.next.NextPageButtonBuilder;
import com.knifedude.menuessentials.api.text.models.Text;

import java.util.function.Function;

public class NextPageButtonBuilderImpl
        extends AbstractPageButtonBuilder<NextPageButton, NextPageButtonBuilderImpl>
        implements NextPageButtonBuilder<NextPageButton, NextPageButtonBuilderImpl>
{

    private Function<Integer, Text> textFunction;



    @Override
    public NextPageButtonBuilderImpl withNextPageText(Function<Integer, Text> textFunction) {
        this.textFunction = textFunction;
        return this;
    }


    @Override
    public NextPageButton build() {
        NextPageButton nPB = new NextPageButton(this.createDisplayItem(), tags);


        return null;
    }

}
