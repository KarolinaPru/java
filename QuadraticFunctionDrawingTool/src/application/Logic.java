package application;

public class Logic
{
	private static double a;
	private static double b;
	private static double c;
	private static double root1;
	private static double root2;
	private static double discriminant;
	GUI gui = new GUI();
	private String textA = gui.txtA.getText();
	private String textB = gui.txtB.getText();

	public static void main(String[] args)
	{
		Logic logic = new Logic();
		discriminant = b*b - 4*a*c;
		a = Double.parseDouble(logic.textA);
		b = 0;
		c = Double.parseDouble(logic.textB);
		logic.findRootPoints(a, b);

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
	
	private boolean isDouble(String text)
	{
		try {
			Double.parseDouble(text);
			return true;
		} 
		catch (NumberFormatException e)
		{
			return false;
		}
		
	}
	

	
	
}
