package com.karolina2;

class Primers extends Thread {
	static  boolean   isPrime(int n) {
		for(int i=2; i <= Math.sqrt(n); i++)
			if((n % i) == 0)
				return false;
		return true;
	}
	public void run() {

		int n = 0;
		while(true) {
			n+=1;
			if(isPrime(n))
				System.out.println(n);
		}
	}
}

class PrimeTimer extends Thread {
	public void run() {
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.exit(0);
	}
}




public class PrimeNumbers  {
	public static void main(String[] args) {
		(new PrimeTimer()).start();
		(new Primers()).start();
		System.out.println("bye bye main");		
	}
}
