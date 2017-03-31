package application;

import java.util.ArrayList;

public class CurveDrawingLogic
{
	private double a;
	private double b;
	private double c;
	private double y;
	private double x;
	private GUI gui;

	public CurveDrawingLogic(String textA, String textB)
	{
		a = Double.parseDouble(textA);
		c = Double.parseDouble(textB);
	}

	public ArrayList<Coordinate> calculateCoordinatesOfQuadFunc()
	{
		ArrayList<Coordinate> coordinates = new ArrayList<Coordinate>();

		gui = new GUI();
		double maxXOnScale = gui.canvasWidth / 2 / 10;
		double minXOnScale = maxXOnScale * (-1);

		for (x = minXOnScale; x <= maxXOnScale; x += 0.01)
		{
			b = 0;
			y = a * x * x + x * b + c;

		coordinates.add(new Coordinate(x, y));
		}
		
		return coordinates;
	}
}