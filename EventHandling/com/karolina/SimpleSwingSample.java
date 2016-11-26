package com.karolina;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

class ButtonListener implements ActionListener {
	  
	@Override
	  public void actionPerformed(ActionEvent e) {
	    ((JButton)e.getSource()).setText("naciśnięto"); // a jak inne kontrolki?
	 }
}
	

public class SimpleSwingSample {
	  public static void main(String[] args) {
	    SwingUtilities.invokeLater(() -> {
	      JFrame frame = new JFrame("Pierwszy Przycisk");
	      frame.setBounds(100, 100, 450, 300);          // nadaje rozmiar oknu
	      // zakończ aplikację po zamknięciu okna
	      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      JButton closeButton = new JButton("jeszcze nie naciśnięto");
	      closeButton.addActionListener(new ButtonListener());
	      frame.getContentPane().add(closeButton);
	      frame.setVisible(true);                  // pokaż onkno
	    });
	  }
	}