package application;

public class CurveDrawingLogic
{
	private double a;
	private double b;
	private double c;
	private double root1;
	private double root2;
	private double discriminant;
	private String textA;
	private String textB;

	public CurveDrawingLogic(String textA, String textB)
	{
		this.textA = textA;
		this.textB = textB;
	}
	
	private double calculateDiscriminant(double a, double c)
	{
		this.a = a;
		this.c = c;
		b = 0;
		
		discriminant = b*b - 4*a*c;
		
		return discriminant;
	}
	
	
	public void findRootPoints(double a, double b) {
		this.a = a;
		this.b = b;

		if (discriminant > 0)
		{
			root1 = (-b - Math.sqrt(discriminant)) / (2*a);
			root2 = (-b + Math.sqrt(discriminant)) / (2*a);
		}	
	}
}
	

	
	

