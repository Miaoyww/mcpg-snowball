package com.miaoyww.snowball;

import com.miaoyww.snowball.ready.getItem;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;

public class TeamManager {
    private static List<Player> readyPlayers = new ArrayList<>();
    private static getItem plugin;
    private static int maxPlayers = 5; // 假设最多 5 个玩家
    
    public static void setPlugin(getItem plugin) {
        TeamManager.plugin = plugin;
    }

    public static void addPlayerToReadyTeam(Player player) {
        readyPlayers.add(player);
    }

    public static void removePlayerFromReadyTeam(Player player) {
        readyPlayers.remove(player);
    }

    public static void startActionBarUpdater() {
        // 每隔一定时间更新 ActionBar
        new BukkitRunnable() {
            @Override
            public void run() {
                updateActionBar();
            }
        }.runTaskTimer(plugin, 0, 1); // 每秒更新一次
    }

    private static void updateActionBar() {
        String actionBarMessage = String.format("§a[%s/%s] 准备就绪", readyPlayers.size(), maxPlayers);

        // 更新每个准备的玩家的 ActionBar
        for (Player player : Bukkit.getOnlinePlayers()) {
            player.sendActionBar(actionBarMessage);
        }
    }
}
