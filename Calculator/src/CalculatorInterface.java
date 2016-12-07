import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.EventObject;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class CalculatorInterface implements ActionListener
{
	final static double WEIGHT_X = 0.2;
	final static double WEIGHT_Y = 0.2;
	final static Dimension MAX_SIZE = new Dimension(1000, 1000);
	final static Dimension MIN_SIZE = new Dimension(300, 300);
//	final static Dimension BTN_MAX_SIZE = new Dimension(160, 160);
	final static Dimension BTN_MIN_SIZE = new Dimension(60, 60);
	final static Font BUTTON_FONT = new Font("Verdana", Font.BOLD, 18);
	private JTextField txtField;
	private String enteredText;
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
	private JButton subtraction;
	private JButton addition;
	private JButton squareRoot;
	private JButton percent;
	private JButton equalsSign;
	private JButton decimalSeparator;
	private JButton negation;
	private boolean isNegationClicked = false;
	private InputValidator validator = new InputValidator();
	private Calculator calc = new Calculator();

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
		container.add(zero, c);
		zero.addActionListener(this);

		one = new JButton("1");
		c.gridx = 0;
		c.gridy = 3;
		one.setFont(BUTTON_FONT);
		one.setMinimumSize(BTN_MIN_SIZE);
		container.add(one, c);
		one.addActionListener(this);

		two = new JButton("2");
		c.gridx = 1;
		c.gridy = 3;
		two.setFont(BUTTON_FONT);
		two.setMinimumSize(BTN_MIN_SIZE);
		container.add(two, c);
		two.addActionListener(this);

		three = new JButton("3");
		c.gridx = 2;
		c.gridy = 3;
		three.setFont(BUTTON_FONT);
		three.setMinimumSize(BTN_MIN_SIZE);
		container.add(three, c);
		three.addActionListener(this);

		four = new JButton("4");
		c.gridx = 0;
		c.gridy = 2;
		four.setFont(BUTTON_FONT);
		four.setMinimumSize(BTN_MIN_SIZE);
		container.add(four, c);
		four.addActionListener(this);

		five = new JButton("5");
		c.gridx = 1;
		c.gridy = 2;
		five.setFont(BUTTON_FONT);
		five.setMinimumSize(BTN_MIN_SIZE);
		container.add(five, c);
		five.addActionListener(this);

		six = new JButton("6");
		c.gridx = 2;
		c.gridy = 2;
		six.setFont(BUTTON_FONT);
		six.setMinimumSize(BTN_MIN_SIZE);
		container.add(six, c);
		six.addActionListener(this);

		seven = new JButton("7");
		c.gridx = 0;
		c.gridy = 1;
		seven.setFont(BUTTON_FONT);
		seven.setMinimumSize(BTN_MIN_SIZE);
		container.add(seven, c);
		seven.addActionListener(this);

		eight = new JButton("8");
		c.gridx = 1;
		c.gridy = 1;
		eight.setFont(BUTTON_FONT);
		eight.setMinimumSize(BTN_MIN_SIZE);
		container.add(eight, c);
		eight.addActionListener(this);

		nine = new JButton("9");
		c.gridx = 2;
		c.gridy = 1;
		nine.setFont(BUTTON_FONT);
		nine.setMinimumSize(BTN_MIN_SIZE);
		container.add(nine, c);
		nine.addActionListener(this);

		decimalSeparator = new JButton(".");
		c.gridx = 1;
		c.gridy = 4;
		decimalSeparator.setFont(BUTTON_FONT);
		decimalSeparator.setMinimumSize(BTN_MIN_SIZE);
		container.add(decimalSeparator, c);
		decimalSeparator.addActionListener(this);

		negation = new JButton("+/-");
		c.gridx = 2;
		c.gridy = 4;
		negation.setFont(BUTTON_FONT);
		negation.setMinimumSize(BTN_MIN_SIZE);
		container.add(negation, c);
		negation.addActionListener(this);

		clear = new JButton("C");
		c.gridx = 4;
		c.gridy = 0;
		clear.setFont(BUTTON_FONT);
		clear.setMinimumSize(BTN_MIN_SIZE);
		container.add(clear, c);
		clear.addActionListener(this);
		// TODO: zrób metodę enableControls()

		division = new JButton("/");
		c.gridx = 3;
		c.gridy = 1;
		division.setFont(BUTTON_FONT);
		division.setMinimumSize(BTN_MIN_SIZE);
		container.add(division, c);
		division.addActionListener(this);

		multiplication = new JButton("*");
		c.gridx = 3;
		c.gridy = 2;
		multiplication.setFont(BUTTON_FONT);
		multiplication.setMinimumSize(BTN_MIN_SIZE);
		container.add(multiplication, c);
		multiplication.addActionListener(this);

		subtraction = new JButton("-");
		c.gridx = 3;
		c.gridy = 3;
		subtraction.setFont(BUTTON_FONT);
		subtraction.setMinimumSize(BTN_MIN_SIZE);
		container.add(subtraction, c);
		subtraction.addActionListener(this);

		addition = new JButton("+");
		c.gridx = 3;
		c.gridy = 4;
		addition.setFont(BUTTON_FONT);
		addition.setMinimumSize(BTN_MIN_SIZE);
		container.add(addition, c);
		addition.addActionListener(this);

		squareRoot = new JButton("sqrt");
		c.gridx = 4;
		c.gridy = 1;
		squareRoot.setFont(BUTTON_FONT);
		squareRoot.setMinimumSize(BTN_MIN_SIZE);
		container.add(squareRoot, c);
		squareRoot.addActionListener(this);

		percent = new JButton("%");
		c.gridx = 4;
		c.gridy = 2;
		percent.setFont(BUTTON_FONT);
		percent.setMinimumSize(BTN_MIN_SIZE);
		container.add(percent, c);
		percent.addActionListener(this);

		equalsSign = new JButton("=");
		c.gridheight = 2;
		c.gridx = 4;
		c.gridy = 3;
		equalsSign.setFont(BUTTON_FONT);
		equalsSign.setMinimumSize(new Dimension(60, 120));
		equalsSign.setMaximumSize(new Dimension(160, 320));
		container.add(equalsSign, c);
		equalsSign.addActionListener(this);

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
		// Ta metoda niestety nie działa
		frame.setMaximumSize(MAX_SIZE);
		frame.pack();
		frame.setVisible(true);
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

	@Override
	public void actionPerformed(ActionEvent e)
	{
		enteredText = txtField.getText();

		if (e.getSource() == one)
		{
			if (validator.isValid("1"))
				txtField.setText(enteredText + "1");
		}

		if (e.getSource() == two)
		{
			if (validator.isValid("2"))
				txtField.setText(enteredText + "2");
		}

		if (e.getSource() == three)
		{
			if (validator.isValid("3"))
				txtField.setText(enteredText + "3");
		}

		if (e.getSource() == four)
		{
			if (validator.isValid("4"))
				txtField.setText(enteredText + "4");
		}

		if (e.getSource() == five)
		{
			if (validator.isValid("5"))
				txtField.setText(enteredText + "5");
		}

		if (e.getSource() == six)
		{
			if (validator.isValid("6"))
				txtField.setText(enteredText + "6");
		}

		if (e.getSource() == seven)
		{
			if (validator.isValid("7"))
				txtField.setText(enteredText + "7");
		}

		if (e.getSource() == eight)
		{
			if (validator.isValid("8"))
				txtField.setText(enteredText + "8");
		}

		if (e.getSource() == nine)
		{
			if (validator.isValid("9"))
				txtField.setText(enteredText + "9");
		}
		if (e.getSource() == zero)
		{
			if (validator.isValid("0"))
				txtField.setText(enteredText + "0");
		}

		if (e.getSource() == decimalSeparator)
		{
			if (validator.isValid(","))
				txtField.setText(enteredText + ",");
		}

		if (e.getSource() == negation)
		{
			if (isNegationClicked)
			{
				txtField.setText("-" + enteredText);

			} else
			{
				txtField.setText("" + enteredText);
			}
			isNegationClicked = !isNegationClicked;
		}

		if (e.getSource() == clear)
		{
			validator.clear();
			txtField.setText("");
		}

		if (e.getSource() == addition)
		{
			if (validator.isValid("+"))
				txtField.setText(enteredText + "+");
		}

		if (e.getSource() == subtraction)
		{
			if (validator.isValid("-"))
				txtField.setText(enteredText + "-");
		}

		if (e.getSource() == multiplication)
		{
			if (validator.isValid("*"))
				txtField.setText(enteredText + "*");
		}

		if (e.getSource() == division)
		{
			if (validator.isValid("/"))
				txtField.setText(enteredText + "/");
		}

		if (e.getSource() == percent)
		{
			if (validator.isValid("%"))
				txtField.setText(enteredText + "%");
		}

		if (e.getSource() == squareRoot)
		{
			if (validator.isValid("√"))
				txtField.setText("√" + enteredText);
		}
		
		if (e.getSource() == equalsSign)
		{
			String result = calc.calculate(enteredText);
			txtField.setText(result);
		}
	}

	private void disableControls()
	{
		boolean disable = false;

		txtField.setEnabled(disable);
		one.setEnabled(disable);
		two.setEnabled(disable);
		three.setEnabled(disable);
		four.setEnabled(disable);
		five.setEnabled(disable);
		six.setEnabled(disable);
		seven.setEnabled(disable);
		eight.setEnabled(disable);
		nine.setEnabled(disable);
		zero.setEnabled(disable);
		addition.setEnabled(disable);
		subtraction.setEnabled(disable);
		multiplication.setEnabled(disable);
		division.setEnabled(disable);
		squareRoot.setEnabled(disable);
		negation.setEnabled(disable);
		percent.setEnabled(disable);
		decimalSeparator.setEnabled(disable);
		equalsSign.setEnabled(disable);
	}

	public JTextField getTxtField()
	{
		return txtField;
	}

	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			@Override
			public void run()
			{
				CalculatorInterface calc = new CalculatorInterface();
				calc.createInterface();

				// TODO: Test calc.disableControls();
			}
		});
	}
}
