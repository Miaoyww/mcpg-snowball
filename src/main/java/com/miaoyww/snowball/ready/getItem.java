package com.miaoyww.snowball.ready;

import com.miaoyww.snowball.Listener;
import com.miaoyww.snowball.TeamManager;
import com.miaoyww.snowball.commands.executors.getItemCommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;


public final class getItem extends JavaPlugin {
    @Override
    public void onEnable() {
        this.getCommand("ready").setExecutor(new getItemCommandExecutor());
        getServer().getPluginManager().registerEvents(new Listener(), this);
        TeamManager.setPlugin(this);
        TeamManager.startActionBarUpdater();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    // 添加玩家到已准备的队伍
}
