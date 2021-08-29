package com.knifedude.menuessentials.api.item.exceptions;

public class ItemTypeNotFoundException extends RuntimeException {

    public ItemTypeNotFoundException(String message) {
        super(message);
    }

    public ItemTypeNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
