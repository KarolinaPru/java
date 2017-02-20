package model;

import java.util.ArrayList;

public class BarcodeConversionController {
	
public String convert(String colors) {
		LetterCounter lc = new LetterCounter();
		ArrayList<String> countedColors = lc.countLettersToList(colors);
		
		ColorGrouper cg = new ColorGrouper();
		ArrayList<ArrayList<String>> groupedColors = cg.groupColors(countedColors);

		ColorsToBarsTranslator ctbt = new ColorsToBarsTranslator();
		ArrayList<ArrayList<Integer>> groupedBars = ctbt.translate(groupedColors);
		
		BarsToCodesTranslator btct = new BarsToCodesTranslator();
		ArrayList<Integer> codes = btct.translate(groupedBars);

		return decode(codes);
	}

	private String decode(ArrayList<Integer> codes) {
		Barcode br = new Barcode();
		
		StringBuilder sb = new StringBuilder();
		
		for(int code : codes ){
			String letter = br.getLetterForCode(code);
			sb.append(letter);
		}
		
		return sb.toString();
	}
}
