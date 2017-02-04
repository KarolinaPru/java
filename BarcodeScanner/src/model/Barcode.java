package model;

public enum Barcode {
	
	ZERO ('0', new int[] {1, 1, 1, 2, 2, 1, 2, 1, 1}),
	ONE ('1', new int[] {2, 1, 1, 2, 1, 1, 1, 1, 2}),
	TWO ('2', new int[] {1, 1, 2, 2, 1, 1, 1, 1, 2}),
	THREE ('3', new int[] {2, 1, 2, 2, 1, 1, 1, 1, 1}),
	FOUR ('4', new int[] {1, 1, 1, 2, 2, 1, 1, 1, 2}),
	FIVE ('5', new int[] {2, 1, 1, 2, 2, 1, 1, 1, 1}),
	SIX ('6', new int[] {1, 1, 2, 2, 2, 1, 1, 1, 1}),
	SEVEN ('7', new int[] {1, 1, 1, 2, 1, 1, 2, 1, 2}),
	EIGHT ('8', new int[] {2, 1, 1, 2, 1, 1, 2, 1, 1}),
	NINE ('9', new int[] {1, 1, 2, 2, 1, 1, 2, 1, 1}),
	A ('A', new int[] {2, 1, 1, 1, 1, 2, 1, 1, 2}),
	B ('B', new int[] {1, 1, 2, 1, 1, 2, 1, 1, 2}),
	C ('C', new int[] {2, 1, 2, 1, 1, 2, 1, 1, 1}),
	D ('D', new int[] {1, 1, 1, 1, 2, 2, 1, 1, 2}),
	E ('E', new int[] {2, 1, 1, 1, 2, 2, 1, 1, 1}),
	F ('F', new int[] {1, 1, 2, 1, 2, 2, 1, 1, 1}),
	G ('G', new int[] {1, 1, 1, 1, 1, 2, 2, 1, 2}),
	H ('H', new int[] {2, 1, 1, 1, 1, 2, 2, 1, 1}),
	I ('I', new int[] {1, 1, 2, 1, 1, 2, 2, 1, 1}),
	J ('J', new int[] {1, 1, 1, 1, 2, 2, 2, 1, 1}),
	K ('K', new int[] {2, 1, 1, 1, 1, 1, 1, 2, 2}),
	L ('L', new int[] {1, 1, 2, 1, 1, 1, 1, 2, 2}),
	M ('M', new int[] {2, 1, 2, 1, 1, 1, 1, 2, 1}),
	N ('N', new int[] {1, 1, 1, 1, 2, 1, 1, 2, 2}),
	O ('O', new int[] {2, 1, 1, 1, 2, 1, 1, 2, 1}),
	P ('P', new int[] {1, 1, 2, 1, 2, 1, 1, 2, 1}),
	Q ('Q', new int[] {1, 1, 1, 1, 1, 1, 2, 2, 2}),
	R ('R', new int[] {2, 1, 1, 1, 1, 1, 2, 2, 1}),
	S ('S', new int[] {1, 1, 2, 1, 1, 1, 2, 2, 1}),
	T ('T', new int[] {1, 1, 1, 1, 2, 1, 2, 2, 1}),
	U ('U', new int[] {2, 2, 1, 1, 1, 1, 1, 1, 2}),
	V ('V', new int[] {1, 2, 2, 1, 1, 1, 1, 1, 2}),
	W ('W', new int[] {2, 2, 2, 1, 1, 1, 1, 1, 1}),
	X ('X', new int[] {1, 2, 1, 1, 2, 1, 1, 1, 2}),
	Y ('Y', new int[] {2, 2, 1, 1, 2, 1, 1, 1, 1}),
	Z ('Z', new int[] {1, 2, 2, 1, 2, 1, 1, 1, 1}),
	HYPHEN ('-', new int[] {1, 2, 1, 1, 1, 1, 2, 1, 2}),
	FULL_STOP ('.', new int[] {2, 2, 1, 1, 1, 1, 2, 1, 1}),
	SPACE (' ', new int[] {1, 2, 2, 1, 1, 1, 2, 1, 1}),
	DOLLAR ('$', new int[] {1, 2, 1, 2, 1, 2, 1, 1, 1}),
	SLASH ('/', new int[] {1, 2, 1, 2, 1, 1, 1, 2, 1}),
	PLUS ('+', new int[] {1, 2, 1, 1, 1, 2, 1, 2, 1}),
	MODULO ('%', new int[] {1, 1, 1, 2, 1, 2, 1, 2, 1}),
	ASTERISK ('*', new int[] {1, 2, 1, 1, 2, 1, 2, 1, 1});
	
	private int[] barsWidth;
	private char symbol;
	
	private Barcode(char symbol, int[] barsWidth) {
		this.symbol = symbol;
		this.barsWidth = barsWidth;
	}
	
	public char getSymbol() {
		return symbol;
	}

	public int[] getBarsWidth() {
		return barsWidth;
	}
}
