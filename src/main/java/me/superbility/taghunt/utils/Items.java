package me.superbility.taghunt.utils;

import de.tr7zw.nbtapi.NBTItem;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class Items {
    public static ItemStack getCompass() {
        ItemStack item = new ItemStack(Material.COMPASS);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.colorise("&a&lPlayer Tracker"));
        meta.setLore(ChatColor.colorise(Arrays.asList("&7Click this item to set it's", "&7target location to the runner!")));
        item.setItemMeta(meta);

        NBTItem nbtItem = new NBTItem(item);
        nbtItem.setBoolean("compass", true);

        return nbtItem.getItem();
    }
    public static ItemStack getBrokenCompass() {
        ItemStack item = new ItemStack(Material.NETHER_STAR);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.colorise("&c&lBroken Player Tracker"));
        meta.setLore(ChatColor.colorise(Arrays.asList("&7You will get your player tracker", "&7back when you become the hunter!")));
        item.setItemMeta(meta);

        NBTItem nbtItem = new NBTItem(item);
        nbtItem.setBoolean("compass", true);

        return nbtItem.getItem();
    }
}
