package com.karolina;
import javax.swing.*;

public class ActionFrame extends JFrame {
	
	public ActionFrame(){
		super("Action test");
		
		ButtonPanel buttonPanel = new ButtonPanel();
		add(buttonPanel);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}

}
