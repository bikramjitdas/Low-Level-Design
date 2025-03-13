package com.lowleveldesign.snakeAndladder;

import java.util.Random;

public class Dice {
	private int diceCount;
	
	Random rand;
	
	public Dice(int diceCount) {
		this.diceCount = diceCount;
		rand = new Random();
	}



	public int rollDice() {
		int lowerLimit = 1, upperLimit = diceCount*6;
		return rand.nextInt(upperLimit-lowerLimit)+lowerLimit;
	
	}
}
