package com.lowleveldesign.tictactoe;

import java.util.ArrayList;
import java.util.List;

import com.lowleveldesign.tictactoe.Pair;

public class GameBoard {
	// What game board will have is the size and Playing Piece
	private int size;
	private PlayingPiece piece[][];
	// GameBoard has a relation of PlayingPiece
	GameBoard(int size){
		this.size = size;
		this.piece = new PlayingPiece[size][size];
	}
	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}
	/**
	 * @param size the size to set
	 */
	public void setSize(int size) {
		this.size = size;
	}
	/**
	 * @return the piece
	 */
	public PlayingPiece[][] getPiece() {
		return piece;
	}
	/**
	 * @param piece the piece to set
	 */
	public void setPiece(PlayingPiece[][] piece) {
		this.piece = piece;
	}
	public void displayBoard() {
		for(int row = 0; row<piece.length;row++) {
			for(int col = 0; col<piece[0].length;col++) {
				if(piece[row][col]!=null)
				System.out.print(piece[row][col].piecetype + " | ");
				else
				System.out.print(piece[row][col]+ " | ");

			}
			System.out.println();
			
		}
	}
	public List<Pair> getavailableCells() {
		// TODO Auto-generated method stub
		List<Pair> currentList = new ArrayList<>();
		Game game = new Game();
		for(int row = 0; row<piece.length;row++) {
			for(int col = 0; col<piece[0].length;col++) {
				if(piece[row][col]==null)
					currentList.add(new Pair(row,col));
			}
	   }
		return currentList;
	}
   
}
