package com.miaoyww.snowball.commands.subCommands;

import com.miaoyww.snowball.Snowball;
import com.miaoyww.snowball.commands.SubCommand;
import com.miaoyww.snowball.snowball.GameSession;
import com.miaoyww.snowball.snowball.teams.ITeam;
import com.miaoyww.snowball.snowball.teams.TeamGenshin;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class TeamCommand extends SubCommand {
    @Override
    public String getName() {
        return "team";
    }

    @Override
    public String getDescription() {
        return "队伍有关指令";
    }

    @Override
    public String getSyntax() {
        return "";
    }

    @Override
    public void perform(Player player, String[] args) {
//        ArrayList<ITeam> teams = new ArrayList<>();
//        ITeam team = new TeamGenshin();
//        team.addPlayer(player);
//        teams.add(team);
//        
//        Snowball.Sessions.add(new GameSession(teams));
        player.setDisplayName("§6[Genshin]");
    }
}
