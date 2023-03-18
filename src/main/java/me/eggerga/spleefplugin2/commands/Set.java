package me.eggerga.spleefplugin2.commands;

import me.eggerga.spleefplugin2.SpleefPlugin;
import me.eggerga.spleefplugin2.manager.GameManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Set implements CommandExecutor {
    private SpleefPlugin plugin;

    public Set(SpleefPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = null;

        if(sender instanceof Player) {
            player = (Player) sender;
        }

        GameManager gameManager = plugin.getGameManager();

        if(args != null) {
            switch(args[0]) {
                case "lobby":
                    gameManager.setLobbyLocation(player.getLocation());
                    break;
                case "arena":
                    gameManager.setArenaSpawnLocation(player.getLocation());
            }
        }

        return  false;
    }
}
