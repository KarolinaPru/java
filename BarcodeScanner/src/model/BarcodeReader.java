package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Collections;

public class BarcodeReader {
	private ArrayList<String> countedColors;

	private ArrayList<Integer> barsWidthAsList;
	private ArrayList<Integer> translatedValues;

	private Map<Integer, Integer> barsWidthMap;
	private ArrayList<Integer> valuesList;
	private ArrayList<ArrayList<String>> groupedColors;

	private ArrayList<ArrayList<Integer>> barsWidthGrouped;

	public String decodeBarcode(String colors) {
		countColors(colors);
		groupColors();
		addValuesToList();

		return "Under construction";
	}

	private void countColors(String colors) {
		LetterCounter lc = new LetterCounter();
		countedColors = lc.countLettersToList(colors);
	}

	private void groupColors() {
		groupedColors = new ArrayList<>();

		int groupRange = 10;
		for (int j = 0; j <= 10; j++) {
			addGroupToGroupedColors(groupRange);
			groupRange += 10;
		}

		for (ArrayList<String> a : groupedColors) {

			System.out.println(a);
		}
	}

	private void addGroupToGroupedColors(int groupRange) {

		ArrayList<String> group = new ArrayList<>();

		if (isGroupRangeWithinBounds(groupRange)) {

			for (int i = (groupRange - 9); i < groupRange; i++) {

				group.add(countedColors.get(i));
			}
		}
		groupedColors.add(group);
	}

	private boolean isGroupRangeWithinBounds(int range) {
		return range < countedColors.size();
	}

	private void addValuesToList() {
		parseStringValuesIntoInts();

		for (ArrayList<Integer> a : barsWidthGrouped) {
			System.out.println(a);
		}
	}

	private void parseStringValuesIntoInts() {

		barsWidthGrouped = new ArrayList<>();
		
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
			barsWidthGrouped.add(translatedValues);
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

	private Map<Integer, Integer> translateBarMapIntoIntegers(Map<Integer, ArrayList<String>> barsMap) {

		barsWidthMap = new HashMap<>();

		for (int i = 0; i < barsMap.size(); i++) {

			StringBuffer sb = new StringBuffer();

			int value;
			int barcodeAsNumber = 0;

			ArrayList<Integer> values = new ArrayList<>();

			for (int j = 0; j < barsMap.get(i).size(); j++) {

				String s = barsMap.get(i).get(j);
				String sWidth = s.substring(1);
				value = Integer.parseInt(sWidth);
				values.add(value);
			}

			// String s = sb.toString();
			// barcodeAsNumber = Integer.parseInt(s);
			// barsWidthMap.put(i, barcodeAsNumber);
		}

		System.out.println(barsWidthMap.values());
		return barsWidthMap;
	}
}
