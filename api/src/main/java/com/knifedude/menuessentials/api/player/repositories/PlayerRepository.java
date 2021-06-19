package com.knifedude.menuessentials.api.player.repositories;

import com.knifedude.menuessentials.api.player.models.Player;

import java.util.Optional;
import java.util.UUID;

public interface PlayerRepository {

    Optional<Player> findByUUID(UUID player);

}
