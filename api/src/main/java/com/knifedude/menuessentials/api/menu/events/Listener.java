package com.knifedude.menuessentials.api.menu.events;

public interface Listener<TEvent> {

    void onEvent(TEvent event);

}
