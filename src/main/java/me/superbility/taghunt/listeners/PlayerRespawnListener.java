package me.superbility.taghunt.listeners;

import me.superbility.taghunt.Main;
import me.superbility.taghunt.data.Game;
import me.superbility.taghunt.utils.Items;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

public class PlayerRespawnListener implements Listener {
    private Main plugin = Main.getPlugin(Main.class);

    @EventHandler
    private void onRespawn(PlayerRespawnEvent e) {
        Game game = plugin.currentGame;

        if(game != null) {
            if(game.getRunner() == e.getPlayer()) {
                e.getPlayer().getInventory().setItem(8, Items.getBrokenCompass());
            } else {
                e.getPlayer().getInventory().setItem(8, Items.getCompass());
            }
        }
    }
}
