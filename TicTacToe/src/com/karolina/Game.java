package com.karolina;

public class Game {
	private boolean isCrossTurn;
	private int[][] state;
	
	public Game() {
		reset();
		
	}
	
	public void reset (){
		state = new int[3][3];
		isCrossTurn = true;
	}

	public void move(int x, int y) {
		if(isCrossTurn) {
			state[x][y] = 10;
		} else {
			state[x][y] = 1;
		}
		isCrossTurn = !isCrossTurn;
	}
}
