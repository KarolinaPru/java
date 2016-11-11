package com.karolina;

public class EntryPoint {

	public static void main(String[] args) {
		playGame1();
	}

	private static void playGame1() {
		Game ticTacToe = new Game();
		
		ticTacToe.move(0, 0); //x
		ticTacToe.move(0, 1); //o
		ticTacToe.move(1, 0); //x
		ticTacToe.move(1, 1); //o
		ticTacToe.move(2, 0); //x
		// x should win (first row crossed)
	}

}
