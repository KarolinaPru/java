package com.karolina;
import java.awt.EventQueue;

public class ButtonsTest {
	
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable(){
			@Override
			public void run(){
				new ActionFrame();
			}
		});
	}
}
 