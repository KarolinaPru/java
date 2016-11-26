package com.Layouts;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;

public class BorderLayoutFrameInner extends JFrame{

	public static void main (String[] args) {
		new BorderLayoutFrameInner();
	}

	public BorderLayoutFrameInner() {
		super("Border layout with an inner class!");
		setSize(500, 500);
		setLocation(400, 400);
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

	void run() {
		EventQueue.invokeLater(new Runnable (){
			@Override
			public void run(){
				new BorderLayoutFrameInner();
			}
		});
	}
}