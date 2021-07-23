package com.knifedude.menuessentials.api.player.exceptions;

import java.util.UUID;

public class PlayerNotAvailableException extends Exception {

    public PlayerNotAvailableException() {
    }

    public PlayerNotAvailableException(String message) {
        super(message);
    }

    public PlayerNotAvailableException(String message, Throwable cause) {
        super(message, cause);
    }


    public static void throwNotExists(UUID player) throws PlayerNotAvailableException {
        throw new PlayerNotAvailableException(String.format("Player with uuid '%s' does not exist", player));
    }

}
