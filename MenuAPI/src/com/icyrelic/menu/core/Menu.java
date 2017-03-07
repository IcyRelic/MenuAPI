package com.icyrelic.menu.core;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author IcyRelic
 */

public abstract class Menu {

    protected List<MenuButton> buttons;
    protected Inventory inventory;
    protected Player player;
    protected MenuHolder owner;
    protected Menu parent;
    protected String title;
    protected int size;

    /**
     * Create an Inventory Menu
     * @param player - The player whom will use this menu
     * @param title - The title of the menu (Displayed in the Gui)
     * @param size - Size of the menu in multiple of 9 max of 54
     * @param parent - The parent gui. Can be null.
     */
    public Menu(Player player, String title, int size, Menu parent) {
        this.buttons = new ArrayList<>();
        this.player = player;
        this.title = title;
        this.size = size;
        this.owner = new MenuHolder(this);
        this.parent = parent;
        open();
    }

    /**
     * Create an Inventory Menu
     * @param player - The player whom will use this menu
     * @param title - The title of the menu (Displayed in the Gui)
     * @param size - Size of the menu in multiple of 9 max of 54
     * @param parent - The parent gui. Can be null.
     * @param open - Automatically open the menu?
     */
    public Menu(Player player, String title, int size, Menu parent, boolean open) {
        this.buttons = new ArrayList<>();
        this.player = player;
        this.title = title;
        this.size = size;
        this.owner = new MenuHolder(this);
        this.parent = parent;
        if(open) open();
    }

    /**
     * Title displayed at the top of the menu.
     * @return The title string.
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Set the title displayed on the menu.
     * @param title The new title.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Creates the inventory.
     */
    private void create(){
        inventory = Bukkit.createInventory(owner, size, title);
        addButtons();
    }

    /**
     * Adds a button to the menu
     * @param button The MenuButton to add.
     */
    protected void addButton(MenuButton button){
        this.buttons.add(button);
        inventory.setItem(button.getSlot(), button.getItem());
    }

    /**
     * Removes a MenuButton in the given Slot.
     * @param slot The slot number 0 - 53
     */
    protected void removeButton(int slot){
        if(getButton(slot) == null) return;
        buttons.remove(getButton(slot));
        inventory.setItem(slot, null);
    }

    /**
     * Gets a MenuButton in the given slot.
     * @param slot The slot number 0 - 53
     * @return MenuButton, Null
     */
    public MenuButton getButton(int slot){
        for(MenuButton button : buttons)
            if(button.getSlot() == slot) return button;
        return null;
    }

    /**
     * Opens the parent menu, if null close().
     */
    protected void openParent(){
        if(parent == null) { close(); return; }
        parent.open();
    }

    /**
     * Open the inventory.
     */
    public void open(){
        create();
        player.openInventory(inventory);
    }

    /**
     * Close the inventory
     */
    public void close(){
        player.closeInventory();
    }

    /**
     * Required method to add buttons to a menu
     */
    protected abstract void addButtons();
}
