package Staircase.karo;

import java.util.Scanner;

/*
1, 2, 3 steps at a time

Sample Input:
3 - number of staircases
1 - height of a particular staircase
3
7
Sample Output:
1 - no of permutations
4
44
 */
public class Solution {
    public int calculatePermutations(int height) {
        if (height == 1) {
            return 1;
        }
        if (height == 2) {
            return 2;
        }
        if (height == 3) {
            return 4;
        }
        int permutations =
            calculatePermutations(height - 1) + calculatePermutations(height - 2) + calculatePermutations(height - 3);

        return permutations;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numberOfStaircases = in.nextInt();
        for (int a0 = 0; a0 < numberOfStaircases; a0++){
            int height = in.nextInt();
        }
    }
}