package com.buttonPractice;

import javax.swing.*;

public class ActionFrame extends JFrame {

	public ActionFrame() {
		super("Action test");
		
		JPanel buttonPanel = new ButtonPanel3();
		add(buttonPanel);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
}
