package com.karolina2;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import com.karolina.SwingSampleWithLambda;

public class SwingSampleWithLambdaAndMyComponent {

	MyComponent closeButton;
	
	public static void main(String[] args) {
		new SwingSampleWithLambdaAndMyComponent().run();
	}

	void run() {
		SwingUtilities.invokeLater(() -> {
			JFrame frame = new JFrame("Pierwszy Przycisk");
			frame.setBounds(100, 100, 450, 300);          
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			closeButton = new MyComponent();
			frame.getContentPane().add(closeButton);
			frame.pack();
			frame.setVisible(true);                  
		});
	} 

	class MyComponent extends JComponent {
		public static final int MESSAGE_X = 75;
		public static final int MESSAGE_Y = 100;
		private static final int DEFAULT_WIDTH = 300;
		private static final int DEFAULT_HEIGHT = 200;

		public void paintComponent(Graphics g)  {
			g.drawString("Click and close", MESSAGE_X, MESSAGE_Y);
		}
		public Dimension getPreferredSize() {
			return new Dimension(DEFAULT_WIDTH,    DEFAULT_HEIGHT);
		}
	}
}