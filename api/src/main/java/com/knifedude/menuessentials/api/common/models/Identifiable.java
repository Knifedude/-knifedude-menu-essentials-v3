package com.knifedude.menuessentials.api.common.models;

import java.util.UUID;

public interface Identifiable {

    /**
     * Gets the unique id
     * @return The unique id
     */
    UUID getUniqueId();

}
