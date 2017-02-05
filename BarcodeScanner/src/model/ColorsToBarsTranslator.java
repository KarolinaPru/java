package model;

import java.util.ArrayList;
import java.util.Collections;

//in -> [[w3, b1, w1, b3, ... ], [...], [...], ...]
//out -> [[2, 1, 1, 2, ...], [...], [...], ...]
public class ColorsToBarsTranslator {

	private ArrayList<Integer> barsWidthAsList;
	private ArrayList<Integer> translatedValues;
	
	private ArrayList<ArrayList<String>> groupedColors;
	private ArrayList<ArrayList<Integer>> groupedBars;

	public ArrayList<ArrayList<Integer>> translate(ArrayList<ArrayList<String>> groupedColors) {
		this.groupedColors = groupedColors;
		
		parseStringValuesIntoInts();

		return groupedBars;
	}

	private void parseStringValuesIntoInts() {

		groupedBars = new ArrayList<>();
		
		for (int i = 0; i < groupedColors.size(); i++) {
			int barWidth;
			barsWidthAsList = new ArrayList<>();

			for (int j = 0; j < groupedColors.get(i).size(); j++) {

				String color = groupedColors.get(i).get(j);
				String sBarWidth = color.substring(1);
				barWidth = Integer.parseInt(sBarWidth);
				barsWidthAsList.add(barWidth);
			}
			replaceValuesWith1sAnd2sAccordingly();
			groupedBars.add(translatedValues);
		}
	}

	private void replaceValuesWith1sAnd2sAccordingly() {

		int max = Collections.max(barsWidthAsList);
		translatedValues = new ArrayList<>();

		for (int k = 0; k < barsWidthAsList.size(); k++) {
			if (barsWidthAsList.get(k) == max) {
				translatedValues.add(2);
			} else {
				translatedValues.add(1);
			}
		}
	}
	
		
}
