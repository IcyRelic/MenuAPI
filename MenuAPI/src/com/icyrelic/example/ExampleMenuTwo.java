package com.icyrelic.example;

import com.icyrelic.menu.core.Menu;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * @author IcyRelic
 */

public class ExampleMenuTwo extends Menu {

    /**
     * Creates an example menu.
     * @param player
     */
    public ExampleMenuTwo(Player player) {
        super(player, "Example Menu Two", 9, null, false);
    }

    @Override
    protected void addButtons() {
        ItemStack item = new ItemStack(Material.WOOL, 1, (short) 2);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(ChatColor.GREEN + "Send Example Message");
        item.setItemMeta(meta);

        addButton(new ExampleButton(this, item, 4));

    }
}
