package com.miaoyww.snowball.commands.subCommands;

import com.miaoyww.snowball.commands.SubCommand;
import org.bukkit.entity.Player;

public class CreateCommand extends SubCommand {
    @Override
    public String getName() {
        return "create";
    }

    @Override
    public String getDescription() {
        return "创建一个新的游戏";
    }

    @Override
    public String getSyntax() {
        return "";
    }

    @Override
    public void perform(Player player, String[] args) {
        player.sendMessage("Create command");
    }
}
