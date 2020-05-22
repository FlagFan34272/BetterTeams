package com.booksaw.betterTeams.commands.team;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.UUID;

import com.booksaw.betterTeams.PlayerRank;
import com.booksaw.betterTeams.Team;
import com.booksaw.betterTeams.TeamPlayer;
import com.booksaw.betterTeams.commands.presets.TeamSubCommand;

/**
 * This class handles the /team disband command
 * 
 * @author booksaw
 *
 */
public class DisbandCommand extends TeamSubCommand {

	/**
	 * This HashMap is used to track all confirm messages, to ensure that the user
	 * wants to disband the team when they type the command
	 */
	HashMap<UUID, Long> confirmation = new HashMap<>();

	@Override
	public String onCommand(TeamPlayer teamPlayer, String label, String[] args, Team team) {

		if (teamPlayer.getRank() != PlayerRank.OWNER) {
			return "needOwner";
		}

		UUID found = null;
		// if they have already had the confirm dialogue
		for (Entry<UUID, Long> temp : confirmation.entrySet()) {
			if (temp.getKey().compareTo(teamPlayer.getPlayer().getUniqueId()) == 0
					&& temp.getValue() < System.currentTimeMillis() + 10000) {
				found = temp.getKey();
			}
		}

		if (found != null) {
			team.disband();
			confirmation.remove(found);
			return "disband.success";
		}

		confirmation.put(teamPlayer.getPlayer().getUniqueId(), System.currentTimeMillis());
		return "disband.confirm";

	}

	@Override
	public String getCommand() {
		return "disband";
	}

	@Override
	public int getMinimumArguments() {
		return 0;
	}
	
	@Override
	public String getNode() {
		return "disband";
	}

	@Override
	public String getHelp() {
		return "Disband your current team";
	}

	@Override
	public String getArguments() {
		return "";
	}

}
