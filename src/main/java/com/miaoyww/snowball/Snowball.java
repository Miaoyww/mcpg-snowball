package com.miaoyww.snowball;

import com.miaoyww.snowball.commands.SCommandManager;
import com.miaoyww.snowball.snowball.GameSession;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public final class Snowball extends JavaPlugin {
    public static ArrayList<GameSession> Sessions;

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getCommand("snowball").setExecutor(new SCommandManager());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
