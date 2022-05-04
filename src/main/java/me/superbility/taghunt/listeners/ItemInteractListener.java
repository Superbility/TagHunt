package me.superbility.taghunt.listeners;

import de.tr7zw.nbtapi.NBTItem;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;

public class ItemInteractListener implements Listener {
    @EventHandler
    private void onDrop(PlayerDropItemEvent e) {
        NBTItem item = new NBTItem(e.getItemDrop().getItemStack());
        if(item.hasKey("compass")) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    private void onClick(InventoryClickEvent e) {
        if(e.getCurrentItem() != null && e.getCurrentItem().getType() != Material.AIR) {
            NBTItem item = new NBTItem(e.getCurrentItem());
            if (item.hasKey("compass")) {
                e.setCancelled(true);
            }
        }
    }
}
