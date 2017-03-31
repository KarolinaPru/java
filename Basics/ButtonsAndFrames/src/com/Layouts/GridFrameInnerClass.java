package com.Layouts;

import java.awt.EventQueue;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class GridFrameInnerClass extends JFrame {

	public GridFrameInnerClass() {
		super("Check out this awesome grid frame using an inner class!");
		setBounds(200, 200, 700, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(5, 0));

		for (int i=0; i < 15; i++)
			add(new JButton(""+ (i+1)));

		setVisible(true);
	}

	void run() { 
		EventQueue.invokeLater(new Runnable(){

			@Override
			public void run() {
				new GridFrameInnerClass();
			}
		});		
	}
	public static void main (String[] args){
		new GridFrameInnerClass();
	}
}


