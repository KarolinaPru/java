import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class CalculatorInterface implements ActionListener
{
	final static double WEIGHT_X = 0.2;
	final static double WEIGHT_Y = 0.2;
	final static Dimension MAX_SIZE = new Dimension (1000, 1000);
	final static Dimension MIN_SIZE = new Dimension (300, 300);
	final static Dimension BTN_MAX_SIZE = new Dimension (160, 160);
	final static Dimension BTN_MIN_SIZE = new Dimension (60, 60);
	final static Font BUTTON_FONT = new Font("Verdana", Font.BOLD, 18);
	private JTextField calculationField;
	private JButton one;
	private JButton two;
	private JButton three;
	private JButton four;
	private JButton five;
	private JButton six;
	private JButton seven;
	private JButton eight;
	private JButton nine;
	private JButton zero;
	private JButton clear;
	private JButton division;
	private JButton multiplication;
	private JButton	subtraction;
	private JButton addition;
	private JButton squareRoot;
	private JButton percent;
	private JButton equals;
	private JButton decimalSeparator;
	private JButton plusMinusSign;

	
	public void addComponentsToPane(Container container)
	{
		container.setLayout(new GridBagLayout());

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.weightx = WEIGHT_X;
		c.weighty = WEIGHT_Y;
		c.ipadx = 40;
		c.ipady = 40;
		
		calculationField = new JTextField();
		c.gridwidth = 4;
		c.gridx = 0;
		c.gridy = 0;
		calculationField.setFont(new Font ("Tahoma", Font.PLAIN, 24));
		calculationField.setHorizontalAlignment(SwingConstants.RIGHT);;
		
		container.add(calculationField, c);
		
		zero = new JButton("0");
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 4;
		zero.setFont(BUTTON_FONT);
		zero.setMinimumSize(BTN_MIN_SIZE);
		zero.setMaximumSize(BTN_MAX_SIZE);
		container.add(zero, c);
		
		one = new JButton("1");
		c.gridx = 0;
		c.gridy = 3;
		one.setFont(BUTTON_FONT);
		one.setMinimumSize(BTN_MIN_SIZE);
		one.setMaximumSize(BTN_MAX_SIZE);
		container.add(one, c);

		two = new JButton("2");
		c.gridx = 1;
		c.gridy = 3;
		two.setFont(BUTTON_FONT);
		two.setMinimumSize(BTN_MIN_SIZE);
		two.setMaximumSize(BTN_MAX_SIZE);
		container.add(two, c);

		three = new JButton("3");
		c.gridx = 2;
		c.gridy = 3;
		three.setFont(BUTTON_FONT);
		three.setMinimumSize(BTN_MIN_SIZE);
		three.setMaximumSize(BTN_MAX_SIZE);
		container.add(three, c);
		
		four = new JButton("4");
		c.gridx = 0;
		c.gridy = 2;
		four.setFont(BUTTON_FONT);
		four.setMinimumSize(BTN_MIN_SIZE);
		four.setMaximumSize(BTN_MAX_SIZE);
		container.add(four, c);

		five = new JButton("5");
		c.gridx = 1;
		c.gridy = 2;
		five.setFont(BUTTON_FONT);
		five.setMinimumSize(BTN_MIN_SIZE);
		five.setMaximumSize(BTN_MAX_SIZE);
		container.add(five, c);

		six = new JButton("6");
		c.gridx = 2;
		c.gridy = 2;
		six.setFont(BUTTON_FONT);
		six.setMinimumSize(BTN_MIN_SIZE);
		six.setMaximumSize(BTN_MAX_SIZE);
		container.add(six, c);
				
		seven = new JButton("7");
		c.gridx = 0;
		c.gridy = 1;
		seven.setFont(BUTTON_FONT);
		seven.setMinimumSize(BTN_MIN_SIZE);
		seven.setMaximumSize(BTN_MAX_SIZE);
		container.add(seven, c);

		eight = new JButton("8");
		c.gridx = 1;
		c.gridy = 1;
		eight.setFont(BUTTON_FONT);
		eight.setMinimumSize(BTN_MIN_SIZE);
		eight.setMaximumSize(BTN_MAX_SIZE);
		container.add(eight, c);

		nine = new JButton("9");
		c.gridx = 2;
		c.gridy = 1;
		nine.setFont(BUTTON_FONT);
		nine.setMinimumSize(BTN_MIN_SIZE);
		nine.setMaximumSize(BTN_MAX_SIZE);
		container.add(nine, c);
		
		decimalSeparator = new JButton(".");
		c.gridx = 1;
		c.gridy = 4;
		decimalSeparator.setFont(BUTTON_FONT);
		decimalSeparator.setMinimumSize(BTN_MIN_SIZE);
		decimalSeparator.setMaximumSize(BTN_MAX_SIZE);
		container.add(decimalSeparator, c);
		
		plusMinusSign = new JButton("+/-");
		c.gridx = 2;
		c.gridy = 4;
		plusMinusSign.setFont(BUTTON_FONT);
		plusMinusSign.setMinimumSize(BTN_MIN_SIZE);
		plusMinusSign.setMaximumSize(BTN_MAX_SIZE);
		container.add(plusMinusSign, c);
		
		clear = new JButton("C");
		c.gridx = 4;
		c.gridy = 0;
		clear.setFont(BUTTON_FONT);
		clear.setMinimumSize(BTN_MIN_SIZE);
		clear.setMaximumSize(BTN_MAX_SIZE);
		container.add(clear, c);
		clear.addActionListener(this);
				
		division = new JButton("/");
		c.gridx = 3;
		c.gridy = 1;
		division.setFont(BUTTON_FONT);
		division.setMinimumSize(BTN_MIN_SIZE);
		division.setMaximumSize(BTN_MAX_SIZE);
		container.add(division, c);
		division.addActionListener(this);
		
		multiplication = new JButton("*");
		c.gridx = 3;
		c.gridy = 2;
		multiplication.setFont(BUTTON_FONT);
		multiplication.setMinimumSize(BTN_MIN_SIZE);
		multiplication.setMaximumSize(BTN_MAX_SIZE);
		container.add(multiplication, c);
		multiplication.addActionListener(this);
		
		subtraction = new JButton("-");
		c.gridx = 3;
		c.gridy = 3;
		subtraction.setFont(BUTTON_FONT);
		subtraction.setMinimumSize(BTN_MIN_SIZE);
		subtraction.setMaximumSize(BTN_MAX_SIZE);
		container.add(subtraction, c);
		subtraction.addActionListener(this);
		
		addition = new JButton("+");
		c.gridx = 3;
		c.gridy = 4;
		addition.setFont(BUTTON_FONT);
		addition.setMinimumSize(BTN_MIN_SIZE);
		addition.setMaximumSize(BTN_MAX_SIZE);
		container.add(addition, c);
		addition.addActionListener(this);
		
		squareRoot = new JButton("sqrt");
		c.gridx = 4;
		c.gridy = 1;
		squareRoot.setFont(BUTTON_FONT);
		squareRoot.setMinimumSize(BTN_MIN_SIZE);
		squareRoot.setMaximumSize(BTN_MAX_SIZE);
		container.add(squareRoot, c);	
		squareRoot.addActionListener(this);
		
		percent = new JButton("%");
		c.gridx = 4;
		c.gridy = 2;
		percent.setFont(BUTTON_FONT);
		percent.setMinimumSize(BTN_MIN_SIZE);
		percent.setMaximumSize(BTN_MAX_SIZE);
		container.add(percent, c);
		percent.addActionListener(this);
		
		equals = new JButton("=");
		c.gridheight = 2;
		c.gridx = 4;
		c.gridy = 3;
		equals.setFont(BUTTON_FONT);
		equals.setMinimumSize(new Dimension(60, 120));
		equals.setMaximumSize(new Dimension (160, 320));
		container.add(equals, c);
		equals.addActionListener(this);
		
	}

	public void createInterface()
	{
		JFrame frame = new JFrame();
		frame.setTitle("ZDA Kalkulator");
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		addComponentsToPane(frame.getContentPane());
		frame.setPreferredSize(new Dimension(400, 500));
		frame.setLocation(200, 200);
		frame.setMinimumSize(MIN_SIZE);
		// Ta metoda niestety nie dzia³a
		frame.setMaximumSize(MAX_SIZE);
		frame.pack();
		frame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == addition)
		{
		//	add();
		}
		
		if (e.getSource() == subtraction)
		{
		//	subtract();
		}
		
		if (e.getSource() == multiplication)
		{
			// multiply();
		}
		
		if (e.getSource() == division)
			
		{
			//divide();
		}
		
		if (e.getSource() == percent)
		{
			// calculatePercent();
		}
		
		if (e.getSource() == squareRoot)
		{
			//calculateSquareRoot();
		}
	}
	
	
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{

			@Override
			public void run()
			{
				new CalculatorInterface().createInterface();

			}

		});
	}
}
