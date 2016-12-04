import java.awt.Container;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class CalculatorInterface
{
	final static double WEIGHT_X = 0.2;
	final static double WEIGHT_Y = 0.2;
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

	
	public void addComponentsToPane(Container pane)
	{

		pane.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.weightx = WEIGHT_X;
		c.weighty = WEIGHT_Y;
		c.ipadx = 50;
		c.ipady = 50;
		
		calculationField = new JTextField();
		c.gridwidth = 4;
		c.gridx = 0;
		c.gridy = 0;
		pane.add(calculationField, c);

		clear = new JButton("C");
		c.gridwidth = 1;
		c.gridx = 4;
		c.gridy = 0;
		pane.add(clear, c);

		seven = new JButton("7");
		c.gridx = 0;
		c.gridy = 1;
		pane.add(seven, c);

		eight = new JButton("8");
		c.gridx = 1;
		c.gridy = 1;
		pane.add(eight, c);

		nine = new JButton("9");
		c.gridx = 2;
		c.gridy = 1;
		pane.add(nine, c);

		four = new JButton("4");
		c.gridx = 0;
		c.gridy = 2;
		pane.add(four, c);

		five = new JButton("5");
		c.gridx = 1;
		c.gridy = 2;
		pane.add(five, c);

		six = new JButton("6");
		c.gridx = 2;
		c.gridy = 2;
		pane.add(six, c);

		one = new JButton("1");
		c.gridx = 0;
		c.gridy = 3;
		pane.add(one, c);

		two = new JButton("2");
		c.gridx = 1;
		c.gridy = 3;
		pane.add(two, c);

		three = new JButton("3");
		c.gridx = 2;
		c.gridy = 3;
		pane.add(three, c);

		zero = new JButton("0");
		c.gridx = 0;
		c.gridy = 4;
		pane.add(zero, c);
		
		decimalSeparator = new JButton(".");
		c.gridx = 1;
		c.gridy = 4;
		pane.add(decimalSeparator, c);
				
		plusMinusSign = new JButton("+/-");
		c.gridx = 2;
		c.gridy = 4;
		pane.add(plusMinusSign, c);
		
		division = new JButton("/");
		c.gridx = 3;
		c.gridy = 1;
		pane.add(division, c);
		
		multiplication = new JButton("*");
		c.gridx = 3;
		c.gridy = 2;
		pane.add(multiplication, c);
		
		subtraction = new JButton("-");
		c.gridx = 3;
		c.gridy = 3;
		pane.add(subtraction, c);
		
		addition = new JButton("+");
		c.gridx = 3;
		c.gridy = 4;
		pane.add(addition, c);
		
		squareRoot = new JButton("sqrt");
		c.gridx = 4;
		c.gridy = 1;
		pane.add(squareRoot, c);	
		
		percent = new JButton("%");
		c.gridx = 4;
		c.gridy = 2;
		pane.add(percent, c);
		
		equals = new JButton("=");
		c.gridheight = 2;
		c.gridx = 4;
		c.gridy = 3;
		pane.add(equals, c);
		
	}

	public void createInterface()
	{
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		addComponentsToPane(frame.getContentPane());
		frame.pack();
		frame.setVisible(true);

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
