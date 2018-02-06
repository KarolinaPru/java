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
    private final int MAX = 36;
    private int[] cachedResults = new int[MAX + 1];


    public int[] initializeCache() {
        this.cachedResults[0] = 0;
        this.cachedResults[1] = 1;
        this.cachedResults[2] = 2;
        this.cachedResults[3] = 4;
        for (int i = 4; i <= MAX; i++) {
            this.cachedResults[i] = -1;
        }
        return this.cachedResults;
    }

    // Memoization --> Top Down
    public int calculatePermutationsDynamically(int height, int[] cachedResults) {
        if (cachedResults[height] != -1) {
            return cachedResults[height];
        } else {
            cachedResults[height]
                = calculatePermutationsDynamically(height - 1, cachedResults)
                + calculatePermutationsDynamically(height - 2, cachedResults)
                + calculatePermutationsDynamically(height - 3, cachedResults);
            return cachedResults[height];
        }
    }

    public static int calculatePermutationsRecursively(int height) {
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
            calculatePermutationsRecursively(height - 1)
                + calculatePermutationsRecursively(height - 2)
                + calculatePermutationsRecursively(height - 3);

        return permutations;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Choose the number of staircases [up to 5]:");
        int numberOfStaircases = in.nextInt();

        System.out.println("What's each staircases height? [up to 36]");
        int[] heights = new int[numberOfStaircases];
        for (int i = 0; i < numberOfStaircases; i++) {
            int height = in.nextInt();
            heights[i] = height;
        }

        runDynamicVersion(heights);
        runPlainRecursiveVersion(heights);

    }

    private static void runDynamicVersion(int[] heights) {
        Solution s = new Solution();
        long startDynamic = System.currentTimeMillis();
        s.initializeCache();
        for (int height : heights) {
            System.out.println(s.calculatePermutationsDynamically(height, s.cachedResults));
        }
        long stopDynamic = System.currentTimeMillis();
        System.out.println("Dynamic: " + (stopDynamic - startDynamic) + " ms");
    }

    private static void runPlainRecursiveVersion(int[] heights) {
        long start = System.currentTimeMillis();
        for (int height : heights) {
            System.out.println(calculatePermutationsRecursively(height));
        }
        long stop = System.currentTimeMillis();
        System.out.println("Recursive: " + (stop - start) + " ms");
    }
}
