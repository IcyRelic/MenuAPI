package com.icyrelic.menu;

import com.icyrelic.menu.events.InventoryClick;
import com.icyrelic.menu.events.MenuClick;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author IcyRelic
 */
public class MenuAPI extends JavaPlugin {

    public static MenuAPI Instance;
    private String prefix = "[" + ChatColor.GREEN + "MenuAPI" + ChatColor.WHITE + "] ";

    public void onEnable() {
        Instance = this;
        Bukkit.getPluginManager().registerEvents(new InventoryClick(), this);
        Bukkit.getPluginManager().registerEvents(new MenuClick(), this);
        Bukkit.getConsoleSender().sendMessage(prefix + ChatColor.GREEN + "Enabled.");

                
    }
}
