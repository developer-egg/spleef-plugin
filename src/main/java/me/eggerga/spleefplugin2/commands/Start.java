package me.eggerga.spleefplugin2.commands;

import me.eggerga.spleefplugin2.SpleefPlugin;
import me.eggerga.spleefplugin2.manager.GameManager;
import me.eggerga.spleefplugin2.manager.GameState;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Start implements CommandExecutor {
    private SpleefPlugin plugin;

    public Start(SpleefPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        GameManager gameManager = plugin.getGameManager();

        // logic for game start is in GameManager
        gameManager.setGameState(GameState.STARTING);
        return false;
    }
}
