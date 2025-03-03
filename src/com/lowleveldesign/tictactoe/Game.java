package com.lowleveldesign.tictactoe;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Game {
	
	Deque<Player> players;
	GameBoard board;
	public int size;
	
	public void initGame(){
		// Create two players A and B-> assign A to X and B to O
		players = new LinkedList<>();
		PlayingPieceO opiece = new PlayingPieceO();
		PlayingPieceX xpiece = new PlayingPieceX();
		players.add(new Player("A",xpiece));
		players.add(new Player("B",opiece));
		size = 3;
		//initialize the Board;
		GameBoard board = new GameBoard(3);
		this.board = board;

	}
	public PlayingPiece [][] addCell(Integer playerRow, Integer playerCol, PlayingPiece playingPiece) {
		PlayingPiece [][]currentBoard = board.getPiece();
		currentBoard[playerRow][playerCol] = playingPiece;
		board.setPiece(currentBoard);
		return currentBoard;
	}
	public boolean checkWinner(PlayingPiece[][] currentBoard,Integer playerRow,Integer playerCol,PlayingPiece playingPiece) {
		
		
		Integer rowCount = currentBoard.length;
		Integer colCount = currentBoard[0].length;
		//check if the cols are already filled!
		boolean winnerFound = false;
		for(int row = 0; row<=rowCount;row++) {
			if(row==rowCount) {
				winnerFound = true;
				break;
			}
			if(currentBoard[row][playerCol]!=playingPiece) {
				winnerFound = false;
				break;
			}
		}
		//check if the diagonals are filled!
		if(winnerFound) return winnerFound;
		for(int row = 0; row<=rowCount;row++) {
			if(row==rowCount) {
				winnerFound = true;
				break;
			}
			if(currentBoard[row][row]!=playingPiece) {
				winnerFound = false;
				break;
			}
		}
		if(winnerFound) return winnerFound;
		//check if the row are filled !
		for(int col = 0; col<=colCount;col++) {
			if(col==colCount) {
				winnerFound = true;
				break;
			}
			if(currentBoard[playerRow][col]!=playingPiece) {
				winnerFound = false;
				break;
			}
		}
		return winnerFound;
	}
	public boolean checkWinnerAndaddCell(Integer playerRow, Integer playerCol, PlayingPiece playingPiece) {
		PlayingPiece [][]currentBoard = addCell(playerRow,playerCol,playingPiece);
		return checkWinner(currentBoard,playerRow,playerCol,playingPiece);	
	}
	
	public void start() {
		
		initGame();
		// Run inside a loop until there is no space left or we have a clear winner!
		// Take the Input from the Player, get the player
		
		System.out.println("Game Started !");
		boolean winnerfound = false;
		while(!winnerfound) {
		// check if there exists a freecell
		Player currentPlayer = players.poll();
		List<Pair> availableCells = board.getavailableCells();
		
		if(availableCells.size()==0) {
			System.out.println(" Match tied !");
			return;
		}
		
		// Take the input from the player until and unless he provides a legitimate input
		// 
		boolean foundrowCol = false;
		Integer playerRow = -1,playerCol = -1;
		while(!foundrowCol) {
		System.out.println(" Player " + currentPlayer.getPlayerName() + " Please provide the Piece Location(row,col) !");
        Scanner scn = new Scanner(System.in);
        String symbols = scn.nextLine();
        String eachSymbol[] = symbols.split(",");
         playerRow = Integer.parseInt(eachSymbol[0]);
         playerCol = Integer.parseInt(eachSymbol[1]);
        
//        //Check if the user has provided the correct input
//        for(PieceType currPiece:PieceType.values()) {
//        	if(currPiece.equals(symbols))
//        		correctPiece = true;
//         }
//        System.out.println(" Oho ! you provided a wrong input piece!  Please retry !");
//	   } // Not required, just get the row col;
        
        // Check if the row and col by player exists !
        
        for(Pair rowCol: availableCells) {
        	Integer row = rowCol.getRow();
        	Integer col = rowCol.getCol();
        	if(row== playerRow && col==playerCol) {
        		foundrowCol = true;
        		break;
        	}
        }
        if(!foundrowCol) {
        	System.out.println(" Oho ! you provided a location which is already filled!!  Please retry !");
        }
		}
		
		if(checkWinnerAndaddCell(playerRow,playerCol, currentPlayer.getPieceAlloted())) {
			System.out.println("Congrats! You have won Player" + currentPlayer.getPlayerName());
			// logic to improve the analytics section can be added here!
			winnerfound = true;
		}
		 board.displayBoard();
		 players.addLast(currentPlayer);
		}
		 
	}

}
