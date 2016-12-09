
public enum Operation
{
	
	ADDITION ('+'),
	SUBTRACTION ('-'),
	MULTIPLICATION('*'),
	DIVISION ('/'),
	PERCENTAGE ('%'),
	SQUARE_ROOT ('√');
	
	private char operator;
	
	private Operation(char operator)
	{
		this.operator = operator;
	}
	
	public char returnOperator()
	{
		return operator;
	}
}


