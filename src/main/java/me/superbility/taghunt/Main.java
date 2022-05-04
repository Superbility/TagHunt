package me.superbility.taghunt;

import me.superbility.taghunt.commands.MainCommand;
import me.superbility.taghunt.data.Game;
import me.superbility.taghunt.listeners.*;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public final class Main extends JavaPlugin {
    public Game currentGame = null;
    public int headstartTime = getConfig().getInt("runnerHeadstart") * 20;
    public int countdownTime = getConfig().getInt("gameCountdownTime") * 20;

    @Override
    public void onEnable() {
        saveDefaultConfig();

        getServer().getPluginManager().registerEvents(new TagListener(), this);
        getServer().getPluginManager().registerEvents(new DragonDeathListener(), this);
        getServer().getPluginManager().registerEvents(new DragonHitListener(), this);
        getServer().getPluginManager().registerEvents(new ItemInteractListener(), this);
        getServer().getPluginManager().registerEvents(new CompassClickListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerDeathListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerRespawnListener(), this);

        getCommand("taghunt").setExecutor(new MainCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
