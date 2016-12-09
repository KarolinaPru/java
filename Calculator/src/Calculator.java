
public class Calculator
{
	private char operator;
	private double x;
	private double y;
	private double result;
	private String strResult;
		
		public String calculate (String input)
	{
		return null;
	}
	
	private String performOperation(char operator, double x, double y)
	{
		this.operator = operator;
		this.x = x;
		this.y = y;
//		
//		if (operator == Operation.ADDITION.returnOperator())
//		{
//			{
//				result = x + y;
//			}
//		}
//		if (operator == Operation.SUBTRACTION.returnOperator())
//		{
//			result = x - y;
//		}
//		
//		if (operator == Operation.MULTIPLICATION.returnOperator())
//		{
//			result = x * y;
//
//		}
//		
//		if (operator == Operation.DIVISION.returnOperator())
//		{
//			result = x / y;
//		}
//		
//		if (operator == Operation.PERCENTAGE.returnOperator())
//		{
//				result = x / 100 * y;			
//		}
//		
//		if (operator == Operation.SQUARE_ROOT.returnOperator())
//		{
//			result = Math.sqrt(x);
//		}
		
		strResult = String.valueOf(result);
		return strResult;
}
	
	public void unitTest(char operator, double x, double y, double expectedOutcome)
	{
		Calculator c = new Calculator();
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
		Calculator c = new Calculator();
		c.unitTest('-', 23.33, 33.33, -10);
		c.unitTest('/', 100, 5, 20);
		c.unitTest('*', -100, 50, -5000);
		c.unitTest('%', 25, 200, 50);
		c.unitTest('√', 9, 0, 3);
	}
}

