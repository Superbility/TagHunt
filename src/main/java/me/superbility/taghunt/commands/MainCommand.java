package me.superbility.taghunt.commands;

import me.superbility.taghunt.Main;
import me.superbility.taghunt.data.Game;
import me.superbility.taghunt.utils.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainCommand implements CommandExecutor {
    private Main plugin = Main.getPlugin(Main.class);

    private static List<String> helpMessage = new ArrayList<>(ChatColor.colorise(Arrays.asList(
            "&9&l=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=",
            " &d&lTag-Hunt: Commands",
            "",
            "&c Admin Commands",
            "&7  - &a/taghunt help &7- Displays this message",
            "&7  - &a/taghunt start [runner] &7- Starts a game",
            "&7  - &a/taghunt end &7- Ends the game a player is in",
            "&9&l=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-="
    )));

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(cmd.getName().equalsIgnoreCase("taghunt")) {
            if(args.length > 0) {
                if(args[0].equalsIgnoreCase("help")) {
                    for(String s : helpMessage) {
                        sender.sendMessage(s);
                    }
                }
                if(args[0].equalsIgnoreCase("start")) {
                    if(args.length > 1) {
                        Player player1 = Bukkit.getPlayerExact(args[1]);

                        if(player1 == null) {
                            sender.sendMessage(ChatColor.colorise("&aPlayer '" + args[1] + "' was not found!"));
                            return true;
                        }

                        if(plugin.currentGame != null) {
                            sender.sendMessage(ChatColor.colorise("&cThere is already a game running!"));
                            return true;
                        }

                        Game game = new Game(player1);
                        plugin.currentGame = game;

                        sender.sendMessage(ChatColor.colorise("&aGame created successfully!"));
                    } else {
                        sender.sendMessage(ChatColor.colorise("&aUsage: /taghunt start [player1]"));
                    }
                }
                if(args[0].equalsIgnoreCase("end")) {
                    plugin.currentGame = null;
                    sender.sendMessage(ChatColor.colorise("&aGame ended successfully!"));
                }
            } else {
                sender.sendMessage(ChatColor.colorise("&9Tag-Hunt &acreated by &9Superbility"));
                sender.sendMessage(ChatColor.colorise("&aUse &a/taghunt help &9for a list of commands!"));
            }
            return true;
        }
        return false;
    }
}
