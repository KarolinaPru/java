package com.karolina;

public class HelloThread extends Thread {
	  int id ;
	  public HelloThread(int id) {
	    this.id = id;
	  }

	  public void run() {
	    System.out.println("Hello from thread "+ id + " "+System.currentTimeMillis() );
	    try {
	      Thread.sleep(1000);
	    } catch (InterruptedException e) {
	      e.printStackTrace();
	    }
	    System.out.println("Bye from thread "+ id  + " "+System.currentTimeMillis() );
	  }

	  public static void main(String args[]) {
	        (new HelloThread(1)).start();
	        (new HelloThread(2)).start();        
	        (new HelloThread(3)).start();
	  }
	}
