package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Collections;

public class BarcodeReader {

	private String inputText;
	private int lastLetterCount;
	private char lastChar;

	private ArrayList<String> barsList;
	private ArrayList<Integer> values;
	private ArrayList<Integer> translatedValues;

	private Map<Integer, ArrayList<String>> barsMap;
	private Map<Integer, Integer> barsWidthMap;
	private ArrayList<Integer> valuesList;


	public void determineBarsInBarcode(String input) {
		inputText = input;
		barsList = prepareListOfBarsWithWidth(inputText);
		barsMap = divideIntoSeparateArrays(barsList);
		translatedValues = addValuesToList(barsMap);
		
	

	}

	public ArrayList<String> prepareListOfBarsWithWidth(String input) {
		barsList = new ArrayList<String>();

		inputText = input;
		lastChar = inputText.charAt(0);
		lastLetterCount = 1;

		for (int i = 1; i < inputText.length(); i++) {
			char currentChar = inputText.charAt(i);

			if (currentChar == lastChar) {
				lastLetterCount++;
			} else {
				addLastLetterWithNumberOfOccurrences();
				lastLetterCount = 1;
				lastChar = currentChar;
			}
		}
		addLastLetterWithNumberOfOccurrences();
		return barsList;
	}

	private void addLastLetterWithNumberOfOccurrences() {
		if (lastLetterCount > 1) {

			barsList.add(lastChar + Integer.toString(lastLetterCount));

		} else {

			barsList.add(lastChar + "1");
		}
	}

	private ArrayList<Integer> addValuesToList(Map<Integer, ArrayList<String>> barsMap){

		parseStringValuesIntoInts(barsMap);
		replaceValuesWith1sAnd2sAccordingly();

		for (int i : translatedValues)
		{
			System.out.println(i);
		}

		return translatedValues;	
	}

	private void parseStringValuesIntoInts(Map<Integer, ArrayList<String>> barsMap) {

		for (int i = 0; i < barsMap.size(); i++) {
			{
				int value;
				values = new ArrayList<>();

				for (int j = 0; j <barsMap.get(i).size(); j++) {

					String s = barsMap.get(i).get(j);
					String sWidth = s.substring(1);
					value = Integer.parseInt(sWidth);
					values.add(value);		

				}
			}			
		}
	}

	private void replaceValuesWith1sAnd2sAccordingly() {
		int max = Collections.max(values);
		translatedValues = new ArrayList<>();

		for (int k = 0; k < values.size(); k++)
		{

			if (values.get(k) == max) {
				translatedValues.add(2);
			}
			else {
				translatedValues.add(1);
			}
		}
	}

	public Map<Integer, ArrayList<String>> divideIntoSeparateArrays(ArrayList<String> barsList) {
		barsList = prepareListOfBarsWithWidth(inputText);

		barsMap = new HashMap<>();

		ArrayList<String> array1 = new ArrayList<>();
		ArrayList<String> array2 = new ArrayList<>();
		ArrayList<String> array3 = new ArrayList<>();
		ArrayList<String> array4 = new ArrayList<>();
		ArrayList<String> array5 = new ArrayList<>();
		ArrayList<String> array6 = new ArrayList<>();
		ArrayList<String> array7 = new ArrayList<>();
		ArrayList<String> array8 = new ArrayList<>();
		ArrayList<String> array9 = new ArrayList<>();
		ArrayList<String> array10 = new ArrayList<>();
		ArrayList<String> array11 = new ArrayList<>();

		addListToMap(barsList, array1, 10);
		addListToMap(barsList, array2, 20);
		addListToMap(barsList, array3, 30);
		addListToMap(barsList, array4, 40);
		addListToMap(barsList, array5, 50);
		addListToMap(barsList, array6, 60);
		addListToMap(barsList, array7, 70);
		addListToMap(barsList, array8, 80);
		addListToMap(barsList, array9, 90);
		addListToMap(barsList, array10, 100);
		addListToMap(barsList, array11, 110);

		barsMap.put(0, array1);
		barsMap.put(1, array2);
		barsMap.put(2, array3);
		barsMap.put(3, array4);
		barsMap.put(4, array5);
		barsMap.put(5, array6);
		barsMap.put(6, array7);
		barsMap.put(7, array8);
		barsMap.put(8, array9);
		barsMap.put(9, array10);
		barsMap.put(10, array11);	

		System.out.println(barsMap.values());
		return barsMap;
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



			//	String s = sb.toString();
			//	barcodeAsNumber = Integer.parseInt(s);
			//	barsWidthMap.put(i, barcodeAsNumber);
		}

		System.out.println(barsWidthMap.values());
		return barsWidthMap;
	}


	private void addListToMap(ArrayList<String> barsList, ArrayList<String> array, int range) {

		boolean isRangeWithinBounds = range < barsList.size();

		if (isRangeWithinBounds) {

			for (int i = (range-9); i < range; i++) {

				array.add(barsList.get(i));
			}
		}
	}



}
