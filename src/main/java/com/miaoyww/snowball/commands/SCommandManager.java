package com.miaoyww.snowball.commands;

import com.miaoyww.snowball.commands.subCommands.CreateCommand;
import com.miaoyww.snowball.commands.subCommands.HelpCommand;
import com.miaoyww.snowball.commands.subCommands.TeamCommand;
import com.sun.org.apache.bcel.internal.util.Args;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class SCommandManager implements CommandExecutor {
    public ArrayList<SubCommand> subCommands = new ArrayList<>();

    public SubCommand getCommand(String name) {
        for (SubCommand command : this.subCommands) {
            if (command.getName().equalsIgnoreCase(name)) {
                return command;
            }
        }
        return null;
    }

    public SCommandManager() {
        this.subCommands.add(new HelpCommand());
        this.subCommands.add(new CreateCommand());
        this.subCommands.add(new TeamCommand());
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (commandSender instanceof Player) {
            if (args.length == 0) {
                getCommand("help").perform((Player) commandSender, args);
                return true;
            }else {
                if (getCommand(args[0]) == null) {
                    commandSender.sendMessage("Invalid subcommand");
                    return true;
                }
                getCommand(args[0]).perform((Player) commandSender, args);
                return true;
            }
        }
        return true;
    }
}
