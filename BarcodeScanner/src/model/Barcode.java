package model;

import java.util.HashMap;
import java.util.Map;

public class Barcode {
	private Map<Integer, String> codes;
	
	public Barcode(){
		codes = new HashMap<>();
		codes.put(111221211, "0");
		codes.put(211211112, "1");
		codes.put(112211112, "2");
		codes.put(212211111, "3");
		codes.put(111221112, "4");
		codes.put(211221111, "5");
		codes.put(112221111, "6");
		codes.put(111211212, "7");
		codes.put(211211211, "8");
		codes.put(112211211, "9");
		codes.put(211112112, "A");
		codes.put(112112112, "B");
		codes.put(212112111, "C");
		codes.put(111122112, "D");
		codes.put(211122111, "E");
		codes.put(112122111, "F");
		codes.put(111112212, "G");
		codes.put(211112211, "H");
		codes.put(112112211, "I");
		codes.put(111122211, "J");
		codes.put(211111122, "K");
		codes.put(112111122, "L");
		codes.put(212111121, "M");
		codes.put(111121122, "N");
		codes.put(211121121, "O");
		codes.put(112121121, "P");
		codes.put(111111222, "Q");
		codes.put(211111221, "R");
		codes.put(112111221, "S");
		codes.put(111121221, "T");
		codes.put(221111112, "U");
		codes.put(122111112, "V");
		codes.put(222111111, "W");
		codes.put(121121112, "X");
		codes.put(221121111, "Y");
		codes.put(122121111, "Z");
		codes.put(121111212, "-");
		codes.put(221111211, ".");
		codes.put(122111211, " ");
		codes.put(121212111, "$");
		codes.put(121211121, "/");
		codes.put(121112121, "+");
		codes.put(111212121, "%");
		codes.put(121121211, "*");

	}
	
	public String getLetterForCode(int code) {
		return codes.get(code);
	}
}
