package Anagrams.karo;

import org.junit.jupiter.api.Test;

import static Anagrams.karo.Anagram.calculateDeletionsToAnagram;
import static org.junit.jupiter.api.Assertions.*;

class AnagramTest {

    @Test
    void test1() {
        String first = "cde";
        String second = "abc";

        int expected = 4;
        int actual = calculateDeletionsToAnagram(first, second);

        assertEquals(expected, actual);
    }

    @Test
    void test2() {
        String first = "aaa";
        String second = "aaa";

        int expected = 0;
        int actual = calculateDeletionsToAnagram(first, second);

        assertEquals(expected, actual);
    }

    @Test
    void test3() {
        String first = "abece";
        String second = "eceba";

        int expected = 0;
        int actual = calculateDeletionsToAnagram(first, second);

        assertEquals(expected, actual);
    }

    @Test
    void test4() {
        String first = "aaa";
        String second = "aa";

        int expected = 1;
        int actual = calculateDeletionsToAnagram(first, second);

        assertEquals(expected, actual);
    }

    @Test
    void test5() {
        String first = "cb";
        String second = "cbkkka";

        int expected = 4;
        int actual = calculateDeletionsToAnagram(first, second);

        assertEquals(expected, actual);
    }
}