package com.miaoyww.snowball.snowball.teams;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.ScoreboardManager;

import java.util.ArrayList;

public abstract class ITeam {
    public abstract String getName();
    
    public abstract String getDisplayName();

    Location spawn;
    int score;
    ArrayList<Player> players;

    public ITeam() {
        players = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void removePlayer(Player player) {
        players.remove(player);
    }

    public void addScore(int score) {
        this.score = score;
    }

    public void setSpawn(Location spawn) {
        this.spawn = spawn;
    }
}
