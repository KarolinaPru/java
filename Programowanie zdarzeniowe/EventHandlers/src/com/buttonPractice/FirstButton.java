package com.buttonPractice;

import java.awt.Color;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class FirstButton extends JButton implements ActionListener {
	 
	private JPanel buttonPanel;
	private Color[] colors = {Color.BLUE, Color.GREEN, Color.RED};
	
	FirstButton(JPanel buttonPanel) {
		super("Surprise");
		this.buttonPanel = buttonPanel;
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int index = new Random().nextInt(colors.length);
		buttonPanel.setBackground(colors[index]);
	}

}
