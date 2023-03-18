package me.eggerga.spleefplugin2;

import me.eggerga.spleefplugin2.commands.Set;
import me.eggerga.spleefplugin2.commands.Start;
import me.eggerga.spleefplugin2.manager.GameManager;
import me.eggerga.spleefplugin2.manager.GameState;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class SpleefPlugin extends JavaPlugin implements Listener {
    private GameManager gameManager = new GameManager(this);

    @Override
    public void onEnable() {
        // Register commands & events
        getServer().getPluginManager().registerEvents(this, this);
        getCommand("start").setExecutor(new Start(this));
        getCommand("set").setExecutor(new Set(this));

        System.out.println("Spleef plugin is ready!");
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        event.getPlayer().sendMessage(ChatColor.YELLOW + "Welcome to the spleef server!");
    }

    public GameManager getGameManager() {
        return gameManager;
    }
}
