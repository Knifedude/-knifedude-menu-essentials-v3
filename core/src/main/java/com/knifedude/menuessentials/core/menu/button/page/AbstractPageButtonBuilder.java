package com.knifedude.menuessentials.core.menu.button.page;

import com.knifedude.menuessentials.api.menu.behaviors.Pageable;
import com.knifedude.menuessentials.api.menu.components.buttons.page.PageButton;
import com.knifedude.menuessentials.api.menu.components.buttons.page.PageButtonBuilder;
import com.knifedude.menuessentials.api.text.models.Text;
import com.knifedude.menuessentials.core.menu.button.AbstractButtonBuilderImpl;
import java.util.function.Function;

public abstract class AbstractPageButtonBuilder<TPageButtonType extends PageButton, TPageButtonBuilder extends PageButtonBuilder<TPageButtonType,TPageButtonBuilder>>
        extends AbstractButtonBuilderImpl<TPageButtonType,TPageButtonBuilder>
        implements PageButtonBuilder<TPageButtonType,TPageButtonBuilder> {

    protected Pageable target;
    protected Function<Integer, Text> textFunction;

    @Override
    public TPageButtonBuilder withCurrentPageText(Function<Integer, Text> textFunction) {
        this.textFunction = textFunction;
        return (TPageButtonBuilder) this;
    }

    @Override
    public TPageButtonBuilder withTarget(Pageable container) {
        this.target = container;
        return (TPageButtonBuilder) this;
    }

    protected void apply(TPageButtonType instance) {
        super.apply(instance);

        instance.setCurrentPageTemplate();
    }


}
