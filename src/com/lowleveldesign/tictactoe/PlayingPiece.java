package com.lowleveldesign.tictactoe;

public class PlayingPiece {

	public PieceType piecetype;
	
	PlayingPiece(PieceType piecetype){
		this.piecetype = piecetype;
	}
}

// This class is injecting the pieceType Enum --> in the constructor injection
// This class has two child classes, PlayingPieceX and PlayingPieceY. 
// 