package com.Layouts;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.EventQueue;


public class MyFrame extends JFrame {
	
	public MyFrame() {
		super("Border layout, check it out!");
		setSize(300, 250);
		setLocation(200, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton north = new JButton ("North");
		JButton east = new JButton ("East");
		JButton west = new JButton ("West");
		JButton south = new JButton ("South");
		JButton center = new JButton ("Center");		
	
		BorderLayout border = new BorderLayout();
		
		
		add(north, border.NORTH);
		add(east, border.EAST);
		add(west, border.WEST);
		add(south, border.SOUTH);
		add(center, border.CENTER);
		
		setVisible(true);
	}
}

