package com.karolina2;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.karolina2.SwingSampleWithLambdaAndMyComponent.MyComponent;

public class MyFrame extends JFrame
{

	private static final int WIDTH = 300;
	private static final int HEIGHT = 200;
	private JButton buttonOne;
	private JButton buttonTwo;
	private JButton buttonThree;
	private JButton buttonFour;
	private JButton buttonFive;
	private JFrame frame;
	private JButton closeButton;

	public static void main(String[] args)
	{
		new MyFrame().run();
	}

	public MyFrame()
	{
		setSize(WIDTH, HEIGHT);
		buttonOne = new JButton("North");
		buttonTwo = new JButton("East");
		buttonThree = new JButton("South");
		buttonFour = new JButton("West");
		buttonFive = new JButton("Center");
		closeButton = new JButton("Close");
		closeButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				frame.setVisible(false);
			}
		});
	}

	void run()
	{

		frame = new JFrame("Frame with buttons");
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

		EventQueue.invokeLater(new Runnable()
		{

			@Override
			public void run()
			{
				// TODO Auto-generated method stub

			}

		});
	}
}
