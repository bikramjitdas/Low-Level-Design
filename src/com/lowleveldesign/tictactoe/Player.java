package com.lowleveldesign.tictactoe;

public class Player {
		public String playerName;
		public int wins;
		public int lost;
		public PlayingPiece pieceAlloted;
		public Player(String playerName, PlayingPiece pieceAlloted) {
			this.playerName = playerName;
			this.pieceAlloted = pieceAlloted;
		}
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
		 * @return the wins
		 */
		public int getWins() {
			return wins;
		}
		/**
		 * @param wins the wins to set
		 */
		public void setWins(int wins) {
			this.wins = wins;
		}
		/**
		 * @return the lost
		 */
		public int getLost() {
			return lost;
		}
		/**
		 * @param lost the lost to set
		 */
		public void setLost(int lost) {
			this.lost = lost;
		}
		/**
		 * @return the pieceAlloted
		 */
		public PlayingPiece getPieceAlloted() {
			return pieceAlloted;
		}
		/**
		 * @param pieceAlloted the pieceAlloted to set
		 */
		public void setPieceAlloted(PlayingPiece pieceAlloted) {
			this.pieceAlloted = pieceAlloted;
		}
		
		
}
