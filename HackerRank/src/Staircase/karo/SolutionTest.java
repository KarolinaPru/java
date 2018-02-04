package Staircase.karo;

import org.junit.jupiter.api.Test;

import static Staircase.karo.Solution.calculatePermutations;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void permutationsFor3() {
        int height = 3;
        int actual = calculatePermutations(height);
        int expected = 4;

        assertEquals(expected, actual);
    }

    @Test
    void permutationsFor4() {
        int height = 4;
        int actual = calculatePermutations(height);
        int expected = 7;

        assertEquals(expected, actual);
    }

    @Test
    void permutationsFor5() {
        int height = 5;
        int actual = calculatePermutations(height);
        int expected = 13;

        assertEquals(expected, actual);
    }

    @Test
    void permutationsFor7() {
        int height = 7;
        int actual = calculatePermutations(height);
        int expected = 44;

        assertEquals(expected, actual);
    }

    @Test
    void permutationsFor36() {
        int height = 36;
        int actual = calculatePermutations(height);
        int expected = 2082876103;

        assertEquals(expected, actual);
    }
}