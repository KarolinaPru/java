package com.karolina;
import javax.swing.*;

public class ActionFrame extends JFrame {
	
	public ActionFrame(){
		super("Action test");
		
		ButtonPanel2 buttonPanel = new ButtonPanel2();
		add(buttonPanel);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
}
