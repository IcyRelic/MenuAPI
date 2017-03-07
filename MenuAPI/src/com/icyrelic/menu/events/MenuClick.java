package com.icyrelic.menu.events;

import com.icyrelic.menu.event.MenuClickEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

/**
 * @author IcyRelic
 */
public class MenuClick implements Listener {

    @EventHandler(priority = EventPriority.HIGH)
    private void onMenuClick(MenuClickEvent event){
        if(event.getButton() == null) return;

        event.getButton().execute(event.getPlayer());
    }
}
