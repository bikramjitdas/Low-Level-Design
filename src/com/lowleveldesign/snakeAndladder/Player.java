package com.lowleveldesign.snakeAndladder;

public class Player {
	public Player(String playerName, int currentPos) {
		this.playerName = playerName;
		this.currentPos = currentPos;
	}
	private String playerName;
	private int currentPos;
	/**
	 * @return the playerName
	 */
	public String getPlayerName() {
		return playerName;
	}
	/**
	 * @param playerName the playerName to set
	 */
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	/**
	 * @return the currentPos
	 */
	public int getCurrentPos() {
		return currentPos;
	}
	/**
	 * @param currentPos the currentPos to set
	 */
	public void setCurrentPos(int currentPos) {
		this.currentPos = currentPos;
	}

}
