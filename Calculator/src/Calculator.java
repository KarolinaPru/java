import java.util.Optional;

public class Calculator
{
	private char operator;
	private double x;
	private double y;
	private double result;
	private String strResult;
	Calculator c;
		
	public String parse(String input)
	{
		double enteredOperation = Double.parseDouble(input);
		
		// 1. parse input, eg. "4+2323" -> [4, plus, 2323]
		// 2. calculate 4 + 2323
		// 3. convert result to String and return
		return "0";
	}
	
	public String performOperation(char operator, double x, double y)
	{
		this.operator = operator;
		this.x = x;
		this.y = y;
		
		if (operator == Operation.ADDITION.returnOperator())
		{
			{
				result = x + y;
			}
		}
		if (operator == Operation.SUBTRACTION.returnOperator())
		{
			result = x - y;
		}
		
		if (operator == Operation.MULTIPLICATION.returnOperator())
		{
			result = x * y;

		}
		
		if (operator == Operation.DIVISION.returnOperator())
		{
			result = x / y;
		}
		
		if (operator == Operation.PERCENTAGE.returnOperator())
		{
				result = x / 100 * y;			
		}
		
		if (operator == Operation.SQUARE_ROOT.returnOperator())
		{
			result = Math.sqrt(x);
		}
		
		strResult = String.valueOf(result);
		return strResult;
}
	
	public void unitTest(char operator, double x, double y, double expectedOutcome)
	{
		c = new Calculator();
		String test = c.performOperation(operator, x, y);
		System.out.print (operator + ":  " + x + ", " + y + " = " + expectedOutcome + ": ");
		
		if (String.valueOf(test).equals(String.valueOf(expectedOutcome)))
		{
			System.out.println("Test passed.");
		}
		else
		{
			System.out.println("Test failed");
		}
		
	}
	
	public static void main (String[] args)
	{
		Calculator calc = new Calculator();
		calc.unitTest('-', 23.33, 33.33, -10);
		calc.unitTest('/', 100, 5, 20);
		calc.unitTest('*', -100, 50, -5000);
		calc.unitTest('%', 25, 200, 50);
		calc.unitTest('√', 9, 0, 3);
	}
}

