package model;

import java.util.ArrayList;

public class LetterCounter {
    private ArrayList<String> countedLetters;
    private char lastChar;
    private int lastLetterCount;

    public ArrayList<String> countLettersToList(String inputText) {
        countedLetters = new ArrayList<>();

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

        return countedLetters;
    }

    private void addLastLetterWithNumberOfOccurrences() {
        if (lastLetterCount > 1) {

            countedLetters.add(lastChar + Integer.toString(lastLetterCount));

        } else {

            countedLetters.add(lastChar + "1");
        }
    }
}
