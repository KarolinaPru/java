package com.karolina;

public class PrimeNumbers extends Thread {
	static boolean isPrime(int n) {
		
		for (int i = 2; i < Math.sqrt(n); i++)
			if((n % i) == 0)
				return false;
	    return true;
	}
	
	public void run() {
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.exit(0);
	}

	public static void main (String[] args) {
		(new PrimeNumbers()).start();
		
		int n = 0; 
		while (true) {
			n+=1;
			if (isPrime(n))
				System.out.println(n);
		}
	}
} 
