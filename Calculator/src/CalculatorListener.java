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

	public CalculatorListener(CalculatorInterface calcInterface)
	{
		this.calcInterface = calcInterface;
		this.validator = new InputValidator();
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
			if (validator.lastValidInput.startsWith("-"))
			{
				StringBuilder numberNegation = new StringBuilder();
				numberNegation.append(validator.lastValidInput);
				numberNegation.replace(0, 1, "");
				validator.lastValidInput = numberNegation.toString();
			} else
			{
				validator.lastValidInput = "-" + validator.lastValidInput;
			}
			System.out.println("negation: " + validator.lastValidInput);
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
			if (validator.lastValidInput.isEmpty())
			{
				return;
			}

			double number = Double.parseDouble(validator.lastValidInput);
			String result = String.valueOf(Math.sqrt(number));

			calcInterface.txtField.setText(result);
			numbers.clear();
			validator.lastValidInput = result;
		}

		if (e.getSource() == calcInterface.equalsSign)
		{
			handleEquals();
		}
	}

	private void handleEquals()
	{
		if (validator.lastValidInput.isEmpty())
		{
			return;
		}

		addLastValidInputToNumbersList();

		if (numbers.size() < 2)
		{
			return;
		}

		System.out.println(numbers.get(0));
		double firstNumber = Double.parseDouble(numbers.get(0));
		double secondNumber = Double.parseDouble(numbers.get(1));
		String result = "";
		switch (operation)
		{
		case ADD:
			result = String.valueOf(firstNumber + secondNumber);
			calcInterface.txtField.setText(result);
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

	private void addLastValidInputToNumbersList()
	{
		numbers.add(validator.lastValidInput);
	}

	private void handleOperationClick(Operation operation, String symbol)
	{
		if (validator.lastValidInput.isEmpty())
		{
			return;
		}
		addLastValidInputToNumbersList();
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
