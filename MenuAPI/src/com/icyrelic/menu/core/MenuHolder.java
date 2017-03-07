package com.icyrelic.menu.core;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

/**
 * @author IcyRelic
 */

public class MenuHolder implements InventoryHolder{

    private Menu menu;

    /**
     * MenuHolder object to hold all menus
     * @param menu - The created menu.
     */
    public MenuHolder(Menu menu) {
        this.menu = menu;
    }

    /**
     * The inventory of the menu.
     * @return The inventory of the Menu
     */
    public Inventory getInventory() {
        return menu.inventory;
    }

    /**
     * Get the menu that is being held.
     * @return The Menu
     */
    public Menu getMenu() {
        return this.menu;
    }

}

