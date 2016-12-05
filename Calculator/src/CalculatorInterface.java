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
	final static Dimension BTN_MAX_SIZE = new Dimension(160, 160);
	final static Dimension BTN_MIN_SIZE = new Dimension(60, 60);
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
	private JButton subtraction;
	private JButton addition;
	private JButton squareRoot;
	private JButton percent;
	private JButton equalsSign;
	private JButton decimalSeparator;
	private JButton negation;

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
		calculationField.setFont(new Font("Tahoma", Font.PLAIN, 24));
		calculationField.setHorizontalAlignment(SwingConstants.RIGHT);
		container.add(calculationField, c);
		
		disableEnteringNonDigitCharacters();

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
		one.addActionListener(this);

		two = new JButton("2");
		c.gridx = 1;
		c.gridy = 3;
		two.setFont(BUTTON_FONT);
		two.setMinimumSize(BTN_MIN_SIZE);
		two.setMaximumSize(BTN_MAX_SIZE);
		container.add(two, c);
		two.addActionListener(this);

		three = new JButton("3");
		c.gridx = 2;
		c.gridy = 3;
		three.setFont(BUTTON_FONT);
		three.setMinimumSize(BTN_MIN_SIZE);
		three.setMaximumSize(BTN_MAX_SIZE);
		container.add(three, c);
		three.addActionListener(this);

		four = new JButton("4");
		c.gridx = 0;
		c.gridy = 2;
		four.setFont(BUTTON_FONT);
		four.setMinimumSize(BTN_MIN_SIZE);
		four.setMaximumSize(BTN_MAX_SIZE);
		container.add(four, c);
		four.addActionListener(this);

		five = new JButton("5");
		c.gridx = 1;
		c.gridy = 2;
		five.setFont(BUTTON_FONT);
		five.setMinimumSize(BTN_MIN_SIZE);
		five.setMaximumSize(BTN_MAX_SIZE);
		container.add(five, c);
		five.addActionListener(this);

		six = new JButton("6");
		c.gridx = 2;
		c.gridy = 2;
		six.setFont(BUTTON_FONT);
		six.setMinimumSize(BTN_MIN_SIZE);
		six.setMaximumSize(BTN_MAX_SIZE);
		container.add(six, c);
		six.addActionListener(this);

		seven = new JButton("7");
		c.gridx = 0;
		c.gridy = 1;
		seven.setFont(BUTTON_FONT);
		seven.setMinimumSize(BTN_MIN_SIZE);
		seven.setMaximumSize(BTN_MAX_SIZE);
		container.add(seven, c);
		seven.addActionListener(this);

		eight = new JButton("8");
		c.gridx = 1;
		c.gridy = 1;
		eight.setFont(BUTTON_FONT);
		eight.setMinimumSize(BTN_MIN_SIZE);
		eight.setMaximumSize(BTN_MAX_SIZE);
		container.add(eight, c);
		eight.addActionListener(this);

		nine = new JButton("9");
		c.gridx = 2;
		c.gridy = 1;
		nine.setFont(BUTTON_FONT);
		nine.setMinimumSize(BTN_MIN_SIZE);
		nine.setMaximumSize(BTN_MAX_SIZE);
		container.add(nine, c);
		nine.addActionListener(this);

		decimalSeparator = new JButton(".");
		c.gridx = 1;
		c.gridy = 4;
		decimalSeparator.setFont(BUTTON_FONT);
		decimalSeparator.setMinimumSize(BTN_MIN_SIZE);
		decimalSeparator.setMaximumSize(BTN_MAX_SIZE);
		container.add(decimalSeparator, c);
		decimalSeparator.addActionListener(this);

		negation = new JButton("+/-");
		c.gridx = 2;
		c.gridy = 4;
		negation.setFont(BUTTON_FONT);
		negation.setMinimumSize(BTN_MIN_SIZE);
		negation.setMaximumSize(BTN_MAX_SIZE);
		container.add(negation, c);
		negation.addActionListener(this);

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
		calculationField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                if (!Character.isDigit(e.getKeyChar()))
                    e.consume();
            }
        });
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		String enteredText = calculationField.getText();
		if (e.getSource() == one)
		{
			calculationField.setText(enteredText + "1");
		}

		if (e.getSource() == two)
		{
			calculationField.setText(enteredText + "2");
		}

		if (e.getSource() == three)
		{
			calculationField.setText(enteredText + "3");
		}

		if (e.getSource() == four)
		{
			calculationField.setText(enteredText + "4");
		}

		if (e.getSource() == five)
		{
			calculationField.setText(enteredText + "5");
		}

		if (e.getSource() == six)
		{

			calculationField.setText(enteredText + "6");
		}

		if (e.getSource() == seven)

		{
			calculationField.setText(enteredText + "7");
		}
		
		if (e.getSource() == eight)
		{
			calculationField.setText(enteredText + "8");
		}
		
		if (e.getSource() == nine)
		{
			calculationField.setText(enteredText + "9");
		}
		
		if (e.getSource() == zero)
		{
			calculationField.setText(enteredText + "0");
		}
		
		if (e.getSource() == decimalSeparator)
		{
			calculationField.setText(enteredText + ",");
		}
		
		boolean clicked = false;
		if (e.getSource() == negation)
		{		
			clicked = !clicked;
			if (clicked)
			{
				calculationField.setText("-" + enteredText);
				clicked = !clicked;	
			}
		}
		
		if (e.getSource() == clear)
		{
			calculationField.setText("");
		}

		if (e.getSource() == addition)
		{
			calculationField.setText(enteredText + "+");
			// add();
		}

		if (e.getSource() == subtraction)
		{
			calculationField.setText(enteredText + "-");		
			// subtract();
		}

		if (e.getSource() == multiplication)
		{
			calculationField.setText(enteredText + "*");
			// multiply();
		}

		if (e.getSource() == division)
		{
			calculationField.setText(enteredText + "/");
			// divide();
		}

		if (e.getSource() == percent)
		{
			calculationField.setText(enteredText + "%");
			// calculatePercent();
		}

		if (e.getSource() == squareRoot)
		{
			calculationField.setText("√" + enteredText);
			// calculateSquareRoot();
		}
	}

	private void disableControls() 
	{
		boolean disable = false;
		
		calculationField.setEnabled(disable);
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
	
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{

			@Override
			public void run()
			{
				CalculatorInterface calc = new CalculatorInterface();
				calc.createInterface();
				
				// Testing if disableControls() works
				//calc.disableControls();
				
			}

		});
	}
}
