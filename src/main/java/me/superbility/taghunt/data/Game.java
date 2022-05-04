package me.superbility.taghunt.data;

import me.superbility.taghunt.Main;
import me.superbility.taghunt.utils.ChatColor;
import me.superbility.taghunt.utils.Items;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.WorldType;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.FileUtil;

import java.io.File;
import java.util.UUID;

public class Game {
    private Main plugin = Main.getPlugin(Main.class);

    private Player runner;


    public Game(Player runner) {
        this.runner = runner;

        startSequence();
    }
    private void startSequence() {
        Player p1 = runner.getPlayer();

        new BukkitRunnable() {
            int counter = 3;
            @Override
            public void run() {
                for(Player player : Bukkit.getOnlinePlayers()) {
                    player.sendTitle(ChatColor.colorise("&9&lTag-Hunt"), ChatColor.colorise("&aGame starting in: " + counter), 2, 20, 2);
                }

                counter--;

                if(counter <= 0) {
                    cancel();
                }
            }
        }.runTaskTimer(plugin, plugin.countdownTime, plugin.countdownTime);



        for(Player player : Bukkit.getOnlinePlayers()) {
            player.getInventory().clear();
            if(player != p1) {
                player.getInventory().setItem(8, Items.getCompass());

                player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, plugin.headstartTime, 999999));
                player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, plugin.headstartTime, 999999));
            }
        }
        p1.getInventory().setItem(8, Items.getBrokenCompass());

        sendTitles();
    }
    private void sendTitles() {
        new BukkitRunnable() {
            @Override
            public void run() {
                if(plugin.currentGame != null) {
                    for(Player player : Bukkit.getOnlinePlayers()) {
                        if (player != runner) {
                            player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(ChatColor.colorise("&c&lYou are a HUNTER!")));
                        } else {
                            player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(ChatColor.colorise("&a&lYou are a RUNNER!")));
                        }
                    }
                } else {
                    cancel();
                }
            }
        }.runTaskTimer(plugin, 20, 20);
    }

    public void setRunner(Player player) {
        this.runner = player;

        player.getInventory().setItem(8, Items.getBrokenCompass());

        for(Player p : Bukkit.getOnlinePlayers()) {
            if (p != player) {
                p.getInventory().setItem(8, Items.getCompass());
            }
        }
    }
    public Player getRunner() {
        return runner;
    }
}
