
public enum Operation
{
	ADDITION
	{
		double apply(double x, double y)
		{
			return x + y;
		}
	},
	SUBTRACTION
	{
		double apply(double x, double y)
		{
			return x - y;
		}
	},
	MULTIPLICATION
	{
		double apply(double x, double y)
		{
			return x * y;
		}
	},
	DIVISION
	{
		double apply(double x, double y)
		{
			return x / y;
		}
	},
	PERCENTAGE
	{
		double apply(double x, double y)
		{
			return x/100 * y;
		}
	},
	SQUARE_ROOT
	{	
		//TODO: check if works
		double apply(double x, double y)
		{
			return Math.sqrt(x);
		}
	};
	
	public String calculate (Operation op, double x, double y)
	{
		return String.valueOf(op.apply(x, y));
	}

	abstract double apply(double x, double y);
	
}
