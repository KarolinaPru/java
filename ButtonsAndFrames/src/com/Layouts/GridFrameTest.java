package com.Layouts;

import java.awt.EventQueue;

public class GridFrameTest {
	
	public static void main (String[] args) {
		EventQueue.invokeLater(new Runnable () {
			@Override
			public void run() {
				new GridFrame();
			}
		});
	}
}
