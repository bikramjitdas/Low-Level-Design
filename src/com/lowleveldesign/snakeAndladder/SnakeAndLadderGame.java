package com.lowleveldesign.snakeAndladder;
import java.util.*;
public class SnakeAndLadderGame {
	
		private Board board;
		private Deque<Player> players = new LinkedList<>();
		private Dice dice;
		private Player currentPlayer;
		private boolean playerwins = false;
		private int boardLimit;
	
		public void initGame() {
			board = new Board(10,5,5);
			dice = new Dice(1);
			boardLimit = (board.getSize()*board.getSize())-1;
			addPlayer();
		}
		public void addPlayer() {
			Player playerA = new Player("Player-A",0);
			Player playerB = new Player("Player-B",0);
			players.add(playerA);
			players.add(playerB);
		}
		public void startTheGame() {
			initGame();
			
			while(!playerwins) {
				currentPlayer = players.poll();
				System.out.println("Rolling Dice for : " + currentPlayer.getPlayerName());
				int playerCurrentPos = currentPlayer.getCurrentPos();
				int newPos = dice.rollDice();
				int playerPos = playerCurrentPos+newPos;
				System.out.println(currentPlayer.getPlayerName()+ " has got the value " + newPos + "  new Pos : " + playerPos );
				if(playerPos>=boardLimit) {
					playerwins= true;
					System.out.println("Player : " + currentPlayer.getPlayerName() + " has won !!");
					break;
				}
				Cells playerPosCell = board.getCell(playerPos);
				
				if(playerPosCell.getJump()!=null && playerPos==playerPosCell.getJump().getStartpos()) {
					int jumpPos = playerPosCell.getJump().getEndpos();
					String message = playerPos<jumpPos?"has stepped up the ladder" : " has been bitten by snake !";
					System.out.println(" Player Pos Has been changed from : " + playerPos + " to :" + jumpPos + message);
					playerPos = jumpPos;
				}
				currentPlayer.setCurrentPos(playerPos);
				players.addLast(currentPlayer);
			}
		}
	
}
