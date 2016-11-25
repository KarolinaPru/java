package com.karolina;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;


public class ButtonPanel extends JButton implements ActionListener{
	
	public static final int HEIGHT = 100;
	public static final int WIDTH = 300;
	private JButton greenButton;
	private JButton blueButton;
	private JButton redButton;
	
	public ButtonPanel(){
		greenButton = new JButton("Green");
		blueButton = new JButton("Blue");
		redButton = new JButton("Red");
	
		greenButton.addActionListener(this);
		blueButton.addActionListener(this);
		redButton.addActionListener(this);
		
		setLayout(new FlowLayout());
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		add(greenButton);
		add(blueButton);
		add(redButton);
	}

	@Override
	// Przekazywany argument ActionEvent przechowuje wiele informacji w tym Ÿród³o, które mo¿emy pobraæ przy pomocy metody getSource()
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if(source == greenButton)
			setBackground(Color.GREEN);
		if(source == blueButton)
			setBackground(Color.BLUE);
		if(source == redButton)
			setBackground(Color.RED);
		
	}

}
