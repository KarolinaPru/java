package Staircase.karo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
Sample Input

3 - number of staircases
1 - height of a particular staircase
3
7
Sample Output

1 - no of permutations
4
44
 */
class SolutionTest {
    Solution s = new Solution();

    @Test
    void permutationsFor3() {
        int height = 3;
        int actual = s.calculatePermutations(height);
        int expected = 4;

        assertEquals(expected, actual);
    }
    @Test
    void permutationsFor4() {
        int height = 4;
        int actual = s.calculatePermutations(height);
        int expected = 7;

        assertEquals(expected, actual);
    }

}