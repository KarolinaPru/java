import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CalculatorListener implements ActionListener
{
	private ArrayList<String> numbers = new ArrayList<String>();
	private Operation operation = Operation.MULTIPLY;
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
			if (validator.validateIfIsNumberAndSaveAsLastValidInput("1"))
				calcInterface.txtField.setText(enteredText + "1");
		}

		if (e.getSource() == calcInterface.two)
		{
			if (validator.validateIfIsNumberAndSaveAsLastValidInput("2"))
				calcInterface.txtField.setText(enteredText + "2");
		}

		if (e.getSource() == calcInterface.three)
		{
			if (validator.validateIfIsNumberAndSaveAsLastValidInput("3"))
				calcInterface.txtField.setText(enteredText + "3");
		}

		if (e.getSource() == calcInterface.four)
		{
			if (validator.validateIfIsNumberAndSaveAsLastValidInput("4"))
				calcInterface.txtField.setText(enteredText + "4");
		}

		if (e.getSource() == calcInterface.five)
		{
			if (validator.validateIfIsNumberAndSaveAsLastValidInput("5"))
				calcInterface.txtField.setText(enteredText + "5");
		}

		if (e.getSource() == calcInterface.six)
		{
			if (validator.validateIfIsNumberAndSaveAsLastValidInput("6"))
				calcInterface.txtField.setText(enteredText + "6");
		}

		if (e.getSource() == calcInterface.seven)
		{
			if (validator.validateIfIsNumberAndSaveAsLastValidInput("7"))
				calcInterface.txtField.setText(enteredText + "7");
		}

		if (e.getSource() == calcInterface.eight)
		{
			if (validator.validateIfIsNumberAndSaveAsLastValidInput("8"))
				calcInterface.txtField.setText(enteredText + "8");
		}

		if (e.getSource() == calcInterface.nine)
		{
			if (validator.validateIfIsNumberAndSaveAsLastValidInput("9"))
				calcInterface.txtField.setText(enteredText + "9");
		}
		if (e.getSource() == calcInterface.zero)
		{
			if (validator.validateIfIsNumberAndSaveAsLastValidInput("0"))
				calcInterface.txtField.setText(enteredText + "0");
		}

		if (e.getSource() == calcInterface.decimalSeparator)
		{
			if (validator.validateIfIsNumberAndSaveAsLastValidInput("."))
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
			if (validator.lastValidInput.isEmpty())
			{
				return;
			}
			
			numbers.add(validator.lastValidInput);
			
			if (numbers.size() < 2)
			{
				return;
			}

			double firstNumber = Double.parseDouble(numbers.get(0));
			double secondNumber = Double.parseDouble(numbers.get(1));
			String result = "";
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
			
			numbers.clear();
			validator.lastValidInput = result;
			calcInterface.enableControls();
		}
	}

	private void handleOperationClick(Operation operation, String symbol)
	{
		if (validator.lastValidInput.isEmpty())
		{
			return;
		}
		numbers.add(validator.lastValidInput);
		this.operation = operation;
		calcInterface.txtField.setText(enteredText + symbol);
		validator.clear();
		calcInterface.enableDecimalSeparator();
		calcInterface.disableOperations();
	}

	private void clearState()
	{
		validator.clear();
		numbers.clear();
		calcInterface.txtField.setText("");
		calcInterface.enableControls();
	}
}
