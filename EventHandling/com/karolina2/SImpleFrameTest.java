package com.karolina2;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class SImpleFrameTest {

	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable(){
			public void run() {
				SimpleFrame frame = new SimpleFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}