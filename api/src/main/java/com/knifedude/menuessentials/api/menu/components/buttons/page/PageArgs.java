package com.knifedude.menuessentials.api.menu.components.buttons.page;

import com.google.common.collect.Maps;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class PageArgs {

    private static final String CURRENT_PAGE = "page.current";
    private static final String NEXT_PAGE = "page.next";
    private static final String PREVIOUS_PAGE = "page.previous";

    private Map<String,Object> args;

    public PageArgs() {
        this.args = Maps.newHashMap();
    }

    public Map<String,Object> toMap() {
        return new HashMap<>(args);
    }

    public void setCurrentPageByIndex(int currentPageIndex) {
        this.args.put(CURRENT_PAGE, currentPageIndex + 1);
    }

    public void setNextPageByIndex(int nextPageIndex) {
        this.args.put(NEXT_PAGE, nextPageIndex + 1);
    }

    public void setPreviousPageByIndex(int previousPageByIndex)  {
        this.args.put(PREVIOUS_PAGE, previousPageByIndex + 1);
    }

    public static Integer getCurrentPage(Map<String,?> args) {
        return Optional.ofNullable(args.get(CURRENT_PAGE)).map(object -> (int) object).orElse(null);
    }

    public static Integer getNextPage(Map<String,?> args) {
        return Optional.ofNullable(args.get(NEXT_PAGE)).map(object -> (int) object).orElse(null);
    }

    public static Integer getPreviousPage(Map<String,?> args) {
        return Optional.ofNullable(args.get(PREVIOUS_PAGE)).map(object -> (int) object).orElse(null);
    }

}
