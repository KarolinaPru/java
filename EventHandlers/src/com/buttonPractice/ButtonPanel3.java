package com.buttonPractice;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.JButton;

public class ButtonPanel3 extends JPanel implements ActionListener {
	
	public static final int HEIGHT = 200;
	public static final int WIDTH = 350;
	private JButton randomColorButton;
	private JButton customColorButton;
	private JButton clickedButton;
	
	public ButtonPanel3() {
		randomColorButton = new FirstButton(this);
		customColorButton = new SecondButton();
		clickedButton = new ThirdButton();
	
		setLayout(new FlowLayout());
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		
		add(randomColorButton);
		add(customColorButton);
		add(clickedButton);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if(source == randomColorButton){
		
			
		}
	}
}
