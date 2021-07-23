package com.knifedude.menuessentials.api.menu;

import java.util.function.Predicate;

public class Matcher {

    private Matcher() {}

    public static Predicate<SlotComponent> hasAllTags(String... tags) {
        return (slotComponent -> slotComponent.tags().hasAll(tags));
    }

    public static Predicate<SlotComponent> hasAnyTags(String... tags) {
        return (slotComponent -> slotComponent.tags().hasAny(tags));
    }

    public static Predicate<SlotComponent> isOfType(Class<? extends SlotComponent> componentTypeClazz) {
        return componentTypeClazz::isInstance;
    }


}
