package com.karolina;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class SimpleSwingSample2 {
	  JButton closeButton;
	  
	  class ButtonListener implements ActionListener {
	    @Override
	    public void actionPerformed(ActionEvent e) {
	    	closeButton.setForeground(Color.RED); // a jak inne kontrolki?
	    }
	  }  
	  void run() {
	    SwingUtilities.invokeLater(() -> {
	      JFrame frame = new JFrame("Pierwszy Przycisk");
	      frame.setBounds(100, 100, 450, 300);          // nadaje rozmiar oknu
	      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      closeButton = new JButton("Click me!"); // tu ustawiamy
	      closeButton.addActionListener(new ButtonListener());
	      frame.getContentPane().add(closeButton);
	      frame.setVisible(true);                  // pokaż onkno
	    });
	  } 
	  
	  public static void main(String[] args) {
	    new SimpleSwingSample2().run();
	  }
	}
