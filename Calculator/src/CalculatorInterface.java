import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class CalculatorInterface
{
	final static double WEIGHT_X = 0.2;
	final static double WEIGHT_Y = 0.2;
	final static Dimension MAX_SIZE = new Dimension(1000, 1000);
	final static Dimension MIN_SIZE = new Dimension(300, 300);
	final static Dimension BTN_MIN_SIZE = new Dimension(60, 60);
	final static Font BUTTON_FONT = new Font("Verdana", Font.BOLD, 18);
	public JTextField txtField;
	public String enteredText;
	public JButton one, two, three, four, five, six, seven, eight, nine, zero, clear, division, multiplication,
			subtraction, addition, squareRoot, percent, equalsSign, decimalSeparator, negation;
	
	private CalculatorListener listener;

	public CalculatorInterface()
	{
		listener = new CalculatorListener(this);

		JFrame frame = new JFrame();
		frame.setTitle("ZDA Kalkulator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addComponentsToPane(frame.getContentPane());
		frame.setPreferredSize(new Dimension(400, 500));
		frame.setLocation(200, 200);
		frame.setMinimumSize(MIN_SIZE);
		// Ta metoda niestety nie działa
		frame.setMaximumSize(MAX_SIZE);
		frame.pack();
		frame.setVisible(true);
	}

	public void addComponentsToPane(Container container)
	{
		container.setLayout(new GridBagLayout());

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.weightx = WEIGHT_X;
		c.weighty = WEIGHT_Y;
		c.ipadx = 40;
		c.ipady = 40;

		txtField = new JTextField();
		c.gridwidth = 4;
		c.gridx = 0;
		c.gridy = 0;
		txtField.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtField.setHorizontalAlignment(SwingConstants.RIGHT);
		container.add(txtField, c);

		disableEnteringNonDigitCharacters();

		enteredText = txtField.getText();

		zero = new JButton("0");
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 4;
		zero.setFont(BUTTON_FONT);
		zero.setMinimumSize(BTN_MIN_SIZE);
		zero.addActionListener(listener);
		container.add(zero, c);

		one = new JButton("1");
		c.gridx = 0;
		c.gridy = 3;
		one.setFont(BUTTON_FONT);
		one.setMinimumSize(BTN_MIN_SIZE);
		container.add(one, c);
		one.addActionListener(listener);

		two = new JButton("2");
		c.gridx = 1;
		c.gridy = 3;
		two.setFont(BUTTON_FONT);
		two.setMinimumSize(BTN_MIN_SIZE);
		container.add(two, c);
		two.addActionListener(listener);

		three = new JButton("3");
		c.gridx = 2;
		c.gridy = 3;
		three.setFont(BUTTON_FONT);
		three.setMinimumSize(BTN_MIN_SIZE);
		container.add(three, c);
		three.addActionListener(listener);

		four = new JButton("4");
		c.gridx = 0;
		c.gridy = 2;
		four.setFont(BUTTON_FONT);
		four.setMinimumSize(BTN_MIN_SIZE);
		container.add(four, c);
		four.addActionListener(listener);

		five = new JButton("5");
		c.gridx = 1;
		c.gridy = 2;
		five.setFont(BUTTON_FONT);
		five.setMinimumSize(BTN_MIN_SIZE);
		container.add(five, c);
		five.addActionListener(listener);

		six = new JButton("6");
		c.gridx = 2;
		c.gridy = 2;
		six.setFont(BUTTON_FONT);
		six.setMinimumSize(BTN_MIN_SIZE);
		container.add(six, c);
		six.addActionListener(listener);

		seven = new JButton("7");
		c.gridx = 0;
		c.gridy = 1;
		seven.setFont(BUTTON_FONT);
		seven.setMinimumSize(BTN_MIN_SIZE);
		container.add(seven, c);
		seven.addActionListener(listener);

		eight = new JButton("8");
		c.gridx = 1;
		c.gridy = 1;
		eight.setFont(BUTTON_FONT);
		eight.setMinimumSize(BTN_MIN_SIZE);
		container.add(eight, c);
		eight.addActionListener(listener);

		nine = new JButton("9");
		c.gridx = 2;
		c.gridy = 1;
		nine.setFont(BUTTON_FONT);
		nine.setMinimumSize(BTN_MIN_SIZE);
		container.add(nine, c);
		nine.addActionListener(listener);

		decimalSeparator = new JButton(".");
		c.gridx = 1;
		c.gridy = 4;
		decimalSeparator.setFont(BUTTON_FONT);
		decimalSeparator.setMinimumSize(BTN_MIN_SIZE);
		container.add(decimalSeparator, c);
		decimalSeparator.addActionListener(listener);

		negation = new JButton("+/-");
		c.gridx = 2;
		c.gridy = 4;
		negation.setFont(BUTTON_FONT);
		negation.setMinimumSize(BTN_MIN_SIZE);
		container.add(negation, c);
		negation.addActionListener(listener);

		clear = new JButton("C");
		c.gridx = 4;
		c.gridy = 0;
		clear.setFont(BUTTON_FONT);
		clear.setMinimumSize(BTN_MIN_SIZE);
		container.add(clear, c);
		clear.addActionListener(listener);

		division = new JButton("/");
		c.gridx = 3;
		c.gridy = 1;
		division.setFont(BUTTON_FONT);
		division.setMinimumSize(BTN_MIN_SIZE);
		container.add(division, c);
		division.addActionListener(listener);

		multiplication = new JButton("*");
		c.gridx = 3;
		c.gridy = 2;
		multiplication.setFont(BUTTON_FONT);
		multiplication.setMinimumSize(BTN_MIN_SIZE);
		container.add(multiplication, c);
		multiplication.addActionListener(listener);

		subtraction = new JButton("-");
		c.gridx = 3;
		c.gridy = 3;
		subtraction.setFont(BUTTON_FONT);
		subtraction.setMinimumSize(BTN_MIN_SIZE);
		container.add(subtraction, c);
		subtraction.addActionListener(listener);

		addition = new JButton("+");
		c.gridx = 3;
		c.gridy = 4;
		addition.setFont(BUTTON_FONT);
		addition.setMinimumSize(BTN_MIN_SIZE);
		container.add(addition, c);
		addition.addActionListener(listener);

		squareRoot = new JButton("sqrt");
		c.gridx = 4;
		c.gridy = 1;
		squareRoot.setFont(BUTTON_FONT);
		squareRoot.setMinimumSize(BTN_MIN_SIZE);
		container.add(squareRoot, c);
		squareRoot.addActionListener(listener);

		percent = new JButton("%");
		c.gridx = 4;
		c.gridy = 2;
		percent.setFont(BUTTON_FONT);
		percent.setMinimumSize(BTN_MIN_SIZE);
		container.add(percent, c);
		percent.addActionListener(listener);

		equalsSign = new JButton("=");
		c.gridheight = 2;
		c.gridx = 4;
		c.gridy = 3;
		equalsSign.setFont(BUTTON_FONT);
		equalsSign.setMinimumSize(new Dimension(60, 120));
		equalsSign.setMaximumSize(new Dimension(160, 320));
		container.add(equalsSign, c);
		equalsSign.addActionListener(listener);

	}

	private void disableEnteringNonDigitCharacters()
	{
		txtField.addKeyListener(new KeyAdapter()
		{
			public void keyTyped(KeyEvent e)
			{
				if (!Character.isDigit(e.getKeyChar()))
					e.consume();
			}
		});
	}

	public void disableDecimalSeparator()
	{
		decimalSeparator.setEnabled(false);
	}

	public void enableDecimalSeparator()
	{
		decimalSeparator.setEnabled(true);
	}

	public void disableControls()
	{
		txtField.setEnabled(false);
		one.setEnabled(false);
		two.setEnabled(false);
		three.setEnabled(false);
		four.setEnabled(false);
		five.setEnabled(false);
		six.setEnabled(false);
		seven.setEnabled(false);
		eight.setEnabled(false);
		nine.setEnabled(false);
		zero.setEnabled(false);
		addition.setEnabled(false);
		subtraction.setEnabled(false);
		multiplication.setEnabled(false);
		division.setEnabled(false);
		squareRoot.setEnabled(false);
		negation.setEnabled(false);
		percent.setEnabled(false);
		decimalSeparator.setEnabled(false);
		equalsSign.setEnabled(false);
	}

	public void enableControls()
	{
		txtField.setEnabled(true);
		one.setEnabled(true);
		two.setEnabled(true);
		three.setEnabled(true);
		four.setEnabled(true);
		five.setEnabled(true);
		six.setEnabled(true);
		seven.setEnabled(true);
		eight.setEnabled(true);
		nine.setEnabled(true);
		zero.setEnabled(true);
		addition.setEnabled(true);
		subtraction.setEnabled(true);
		multiplication.setEnabled(true);
		division.setEnabled(true);
		squareRoot.setEnabled(true);
		negation.setEnabled(true);
		percent.setEnabled(true);
		decimalSeparator.setEnabled(true);
		equalsSign.setEnabled(true);
	}

	public void disableOperations()
	{
		addition.setEnabled(false);
		subtraction.setEnabled(false);
		multiplication.setEnabled(false);
		division.setEnabled(false);
		squareRoot.setEnabled(false);
		percent.setEnabled(false);
	}

	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			@Override
			public void run()
			{
				CalculatorInterface calc = new CalculatorInterface();
			}
		});
	}
}
