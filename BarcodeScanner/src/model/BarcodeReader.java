package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BarcodeReader {
	private ArrayList<String> barsList;

	private String inputText;
	private int lastLetterCount;
	private char lastChar;
	private Map<Integer, ArrayList<String>> barsMap;

	public void determineBarsInBarcode(String input) {
		inputText = input;
		barsList = prepareListOfBarsWithWidth(inputText);
		divideIntoSeparateArrays(barsList);

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

		for (int i = 1; i < 10; i++) {

			array1.add(barsList.get(i));
		}

		for (int i = 11; i < 20; i++) {

			array2.add(barsList.get(i));
		}

		for (int i = 21; i < 30; i++) {

			array3.add(barsList.get(i));
		}
		for (int i = 31; i < 40; i++) {

			array4.add(barsList.get(i));
		}

		for (int i = 41; i < 50; i++) {

			array5.add(barsList.get(i));
		}

		for (int i = 51; i < 60; i++) {

			array6.add(barsList.get(i));
		}
		for (int i = 61; i < 70; i++) {

			array7.add(barsList.get(i));
		}

		for (int i = 71; i < 80; i++) {

			array8.add(barsList.get(i));
		}

		for (int i = 81; i < 90; i++) {

			array9.add(barsList.get(i));
		}
		
		for (int i = 91; i < 100; i++) {

			array10.add(barsList.get(i));
		}

		for (int i = 101; i < 110; i++) {

			array11.add(barsList.get(i));
		}

		barsMap.put(1, array1);
		barsMap.put(2, array2);
		barsMap.put(3, array3);
		barsMap.put(4, array4);
		barsMap.put(5, array5);
		barsMap.put(6, array6);
		barsMap.put(7, array7);
		barsMap.put(8, array8);
		barsMap.put(9, array9);
		barsMap.put(10, array10);
		barsMap.put(11, array11);

		System.out.println(barsMap.values());

		return barsMap;
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

}
