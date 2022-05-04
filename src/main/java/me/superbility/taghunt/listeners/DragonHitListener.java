package me.superbility.taghunt.listeners;

import me.superbility.taghunt.Main;
import me.superbility.taghunt.data.Game;
import me.superbility.taghunt.utils.ChatColor;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class DragonHitListener implements Listener {
    private Main plugin = Main.getPlugin(Main.class);

    @EventHandler
    private void onHit(EntityDamageByEntityEvent e) {
        if(e.getDamager() instanceof Player && e.getEntity() instanceof EnderDragon) {
            Player damager = (Player) e.getDamager();

            Game game = plugin.currentGame;

            if(game != null) {
                if(game.getRunner() == damager) {
                    e.setCancelled(true);
                    damager.sendMessage(ChatColor.colorise("&aYou must be a runner to damage the dragon!"));
                }
            }
        }
    }
}
