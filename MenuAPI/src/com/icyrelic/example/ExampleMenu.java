package com.icyrelic.example;

import com.icyrelic.menu.core.Menu;
import com.icyrelic.menu.core.MenuButton;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * @author IcyRelic
 */
public class ExampleMenu extends Menu {

    /**
     * Creates an example menu and automatically opens.
     * @param player
     */
    public ExampleMenu(Player player) {
        super(player, "Example Menu", 9, null);
    }

    @Override
    protected void addButtons() {
        ItemStack item = new ItemStack(Material.WOOL, 1, (short) 5);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(ChatColor.GREEN + "Send Example Message");
        item.setItemMeta(meta);

        addButton(new ExampleButton(this, item, 0));

        meta.setDisplayName(ChatColor.RED + "Open Example Menu Two");
        item.setItemMeta(meta);
        item.setDurability((short) 14);

        addButton(new MenuButton(this, item, 8) {
            @Override
            public void execute(Player player) {
                ExampleMenuTwo exampleMenuTwo = new ExampleMenuTwo(player);

                //do Something before it opens

                exampleMenuTwo.open();
                player.sendMessage(ChatColor.GREEN + "ExampleMenuTwo Menu Opened.");

            }
        });

    }
}
