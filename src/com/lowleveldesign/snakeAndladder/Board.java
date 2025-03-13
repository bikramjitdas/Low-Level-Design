package com.lowleveldesign.snakeAndladder;

import java.util.Random;

public class Board {
	private int size;
	private Cells cell[][];
	private int snakes;
	private int ladders;
	
	public Board(int size, int snakes, int ladders) {
		this.size = size;
		this.snakes = snakes;
		this.ladders = ladders;
		this.initializeCells(size,snakes,ladders);
	}
	// initialize the cells from 1 to Size - 1
	// [6,5,4] -- 0
	// [1,2,3] -- 1
	public void initializeCells(int size, int snakes, int ladders) {
		cell = new Cells[size][size];
		for(int i = 0; i<size; i++) {
			for(int j = 0; j<size; j++) {
				Cells eachCell = new Cells();
				cell[i][j] = eachCell;
			}
		}
		addSnakesAndLadders(cell,snakes, ladders,size);
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
	 * @return the cell
	 */
	public Cells[][] getCell() {
		return cell;
	}
	/**
	 * @param cell the cell to set
	 */
	public void setCell(Cells[][] cell) {
		this.cell = cell;
	}
	/**
	 * @return the snakes
	 */
	public int getSnakes() {
		return snakes;
	}
	/**
	 * @param snakes the snakes to set
	 */
	public void setSnakes(int snakes) {
		this.snakes = snakes;
	}
	/**
	 * @return the ladders
	 */
	public int getLadders() {
		return ladders;
	}
	/**
	 * @param ladders the ladders to set
	 */
	public void setLadders(int ladders) {
		this.ladders = ladders;
	}
	// fill the board with snakes and ladders
	public void addSnakesAndLadders(Cells cell[][],int snakes, int ladders,int size) {
		int lowerbound = 1, upperbound = (size*size)-1;
		Random rand = new Random();
		while(snakes>0) {
		
			int snakeHead = rand.nextInt(upperbound-lowerbound)+1;
			int snakeTail = rand.nextInt(upperbound-lowerbound)+1;
			if(snakeHead<=snakeTail)continue;
			System.out.println("Snake Head" + snakeHead + " snake Tail  " + snakeTail);
			
			Jump jumpObj = new Jump();
			jumpObj.setStartpos(snakeHead);
			jumpObj.setEndpos(snakeTail);
			
			Cells currentcell= getCell(snakeHead);
			currentcell.setJump(jumpObj);
			snakes--;
		}
		
		while(ladders>0) {
			int ladderStart = rand.nextInt(upperbound-lowerbound)+1;
			int ladderEnd = rand.nextInt(upperbound-lowerbound)+1;
			if(ladderStart>=ladderEnd	)continue; // 59,52
			System.out.println("Ladder Start " + ladderStart + "Ladder End  " + ladderEnd);
			Jump jumpObj = new Jump();
			jumpObj.setStartpos(ladderStart);
			jumpObj.setEndpos(ladderEnd);
			
			Cells currentcell= getCell(ladderStart);
			currentcell.setJump(jumpObj);
			ladders--;
		}
		
	}
	
	public Cells getCell(int position) {
		// 2/3 = 
		int boardrow = position/size;
		int boardcol = position%size;
		return cell[boardrow][boardcol];
	}
}
