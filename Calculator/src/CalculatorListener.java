import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CalculatorListener implements ActionListener
{
	private int currentNumber = 0;
	private ArrayList<String> numbers = new ArrayList<String>();
	private Operation operation;
	private String enteredText;

	private CalculatorInterface calcInterface;
	private InputValidator validator;
	private Calculator calc;

	public CalculatorListener(CalculatorInterface calcInterface)
	{
		this.calcInterface = calcInterface;
		this.validator = new InputValidator();
		this.calc = new Calculator();
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		enteredText = calcInterface.txtField.getText();

		if (e.getSource() == calcInterface.one)
		{
			if (validator.isValidNumber("1"))
				calcInterface.txtField.setText(enteredText + "1");
		}

		if (e.getSource() == calcInterface.two)
		{
			if (validator.isValidNumber("2"))
				calcInterface.txtField.setText(enteredText + "2");
		}

		if (e.getSource() == calcInterface.three)
		{
			if (validator.isValidNumber("3"))
				calcInterface.txtField.setText(enteredText + "3");
		}

		if (e.getSource() == calcInterface.four)
		{
			if (validator.isValidNumber("4"))
				calcInterface.txtField.setText(enteredText + "4");
		}

		if (e.getSource() == calcInterface.five)
		{
			if (validator.isValidNumber("5"))
				calcInterface.txtField.setText(enteredText + "5");
		}

		if (e.getSource() == calcInterface.six)
		{
			if (validator.isValidNumber("6"))
				calcInterface.txtField.setText(enteredText + "6");
		}

		if (e.getSource() == calcInterface.seven)
		{
			if (validator.isValidNumber("7"))
				calcInterface.txtField.setText(enteredText + "7");
		}

		if (e.getSource() == calcInterface.eight)
		{
			if (validator.isValidNumber("8"))
				calcInterface.txtField.setText(enteredText + "8");
		}

		if (e.getSource() == calcInterface.nine)
		{
			if (validator.isValidNumber("9"))
				calcInterface.txtField.setText(enteredText + "9");
		}
		if (e.getSource() == calcInterface.zero)
		{
			if (validator.isValidNumber("0"))
				calcInterface.txtField.setText(enteredText + "0");
		}

		if (e.getSource() == calcInterface.decimalSeparator)
		{
			if (validator.isValidNumber("."))
			{
				calcInterface.txtField.setText(enteredText + ".");
				calcInterface.disableDecimalSeparator();
			}
		}

		if (e.getSource() == calcInterface.negation)
		{
			// char firstChar = enteredText.charAt(0);
			// if (Character.isDigit(firstChar))
			// {
			// calcInterface.txtField.setText("-" + enteredText);
			// }
			//
			// else if (Character.valueOf(firstChar) == '-')
			// {
			// enteredText = enteredText.replace(firstChar, '+');
			// calcInterface.txtField.setText(enteredText);
			// } else if (Character.valueOf(firstChar) == '+')
			// {
			// enteredText = enteredText.replace(firstChar, '-');
			// calcInterface.txtField.setText(enteredText);
			// }
		}

		if (e.getSource() == calcInterface.clear)
		{
			clearState();
		}

		if (e.getSource() == calcInterface.addition)
		{
			handleOperationClick(Operation.ADD, "+");
		}
		if (e.getSource() == calcInterface.subtraction)
		{
			handleOperationClick(Operation.SUBTRACT, "-");
		}

		if (e.getSource() == calcInterface.multiplication)
		{
			handleOperationClick(Operation.MULTIPLY, "*");
		}

		if (e.getSource() == calcInterface.division)
		{
			handleOperationClick(Operation.DIVIDE, "/");
		}

		if (e.getSource() == calcInterface.percent)
		{
			handleOperationClick(Operation.PERCENT, "%");
		}

		if (e.getSource() == calcInterface.squareRoot)
		{
			// TODO: special case - think how to handle squareRoot
			// handleOperationClick(Operation.SQUARE_ROOT, "√");
			// calcInterface.txtField.setText("√" + enteredText);
		}

		if (e.getSource() == calcInterface.equalsSign)
		{
			numbers.add(validator.lastValidInput);
			
			if (numbers.size() < 2)
			{
				return;
			}

			double firstNumber = Double.parseDouble(numbers.get(0));
			double secondNumber = Double.parseDouble(numbers.get(1));
			String result;
			switch (operation)
			{
			case ADD:
				result = String.valueOf(firstNumber + secondNumber);
				calcInterface.txtField.setText(result);
				// TODO: clear numbers add result to numbers (first position)
				break;
			case SUBTRACT:
				result = String.valueOf(firstNumber - secondNumber);
				calcInterface.txtField.setText(result);
				break;
			case MULTIPLY:
				result = String.valueOf(firstNumber * secondNumber);
				calcInterface.txtField.setText(result);
				break;
			case DIVIDE:
				result = String.valueOf(firstNumber / secondNumber);
				calcInterface.txtField.setText(result);
				break;
			case PERCENT:
				result = String.valueOf(firstNumber / 100 * secondNumber);
				calcInterface.txtField.setText(result);
				break;
			}
		}
	}

	private void handleOperationClick(Operation operation, String symbol)
	{
		numbers.add(validator.lastValidInput);
		switchToNextNumber();
		this.operation = operation;
		calcInterface.txtField.setText(enteredText + symbol);
		validator.clear();
		calcInterface.enableDecimalSeparator();
		calcInterface.disableOperations();
	}

	private void switchToNextNumber()
	{
		currentNumber += 1;
	}

	private void clearState()
	{
		validator.clear();
		numbers.clear();
		currentNumber = 0;
		calcInterface.txtField.setText("");
		calcInterface.enableControls();
	}
}
