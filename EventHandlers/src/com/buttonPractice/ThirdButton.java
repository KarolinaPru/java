package com.buttonPractice;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ThirdButton extends JButton implements ActionListener {
	
	private boolean clicked = false;
	
	public ThirdButton() {
		super("Click me");
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(clicked)
			setText("You clicked!");
		else
			setText("Click me");
		clicked = !clicked;
				
	}
}
