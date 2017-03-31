package com.karolina;

public class Game {
	private boolean won;
	private boolean isCrossTurn;
	private int[][] state;
	
	public Game() {
		reset();
	}
	
	public void reset (){
		state = new int[3][3];
		isCrossTurn = true;
		won = false;
	}

	public void move(int x, int y) throws GameFinishedException {
		if(won){
			throw new GameFinishedException();
		}
		
		if(isCrossTurn) {
			state[x][y] = 10;
		} else {
			state[x][y] = 1;
		}
		checkIfWins();
		isCrossTurn = !isCrossTurn;
	}
	
	private void checkIfWins() {
		checkIfRowWins(0);
		checkIfRowWins(1);
		checkIfRowWins(2);
		
		checkIfColumnWins(0);
		checkIfColumnWins(1);
		checkIfColumnWins(2);

		checkIfLeftDiagonalWins();
		checkIfRightDiagonalWins();
	}

	private void checkIfRightDiagonalWins() {
		int sum = 0;
		sum = state[2][0] + state[1][1] + state[0][2];
		won = isWinningSum(sum);
	}

	private void checkIfLeftDiagonalWins() {
		int sum = 0;
		sum = state[0][0] + state[1][1] + state[2][2];
		won = isWinningSum(sum);
	}

	private void checkIfColumnWins(int columnNumber) {
		int sum = 0;
		for (int y = 0; y < 3; y++){
			sum += state[columnNumber][y];
		}
		won = isWinningSum(sum);
	}

	private void checkIfRowWins(int rowNumber) {
		int sum = 0;
		for (int x = 0; x < 3; x++){
			sum += state[x][rowNumber];
		}
		won = isWinningSum(sum);
	}

	private boolean isWinningSum(int sum) {
		if (sum == 3 || sum == 30) {
			return true;
		}
		return false;
	}
}
