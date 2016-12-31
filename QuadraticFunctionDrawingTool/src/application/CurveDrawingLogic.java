package application;

public class CurveDrawingLogic
{
	private double a;
	private double b;
	private double c;
	private static double root1;
	private static double root2;
	private static double discriminant;
	GUI gui = new GUI();
	private String textA = gui.txtA.getText();
	private String textB = gui.txtB.getText();

	public static void main(String[] args)
	{
		
	}
	
	public boolean validateInput(String enteredText)
	{
		if (enteredText.isEmpty())
		{
			return false;
		}
		
		if (!enteredText.isEmpty() && enteredText.matches("^\\-?\\d*\\.?\\d*$"))
		{
			return true;
		}
		
		return false;
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
	

	
	

