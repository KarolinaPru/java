package com.buttonPractice;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.UIManager;


public class SecondButton extends JButton implements ActionListener{
	
	private boolean clicked = false;
	
	//pobiera domyœlny kolor panelu
	Color defaultColor = UIManager.getColor ( "Panel.background" );
	
	
	SecondButton(){
		super("Nice color");
		addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(clicked)
			setBackground(Color.MAGENTA);
		else
			setBackground(defaultColor);
		clicked = !clicked;
		
	}
}
