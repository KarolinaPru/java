package application;

import java.util.ArrayList;

public class CurveDrawingLogic
{
	private double a;
	private double b;
	private double c;
	private double y;
	private double x;
	private double vertexY;
	private double root1;
	private double root2;
	private double discriminant;
	private GUI gui;

	public CurveDrawingLogic(String textA, String textB)
	{
		a = Double.parseDouble(textA);
		c = Double.parseDouble(textB);
	}

	private double calculateDiscriminant(double a, double c)
	{
		this.a = a;
		this.c = c;
		b = 0;

		discriminant = b * b - 4 * a * c;

		return discriminant;
	}

	// TODO: Finish or delete
	private void findRootPoints(double a, double b)
	{
		this.a = a;
		this.b = b;

		if (discriminant > 0)
		{
			root1 = (-b - Math.sqrt(discriminant)) / (2 * a);
			root2 = (-b + Math.sqrt(discriminant)) / (2 * a);
		}
	}

	private double findVertexY()
	{
		vertexY = (discriminant * (-1)) / (4 * a);
		return vertexY;
	}

	public ArrayList<Coordinate> calculateCoordinatesOfQuadFunc()
	{
		ArrayList<Coordinate> coordinates = new ArrayList<Coordinate>();

		gui = new GUI();
		double maxXOnScale = gui.canvasWidth / 2 / 10;
		double minXOnScale = maxXOnScale * (-1);

		
		
		for (x = minXOnScale; x <= maxXOnScale; x += 0.1)
		{
			b = 0;
			y = a * x * x + x * b + c;

		coordinates.add(new Coordinate(x, y));

		}

		return coordinates;
	}

}