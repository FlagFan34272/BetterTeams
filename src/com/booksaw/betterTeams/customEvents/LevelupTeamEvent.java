package com.booksaw.betterTeams.customEvents;

import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;

import com.booksaw.betterTeams.Team;

public class LevelupTeamEvent extends TeamEvent {

	private static final HandlerList HANDLERS = new HandlerList();

	@Override
	public HandlerList getHandlers() {
		return HANDLERS;
	}

	public static HandlerList getHandlerList() {
		return HANDLERS;
	}

	private final int currentLevel;
	private final int newLevel;
	private final int cost;
	private final boolean score;
	private final Player commandSender;

	public LevelupTeamEvent(Team team, int currentLevel, int newLevel, int cost, boolean score, Player commandSender) {
		super(team);
		this.currentLevel = currentLevel;
		this.newLevel = newLevel;
		this.cost = cost;
		this.score = score;
		this.commandSender = commandSender;
	}

	public int getCurrentLevel() {
		return currentLevel;
	}

	public int getNewLevel() {
		return newLevel;
	}

	public int getCost() {
		return cost;
	}

	public boolean isScore() {
		return score;
	}

	public Player getCommandSender() {
		return commandSender;
	}

}
