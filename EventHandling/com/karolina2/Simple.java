package com.karolina2;

import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;

import javax.swing.*;


public class Simple {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(  () -> {
			JFrame frame = new JFrame("Dwa przyciski");
			frame.setBounds(100, 100, 450, 300);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Container pane = frame.getContentPane();
			pane.setLayout(new FlowLayout(FlowLayout.LEFT));
			for(int i=0; i< 10; i++) {
				JButton btn = new JButton(String.valueOf(i));
				btn.setSize(new Dimension(100,20));
				pane.add(btn);
			}
			pane.applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
			frame.setVisible(true);
		});
	}
}