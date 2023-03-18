package me.eggerga.spleefplugin2.manager;

import me.eggerga.spleefplugin2.SpleefPlugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Collections;

public class GameManager {
    private final SpleefPlugin plugin;
    private GameState gameState = GameState.LOBBY;

    public GameManager(SpleefPlugin plugin) {
        this.plugin = plugin;
        this.gameShovel = new ItemStack(Material.WOODEN_SHOVEL);

        // may have to get and set item meta in two different lines
        gameShovel.getItemMeta().setDisplayName(ChatColor.DARK_GRAY + "Wooden Spoon");
        gameShovel.getItemMeta().setLore(Collections.singletonList(ChatColor.DARK_PURPLE + "Is it really just a wooden spoon?"));
    }

    private GameState getGameState() {
        return gameState;
    }
    private Location arenaSpawnLocation;
    private Location lobbyLocation;
    private ItemStack gameShovel;

    public void setGameState(GameState gameState) {
        this.gameState = gameState;

        switch(gameState) {
            case LOBBY:
                Bukkit.broadcastMessage("LOBBY");
                break;
            case STARTING:
                for (Player player: Bukkit.getOnlinePlayers()) {
                    player.teleport(arenaSpawnLocation);

                    // TODO: Countdown and game instruction titles
                    // Final step in countdown should be "Spread Out!"

                    player.getInventory().addItem(gameShovel);
                }

                Bukkit.broadcastMessage("STARTING");
                break;
            case ACTIVE:
                Bukkit.broadcastMessage("ACTIVE");
                break;
            case WINNERS:
                Bukkit.broadcastMessage("WINNERS");
                break;
            case CLEANUP:
                Bukkit.broadcastMessage("CLEANUP");
                break;
            default:
                Bukkit.broadcastMessage("INVALID GAME STATE");
                break;
        }
    }

    public SpleefPlugin getPlugin() {
        return plugin;
    }

    public Location getArenaSpawnLocation() {
        return arenaSpawnLocation;
    }

    public void setArenaSpawnLocation(Location arenaSpawnLocation) {
        this.arenaSpawnLocation = arenaSpawnLocation;
    }

    public Location getLobbyLocation() {
        return lobbyLocation;
    }

    public void setLobbyLocation(Location lobbyLocation) {
        this.lobbyLocation = lobbyLocation;
    }
}
