package com.karolina;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonPanel2 extends JPanel{

	public static final int HEIGHT = 100;
	public static final int WIDTH = 300;
	private JButton greenButton;
	private JButton blueButton;
	private JButton redButton;

	private JPanel buttonPanel;

	public ButtonPanel2() {
		greenButton = new GreenButton();
		blueButton = new BlueButton();
		redButton = new RedButton();

		buttonPanel = this;

		setLayout(new FlowLayout());
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		add(greenButton);
		add(blueButton);
		add(redButton);
	}

	class GreenButton extends JButton implements ActionListener {

		GreenButton() {
			super("Green");
			addActionListener(this);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			buttonPanel.setBackground(Color.GREEN);
		}
	}

	class BlueButton extends JButton implements ActionListener {

		BlueButton() {
			super("Blue");
			addActionListener(this);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			buttonPanel.setBackground(Color.BLUE);
		}
	}

	class RedButton extends JButton implements ActionListener {

		RedButton() {
			super("Red");
			addActionListener(this);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			buttonPanel.setBackground(Color.RED);
		}
	}

}