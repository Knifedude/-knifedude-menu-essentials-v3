package com.knifedude.menuessentials.api.menu.components.buttons.page;

import com.knifedude.menuessentials.api.text.models.Text;
import com.knifedude.menuessentials.api.text.models.TextTemplate;

import java.util.Map;
import java.util.function.Function;

public class PageTextTemplate implements TextTemplate {

    private static final String INITIAL_PAGE = "-";
    private static final Function<Map<String,?>, Object> CURRENT_PAGE_MAPPING = (args) -> args.get(PageArgs.CURRENT_PAGE);
    private static final Function<Map<String,?>, Object> NEXT_PAGE_MAPPING = (args) -> args.get(PageArgs.NEXT_PAGE);
    private static final Function<Map<String,?>, Object> PREVIOUS_PAGE_MAPPING = (args) -> args.get(PageArgs.PREVIOUS_PAGE);

    private final Text keyName;
    private final Function<Text, Text> valueStyling;
    private final Function<Map<String, ?>, Object> valueMapper;

    /**
     * Constructor.
     *
     * The current page will be added to the lore of the menu item. It will be formatted as [KeyName]: [ValueOf:PageNr] <br><br/>
     *
     * @param keyName The name of the key that is displayed. Example: Current page: 9, where current page is the name of the key
     * @param valueStyling The function to determine how the value should be styled
     */
    private PageTextTemplate(Text keyName, Function<Text, Text> valueStyling, Function<Map<String, ?>, Object> valueMapper) {
        this.keyName = keyName;
        this.valueStyling = valueStyling;
        this.valueMapper = valueMapper;
    }

    public Text getKeyName() {
        return keyName.copy();
    }

    @Override
    public Text toText(Map<String, ?> args) {
        Object pageValue = valueMapper.apply(args);
        Text pageText = pageValue != null ? Text.of(pageValue) : Text.of(INITIAL_PAGE);
        if (valueStyling != null) {
            pageText = valueStyling.apply(pageText);
        }
        return keyName.copy().concat(":").concat(pageText);
    }

    public static PageTextTemplate currentPageTemplate(Text keyDisplayName, Function<Text, Text> valueStyling) {
        return new PageTextTemplate(keyDisplayName, valueStyling, CURRENT_PAGE_MAPPING);
    }

    public static PageTextTemplate currentPageTemplate(Text keyDisplayName) {
        return currentPageTemplate(keyDisplayName, null);
    }

    public static PageTextTemplate nextPageTemplate(Text keyDisplayName, Function<Text, Text> valueStyling) {
        return new PageTextTemplate(keyDisplayName, valueStyling, NEXT_PAGE_MAPPING);
    }

    public static PageTextTemplate nextPageTemplate(Text keyDisplayName) {
        return nextPageTemplate(keyDisplayName, null);
    }

    public static PageTextTemplate previousPageTemplate(Text keyDisplayName, Function<Text, Text> valueStyling) {
        return new PageTextTemplate(keyDisplayName, valueStyling, PREVIOUS_PAGE_MAPPING);
    }

    public static PageTextTemplate previousPageTemplate(Text keyDisplayName) {
        return previousPageTemplate(keyDisplayName, null);
    }



}
