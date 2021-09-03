package com.knifedude.menuessentials.api.collection;

import com.knifedude.menuessentials.api.common.register.Register;

import java.util.Collection;
import java.util.NoSuchElementException;

public interface PageSource<TElement> {

    /**
     * Get a page by index. Pageindex must be >= 0
     * @param pageIndex The index of the page
     * @throws NoSuchElementException If the page does not exist
     * @return The items that would be on the given page index
     */
    Collection<TElement> getPage(int pageIndex, int pageSize) throws NoSuchElementException;

    /**
     * Determines whether a page on a given index exists
     * @param pageIndex The index of the page
     * @return True if the page does exist
     */
    boolean hasPage(int pageIndex, int pageSize);

    static <TElement> PageSource<TElement> from(Collection<TElement> elements) {
        return Register.getFactory(PageSourceFactory.class).create(elements);
    }

}
