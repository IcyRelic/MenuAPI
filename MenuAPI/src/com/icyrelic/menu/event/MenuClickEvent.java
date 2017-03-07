package com.icyrelic.menu.event;

import com.icyrelic.menu.core.Menu;
import com.icyrelic.menu.core.MenuButton;
import com.icyrelic.menu.core.MenuHolder;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.Inventory;

/**
 * @author IcyRelic
 */
public class MenuClickEvent extends Event {

    private static HandlerList handlers = new HandlerList();
    private Player player;
    private Inventory inv;
    private int slot;
    private Menu menu;
    private MenuButton button;

    public MenuClickEvent(Player player, Inventory inv, int slot){
        this.player = player;
        this.inv = inv;
        this.slot = slot;
        this.menu = ((MenuHolder) inv.getHolder()).getMenu();
        this.button = this.menu.getButton(slot);
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    public Player getPlayer() {
        return player;
    }

    public Inventory getInv() {
        return inv;
    }

    public int getSlot() {
        return slot;
    }

    public Menu getMenu() {
        return this.menu;
    }

    public MenuButton getButton() {
        return this.button;
    }
}