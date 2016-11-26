package com.karolina2;

import javax.swing.Timer;


public class PrimeNumbersPrinter {

	static boolean isPrime(int n) {

		for (int i = 2; i <= java.lang.Math.sqrt(n); i++)
			if((n % i) == 0)
				return false;
		return true;
	}

	public static void main(String[] args) throws InterruptedException {
		Timer t = new Timer(500, e-> System.exit(0));
		t.start();

		int n = 0; 
		while (true) {
			if (isPrime(n))
				System.out.println(n);
			n++;
		}
	}
}

