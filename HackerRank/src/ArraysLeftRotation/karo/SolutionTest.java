package ArraysLeftRotation.karo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class SolutionTest {
    private Solution s = new Solution();

//
//    int[] input;
//    int rotations;
//    List actual;
//
//    actual = s.applyLeftRotations(input, rotations);
//    List expected;
//
//    assertSame(expected, actual);

    @Test
    void applyLeftRotationsTest() {
        int[] input = {0, 1, 2, 3, 4};
        int rotations = 3;
        List actual;

        actual = s.applyLeftRotations(input, rotations);
        List expected = new ArrayList();
        expected.add(3);
        expected.add(4);
        expected.add(0);
        expected.add(1);
        expected.add(2);

        assertEquals(expected, actual);
    }
    @Test
    void applyLeftRotationsTest2() {
        int[] input = {0, 1, 2, 3, 4};
        int rotations = 5;
        List actual;

        actual = s.applyLeftRotations(input, rotations);
        List expected = new ArrayList();
        expected.add(0);
        expected.add(1);
        expected.add(2);
        expected.add(3);
        expected.add(4);

        assertEquals(expected, actual);
    }

}