package com.knifedude.menuessentials.api.collection;

import com.google.common.base.Preconditions;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class TagCollection {

    private Set<String> tags;

    public TagCollection(Set<String> tags) {
        Preconditions.checkNotNull(tags, "Constructor parameter 'tags' may not be null");
        this.tags = tags;
    }

    public TagCollection() {
        this.tags = new HashSet<>();
    }

    public void add(String tag) {
        this.tags.add(tag);
    }

    public void addAll(Collection<String> tags) {
        this.tags.addAll(tags);
    }

    public void addAll(String... tags) {
        for (String tag : tags) {
            this.tags.add(tag);
        }
    }

    public boolean has(String tag) {
        return tags.contains(tag);
    }

    public boolean hasAll(String... tags) {
        for (String tag : tags) {
            if (!has(tag)) {
                return false;
            }
        }
        return true;
    }

    public boolean hasAny(String... tags) {
        for (String tag : tags) {
            if (has(tag)) {
                return true;
            }
        }
        return false;
    }

    public void remove(String tag) {
        this.tags.remove(tag);
    }

    public void removeAll(String... tags) {
        if (tags == null) return;
        for (String tag : tags) {
            this.tags.remove(tag);
        }
    }

    public void removeAll(Collection<String> tags) {
        if (tags == null) return;
        this.tags.removeAll(tags);
    }

}
