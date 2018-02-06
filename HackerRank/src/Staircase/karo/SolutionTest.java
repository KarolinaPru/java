package Staircase.karo;

import org.junit.jupiter.api.Test;
import static Staircase.karo.Solution.calculatePermutationsRecursively;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    Solution s = new Solution();
    int[] cachedResults = s.initializeCache();

    @Test
    void permutationsFor3() {
        int height = 3;
        int actualRecursive = calculatePermutationsRecursively(height);
        int actualDynamic = s.calculatePermutationsDynamically(height, cachedResults);
        int expected = 4;

        assertEquals(expected, actualRecursive);
        assertEquals(expected, actualDynamic);
    }

    @Test
    void permutationsFor4() {
        int height = 4;
        int actualRecursive = calculatePermutationsRecursively(height);
        int actualDynamic = s.calculatePermutationsDynamically(height, cachedResults);
        int expected = 7;

        assertEquals(expected, actualRecursive);
        assertEquals(expected, actualDynamic);
    }

    @Test
    void permutationsFor5() {
        int height = 5;
        int actualRecursive = calculatePermutationsRecursively(height);
        int actualDynamic = s.calculatePermutationsDynamically(height, cachedResults);
        int expected = 13;

        assertEquals(expected, actualRecursive);
        assertEquals(expected, actualDynamic);
    }

    @Test
    void permutationsFor7() {
        int height = 7;
        int actualRecursive = calculatePermutationsRecursively(height);
        int actualDynamic = s.calculatePermutationsDynamically(height, cachedResults);
        int expected = 44;

        assertEquals(expected, actualRecursive);
        assertEquals(expected, actualDynamic);
    }

    @Test
    void permutationsFor36() {
        int height = 36;
//        int actualRecursive = calculatePermutationsRecursively(height);
        int actualDynamic = s.calculatePermutationsDynamically(height, cachedResults);
        int expected = 2082876103;

//        assertEquals(expected, actualRecursive);
        assertEquals(expected, actualDynamic);
    }
}