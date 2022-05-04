package me.superbility.taghunt.listeners;

import me.superbility.taghunt.Main;
import me.superbility.taghunt.data.Game;
import me.superbility.taghunt.utils.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class DragonDeathListener implements Listener {
    private Main plugin = Main.getPlugin(Main.class);

    @EventHandler
    private void onDeath(EntityDeathEvent e) {
        if(e.getEntity().getType() == EntityType.ENDER_DRAGON) {
            Game game = plugin.currentGame;

            if(game != null) {
                for(Player player : Bukkit.getOnlinePlayers()) {
                    player.sendTitle(ChatColor.colorise("&c&lGame Over!"), ChatColor.colorise("&6" + game.getRunner().getDisplayName() + " &ahas won the game!"), 10, 60, 10);
                }
            }
        }
    }
}
