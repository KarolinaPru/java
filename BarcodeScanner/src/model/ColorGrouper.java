package model;

import java.util.ArrayList;

//in -> [w3, b1, w1, b3, ...]
//out -> [[w3, b1, w1, b3, ... ], [...], [...], ...]
public class ColorGrouper {
	private ArrayList<ArrayList<String>> groupedColors;
	private ArrayList<String> countedColors;
	
	public ArrayList<ArrayList<String>> groupColors(ArrayList<String> countedColors) {
		this.countedColors = countedColors;
		groupedColors = new ArrayList<>();

		int numberOfLetters = ((countedColors.size() - 1) / 10);
		
		int letterRange = 10;
		for (int i = 0; i < numberOfLetters; i++) {
			addLetterGroupToGroupedColors(letterRange);
			letterRange += 10;
		}
		
		return groupedColors;
	}

	private void addLetterGroupToGroupedColors(int letterRange) {

		ArrayList<String> group = new ArrayList<>();

		if (isGroupRangeWithinBounds(letterRange)) {

			for (int i = (letterRange - 9); i < letterRange; i++) {

				group.add(countedColors.get(i));
			}
		}
		groupedColors.add(group);
	}

	private boolean isGroupRangeWithinBounds(int range) {
		return range < countedColors.size();
	}
}
