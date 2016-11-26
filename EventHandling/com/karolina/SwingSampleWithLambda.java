package com.karolina;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class SwingSampleWithLambda {


	JButton closeButton;
	public static void main(String[] args) {
		new SwingSampleWithLambda().run();
	}
	void run() {
		SwingUtilities.invokeLater(() -> {
			JFrame frame = new JFrame("Pierwszy Przycisk");
			frame.setBounds(100, 100, 450, 300);          
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			closeButton = new JButton("jeszcze nie naciśnięto");
			closeButton.addActionListener(e->closeButton.setText("naciśnięto"));
			frame.getContentPane().add(closeButton);
			frame.setVisible(true);                  
		});
	}
}
