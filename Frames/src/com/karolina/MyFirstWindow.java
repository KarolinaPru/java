package com.karolina;
import java.awt.*;
import javax.swing.*;


public class MyFirstWindow extends JFrame {
	private JLabel label1;
	
	public MyFirstWindow(){
		
		setLayout(new FlowLayout());
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		
		setSize(screenWidth / 2, screenHeight / 2);
		setLocation(250, 250);
		
		
	}	
}