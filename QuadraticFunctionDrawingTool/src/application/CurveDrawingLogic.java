package application;

import java.util.ArrayList;

public class CurveDrawingLogic
{
	private double a;
	private double b;
	private double c;
	private double root1;
	private double root2;
	private double discriminant;

	public CurveDrawingLogic(String textA, String textB)
	{
		a = Double.parseDouble(textA);
		b = Double.parseDouble(textB);
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
	
	public ArrayList<Coordinate> calculateCoordinatesOfQuadFunc() {
		ArrayList<Coordinate> coordinates = new ArrayList<Coordinate>();
		
		// TODO: implement the 'real' logic of coordinates calculation
		coordinates.add(new Coordinate(0,0));
		coordinates.add(new Coordinate(1,1));
		coordinates.add(new Coordinate(2,1));
		coordinates.add(new Coordinate(4,0.5));
		
		return coordinates;
	}
	
}