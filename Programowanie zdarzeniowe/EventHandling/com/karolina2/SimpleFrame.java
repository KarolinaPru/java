package com.karolina2;

import javax.swing.JFrame;

public class SimpleFrame extends JFrame {
	private static final int DEFAULT_WIDTH = 400;
	private static final int DEFAULT_HEIGHT = 300;
	
	public SimpleFrame() {
		super("New frame");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		setResizable(false);
	}
}
