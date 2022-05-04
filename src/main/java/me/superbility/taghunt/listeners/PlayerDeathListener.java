package me.superbility.taghunt.listeners;

import de.tr7zw.nbtapi.NBTItem;
import me.superbility.taghunt.Main;
import me.superbility.taghunt.data.Game;
import me.superbility.taghunt.utils.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class PlayerDeathListener implements Listener {
    private Main plugin = Main.getPlugin(Main.class);

    @EventHandler
    private void onDeath(PlayerDeathEvent e) {
        Game game = plugin.currentGame;
        if(game != null) {
            if(!e.getDrops().isEmpty()) {
                for (ItemStack i : e.getDrops()) {
                    NBTItem nbtItem = new NBTItem(i);
                    if (nbtItem.hasKey("compass")) {
                        e.getDrops().remove(i);
                    }
                }
            }

            if(e.getEntity() == plugin.currentGame.getRunner()) {
                List<Player> players = new ArrayList<Player>(Bukkit.getOnlinePlayers());
                players.remove(e.getEntity());

                Player player = players.get(ThreadLocalRandom.current().nextInt(0, players.size()));
                Bukkit.broadcastMessage(ChatColor.colorise("&a&lThe runner has died! The new runner is &6&l" + player.getDisplayName()));

                plugin.currentGame.setRunner(player);
            }
        }
    }
}
