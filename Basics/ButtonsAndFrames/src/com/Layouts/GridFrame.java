package com.Layouts;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class GridFrame extends JFrame {
	
	public GridFrame() {
		super("Check out this awesome grid frame!");
		setBounds(200, 200, 300, 250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(5, 0));
		
		for (int i=0; i < 15; i++)
			add(new JButton(""+ (i+1)));
		
		setVisible(true);
	}
}
