package me.superbility.taghunt.listeners;

import de.tr7zw.nbtapi.NBTItem;
import me.superbility.taghunt.Main;
import me.superbility.taghunt.data.Game;
import me.superbility.taghunt.utils.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class CompassClickListener implements Listener {
    private Main plugin = Main.getPlugin(Main.class);

    @EventHandler
    private void onClick(PlayerInteractEvent e) {
        if(e.getItem() != null) {
            NBTItem item = new NBTItem(e.getItem());
            if (item.hasKey("compass") && e.getItem().getType().equals(Material.COMPASS)) {
                Game game = plugin.currentGame;
                if (e.getPlayer().getWorld() == game.getRunner().getPlayer().getWorld()) {
                    e.getPlayer().setCompassTarget(game.getRunner().getPlayer().getLocation());
                    e.getPlayer().sendMessage(ChatColor.colorise("&aCompass location updated to the runners current position!"));
                } else {
                    e.getPlayer().sendMessage(ChatColor.colorise("&cFailed to change location!"));
                }
            }
        }
    }
}
