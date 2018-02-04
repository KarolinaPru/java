package Fibonacci.karo;

import java.util.*;

public class Fibo {
    /*
Sample Input: 3  Sample Output: 2
Explanation
Consider the Fibonacci sequence:
fibo(n) = fibo(n-1) + fibo(n-2)

fibo(0) = 0
fibo(1) = 1
fibo(2) = 0 + 1 = 1
fibo(3) = 1 + 1 = 2
fibo(4) = 1 + 2 = 3
fibo(5) = 2 + 3 = 5
fibo(6) = 3 + 5 = 8

We want to know the value of fibo(3). If we look at the sequence above,  evaluates to 2. Thus, we print  as our answer.
*/

    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int result = fibonacci(n-1) + fibonacci(n-2);
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        System.out.println(fibonacci(n));
    }
}