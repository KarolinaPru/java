package com.karolina;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class MyFirstWindowTest {

	public static void main(String[] args) {
		
				MyFirstWindow myWindow = new MyFirstWindow();
				myWindow.setTitle("Karolina's first frame without an image!");
				myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				myWindow.setVisible(true);
				
	}
}
