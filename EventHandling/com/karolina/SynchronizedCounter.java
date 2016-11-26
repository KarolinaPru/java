package com.karolina;

public class SynchronizedCounter {  
	private int c = 0;
	
    public synchronized boolean sprawdzCzyLiczbaPierwsza(int n) {
       if (n == 1)
    	   return false;
       for (int i=1; i < n; i++) {
    	   if(n%i == 0) { 
    		  c++;
    		  if (c > 2)
    			 return false;
    	   }
       }
        return true;
    }
    public synchronized void decrement() {
        c--;
    }
    public synchronized int value() {
        return c;
    }
}