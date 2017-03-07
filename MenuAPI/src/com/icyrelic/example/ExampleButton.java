package com.icyrelic.example;

import com.icyrelic.menu.core.Menu;
import com.icyrelic.menu.core.MenuButton;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 * @author IcyRelic
 */
public class ExampleButton extends MenuButton {

    /**
     * Creates an example button.
     * @param menu - The Menu
     * @param item - The ItemStack
     * @param slot - The Slot Number
     */
    public ExampleButton(Menu menu, ItemStack item, int slot) {
        super(menu, item, slot);
    }

    @Override
    public void execute(Player player) {
        player.sendMessage("This is an ExampleButton from the menu '"+menu.getTitle()+"'");
    }
}
