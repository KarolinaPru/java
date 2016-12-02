package com.karolina2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.karolina2.SwingSampleWithLambdaAndMyComponent.MyComponent;

public class MyFrame extends JFrame{
	
	private static final int WIDTH = 300;
	private static final int HEIGHT = 200;
	
	public static void main(String[] args){
			new MyFrame.run() {
			}
			
	public MyFrame() {
		JButton buttonOne = new JButton("North");
		JButton buttonTwo = new JButton("East");
		JButton buttonThree = new JButton("South");
		JButton buttonFour = new JButton("West");
		JButton buttonFive = new JButton("Center");		
		
		MyFrame container = new MyFrame();
		setSize(WIDTH, HEIGHT);
		
		
		void run() {
			
				JFrame frame = new JFrame("Frame with buttons");
				frame.setSize(WIDTH, HEIGHT);    
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				frame.add(buttonOne, BorderLayout.NORTH);
				frame.add(buttonTwo, BorderLayout.EAST);
				frame.add(buttonThree, BorderLayout.SOUTH);
				frame.add(buttonFour, BorderLayout.WEST);
				frame.add(buttonFive, BorderLayout.CENTER);
		
				frame.getContentPane().add(closeButton);
				frame.pack();
				frame.setVisible(true);                  
			}
		} 
		
		
	}
		
		
			EventQueue.invokeLater(new Runnable(){
				
				}
			});
	}
}
