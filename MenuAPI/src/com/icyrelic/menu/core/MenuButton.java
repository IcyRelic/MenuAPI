package com.icyrelic.menu.core;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 * @author IcyRelic
 */

public abstract class MenuButton {

    protected ItemStack item;
    protected int slot;
    protected Menu menu;

    /**
     * Creates a MenuButton
     * @param menu - The Menu it belongs to.
     * @param item - The item that will be displayed.
     * @param slot - The slot the item will be in.
     */
    public MenuButton(Menu menu, ItemStack item, int slot) {
        this.menu = menu;
        this.item = item;
        this.slot = slot;
    }

    /**
     * Get the item of the button.
     * @return The ItemStack
     */
    public ItemStack getItem() {
        return item;
    }

    /**
     * Get the slot number of the button.
     * @return The slot number.
     */
    public int getSlot() {
        return slot;
    }

    /**
     * Execute the buttons action.
     * @param player - The player who clicked.
     */
    public abstract void execute(Player player);

}