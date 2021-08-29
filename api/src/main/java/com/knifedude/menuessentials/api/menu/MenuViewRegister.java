package com.knifedude.menuessentials.api.menu;

import java.util.Optional;
import java.util.UUID;

public interface MenuViewRegister {

    void registerView(UUID player, MenuView menuView);

    Optional<MenuView> removeView(UUID player);

    Optional<MenuView> findView(UUID playerUUID);

}
