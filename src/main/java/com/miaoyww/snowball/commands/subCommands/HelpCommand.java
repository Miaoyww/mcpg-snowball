package com.miaoyww.snowball.commands.subCommands;

import com.miaoyww.snowball.commands.SubCommand;
import org.bukkit.entity.Player;

public class HelpCommand extends SubCommand {
    @Override
    public String getName() {
        return "help";
    }

    @Override
    public String getDescription() {
        return "帮助";
    }

    @Override
    public String getSyntax() {
        return "";
    }

    @Override
    public void perform(Player player, String[] args) {
        player.sendMessage("help!");
    }
}
