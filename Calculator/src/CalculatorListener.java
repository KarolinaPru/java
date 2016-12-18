import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CalculatorListener implements ActionListener
{
	private ArrayList<String> numbers = new ArrayList<String>();
	private Operation operation = Operation.MULTIPLY;
	private String enteredText;

	private CalculatorInterface gui;
	private CalculatorLogic logic;

	public CalculatorListener(CalculatorInterface gui)
	{
		this.gui = gui;
		this.logic = new CalculatorLogic();
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		enteredText = gui.txtField.getText();

		if (e.getSource() == gui.one)
		{
			if (logic.validateIfIsNumberAndSaveAsLastValidInput("1"))
				gui.txtField.setText(enteredText + "1");
		}

		if (e.getSource() == gui.two)
		{
			if (logic.validateIfIsNumberAndSaveAsLastValidInput("2"))
				gui.txtField.setText(enteredText + "2");
		}

		if (e.getSource() == gui.three)
		{
			if (logic.validateIfIsNumberAndSaveAsLastValidInput("3"))
				gui.txtField.setText(enteredText + "3");
		}

		if (e.getSource() == gui.four)
		{
			if (logic.validateIfIsNumberAndSaveAsLastValidInput("4"))
				gui.txtField.setText(enteredText + "4");
		}

		if (e.getSource() == gui.five)
		{
			if (logic.validateIfIsNumberAndSaveAsLastValidInput("5"))
				gui.txtField.setText(enteredText + "5");
		}

		if (e.getSource() == gui.six)
		{
			if (logic.validateIfIsNumberAndSaveAsLastValidInput("6"))
				gui.txtField.setText(enteredText + "6");
		}

		if (e.getSource() == gui.seven)
		{
			if (logic.validateIfIsNumberAndSaveAsLastValidInput("7"))
				gui.txtField.setText(enteredText + "7");
		}

		if (e.getSource() == gui.eight)
		{
			if (logic.validateIfIsNumberAndSaveAsLastValidInput("8"))
				gui.txtField.setText(enteredText + "8");
		}

		if (e.getSource() == gui.nine)
		{
			if (logic.validateIfIsNumberAndSaveAsLastValidInput("9"))
				gui.txtField.setText(enteredText + "9");
		}
		if (e.getSource() == gui.zero)
		{
			if (logic.validateIfIsNumberAndSaveAsLastValidInput("0"))
				gui.txtField.setText(enteredText + "0");
		}

		if (e.getSource() == gui.decimalSeparator)
		{
			if (logic.validateIfIsNumberAndSaveAsLastValidInput("."))
			{
				gui.txtField.setText(enteredText + ".");
				gui.disableDecimalSeparator();
			}
		}

		if (e.getSource() == gui.negation)
		{
			logic.negateLastValidInput();

			gui.txtField.setText(logic.lastValidInput);

			if (numbers.size() == 1)
			{
				gui.txtField.setText(numbers.get(0) + getOperationSign() + logic.lastValidInput);
			}
		}

		if (e.getSource() == gui.clear)
		{
			clearState();
		}

		if (e.getSource() == gui.addition)
		{
			handleOperationClick(Operation.ADD, "+");
		}
		if (e.getSource() == gui.subtraction)
		{
			handleOperationClick(Operation.SUBTRACT, "-");
		}

		if (e.getSource() == gui.multiplication)
		{
			handleOperationClick(Operation.MULTIPLY, "*");
		}

		if (e.getSource() == gui.division)
		{
			handleOperationClick(Operation.DIVIDE, "/");
		}

		if (e.getSource() == gui.percent)
		{
			handleOperationClick(Operation.PERCENT, "%");
		}

		if (e.getSource() == gui.squareRoot)
		{
			if (logic.lastValidInput.isEmpty())
			{
				return;
			}

			double number = Double.parseDouble(logic.lastValidInput);
			String result = String.valueOf(Math.sqrt(number));

			gui.txtField.setText(result);
			numbers.clear();
			logic.lastValidInput = result;
		}

		if (e.getSource() == gui.equalsSign)
		{
			handleEquals();
		}
	}

	private String getOperationSign()
	{
		switch (operation)
		{
		case ADD:
			return "+";
		case SUBTRACT:
			return "-";
		case MULTIPLY:
			return "*";
		case DIVIDE:
			return "/";
		case PERCENT:
			return "%";
		}

		return "";
	}

	private void handleEquals()
	{
		if (logic.lastValidInput.isEmpty())
		{
			return;
		}

		addLastValidInputToNumbersList();

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
			gui.txtField.setText(result);
			break;
		case SUBTRACT:
			result = String.valueOf(firstNumber - secondNumber);
			gui.txtField.setText(result);
			break;
		case MULTIPLY:
			result = String.valueOf(firstNumber * secondNumber);
			gui.txtField.setText(result);
			break;
		case DIVIDE:
			result = String.valueOf(firstNumber / secondNumber);
			gui.txtField.setText(result);
			break;
		case PERCENT:
			result = String.valueOf(firstNumber / 100 * secondNumber);
			gui.txtField.setText(result);
			break;
		}

		numbers.clear();

		if (result.equals("NaN") || result.equals("Infinity"))
		{
			gui.txtField.setText("Error");
			gui.disableControls();
			numbers.clear();
			logic.clear();
		} else
		{
			logic.lastValidInput = result;
			gui.enableControls();
		}
	}

	private void addLastValidInputToNumbersList()
	{
		numbers.add(logic.lastValidInput);
	}

	private void handleOperationClick(Operation operation, String symbol)
	{
		if (logic.lastValidInput.isEmpty())
		{
			return;
		}
		addLastValidInputToNumbersList();
		this.operation = operation;
		gui.txtField.setText(enteredText + symbol);
		logic.clear();
		gui.enableDecimalSeparator();
		gui.disableOperations();
	}

	private void clearState()
	{
		logic.clear();
		numbers.clear();
		gui.txtField.setText("");
		gui.enableControls();
	}
}
