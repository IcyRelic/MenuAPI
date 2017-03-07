package com.icyrelic.menu.events;

import com.icyrelic.menu.core.MenuHolder;
import com.icyrelic.menu.event.MenuClickEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

/**
 * @author IcyRelic
 */
public class InventoryClick implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    private void onInventoryClick(InventoryClickEvent event){
        if(event.getClickedInventory() == null) return;
        if(event.getClickedInventory().getHolder() instanceof MenuHolder) {
            Player player = ((Player) event.getWhoClicked());
            Inventory inventory = event.getClickedInventory();
            int slot = event.getSlot();

            MenuClickEvent menuClickEvent = new MenuClickEvent(player, inventory, slot);

            Bukkit.getPluginManager().callEvent(menuClickEvent);

            event.setCancelled(true);
        }
    }

}
