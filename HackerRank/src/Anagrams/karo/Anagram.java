package Anagrams.karo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/*
Print a single integer denoting the number of characters you must delete to make the two strings anagrams of each other.

Sample Input:
cde
abc

Sample Output:
4
 */

public class Anagram {
    public static int calculateDeletionsToAnagram(String first, String second) {
        if (first.contentEquals(second)) {
            return 0;
        }

        List<Character> firstList = new ArrayList<>();
        for (char c : first.toCharArray()) {
            firstList.add(c);
        }
        List<Character> secondList = new ArrayList<>();
        for (char c : second.toCharArray()) {
            secondList.add(c);
        }

        List common = new ArrayList();
        for (int i = 0; i < firstList.size(); i++) {
            char current = firstList.get(i);
            if (secondList.contains(current)) {
                common.add(current);
                secondList.remove(secondList.lastIndexOf(current));
            }
        }
        
        return firstList.size() + secondList.size() - common.size();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(calculateDeletionsToAnagram(a, b));
    }
}
