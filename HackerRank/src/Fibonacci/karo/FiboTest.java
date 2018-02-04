package Fibonacci.karo;

import org.junit.jupiter.api.Test;

import static Fibonacci.karo.Fibo.fibonacci;
import static org.junit.jupiter.api.Assertions.*;

class FiboTest {
    @Test
    void fibonacciTest5() {
        int input = 5;
        int actual = fibonacci(input);
        int expected = 5;

        assertEquals(expected, actual);
    }

    @Test
    void fibonacciTest6() {
        int input = 6;
        int actual = fibonacci(input);
        int expected = 8;

        assertEquals(expected, actual);
    }

}