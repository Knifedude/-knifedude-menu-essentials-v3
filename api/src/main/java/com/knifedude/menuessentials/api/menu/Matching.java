package com.knifedude.menuessentials.api.menu;

import com.knifedude.menuessentials.api.common.models.Taggable;

import java.util.function.Predicate;

public class Matching {

    private Matching() {}

    public static Predicate<Taggable> allTags(String... tags) {
        return (slotComponent -> slotComponent.tags().hasAll(tags));
    }

    public static Predicate<Taggable> anyTags(String... tags) {
        return (slotComponent -> slotComponent.tags().hasAny(tags));
    }

    public static Predicate<?> isOfType(Class<?> componentTypeClazz) {
        return componentTypeClazz::isInstance;
    }


}
