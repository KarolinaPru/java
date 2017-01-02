package application;

import java.util.ArrayList;
import java.util.Optional;
import java.util.regex.Pattern;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.util.converter.DoubleStringConverter;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurve;
import javafx.scene.shape.QuadCurveTo;

public class GUI extends Application
{
	private int stageWidth = 800;
	private int stageHeight = 960;
	private int canvasHeight = 800;

	private Group root;

	CurveDrawingLogic logic;
	private double centralPointX;
	private double centralPointY;
	private Point2D centralPoint;
	public Canvas canvas;
	public TextField txtA;
	public TextField txtB;

	@Override
	public void start(Stage primaryStage)
	{
		try
		{
			renderUserInterface(primaryStage);

		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	private void renderUserInterface(Stage primaryStage)
	{
		root = new Group();
		Scene scene = new Scene(root, stageWidth, stageHeight);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

		canvas = new Canvas(stageWidth, canvasHeight);

		GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.setFill(Color.web("#EAFAF1"));
		gc.fillRect(canvas.getLayoutX(), canvas.getLayoutY(), stageWidth, canvasHeight);

		canvas.boundsInParentProperty();
		root.getChildren().add(canvas);

		centralPointX = stageWidth / 2;
		centralPointY = canvasHeight / 2;

		drawAxisX();
		drawAxisY();

		drawScaleOnAxisX();
		drawScaleOnAxisY();

		Label labelA = new Label("Enter A: ");
		labelA.setMinWidth(100);
		labelA.setAlignment(Pos.BOTTOM_RIGHT);
		Label labelB = new Label("Enter B: ");
		labelB.setMinWidth(100);
		labelB.setAlignment(Pos.BOTTOM_RIGHT);

		txtA = new TextField();
		txtA.setMaxWidth(80);
		txtB = new TextField();
		txtB.setMaxWidth(80);

		Pattern validDoubleText = Pattern.compile("-?((\\d*)|(\\d+\\.\\d*))");

		TextFormatter<Double> textFormatterA = new TextFormatter<Double>(new DoubleStringConverter(), 0.0, change ->
		{
			String textA = change.getControlNewText();
			if (validDoubleText.matcher(textA).matches())
			{
				return change;
			} else
				return null;
		});

		TextFormatter<Double> textFormatterB = new TextFormatter<Double>(new DoubleStringConverter(), 0.0, change ->
		{
			String textB = change.getControlNewText();
			if (validDoubleText.matcher(textB).matches())
			{
				
				return change;
			} else
				return null;
		});

		txtA.setTextFormatter(textFormatterA);
		txtB.setTextFormatter(textFormatterB);

		// TODO: Delete or use in a different way
		textFormatterA.valueProperty().addListener((obs, oldValue, newValue) ->
		{
			System.out.println("New double value " + newValue);
		});

		Label lblFunction = new Label("f(x) = ax^2 + b");
		lblFunction.setMinWidth(120);
		lblFunction.setTranslateX(250);

		Button drawButton = new Button("Draw");
		drawButton.setMinWidth(100);
		drawButton.setTranslateX(250);
		drawButton.setOnAction(handleDrawClick());

		HBox a = new HBox(10, labelA, txtA, lblFunction);
		a.setPadding(new Insets(10));
		HBox b = new HBox(10, labelB, txtB, drawButton);
		b.setPadding(new Insets(10));

		VBox bottomControls = new VBox(10, a, b);
		bottomControls.setAlignment(Pos.BOTTOM_CENTER);

		root.getChildren().add(bottomControls);
		bottomControls.setLayoutY(810);

		// TODO:
		// Doda� tooltipy pokazuj�ce wsp�rz�dne x y na paraboli
		// TODO
		// doda� s�uchaczy zdarze� to p�l tekstowych i guzika
		// TODO
		// slider? co�, �eby m�c porzerzy� wykres w razie potrzeby

		primaryStage.setScene(scene);
		primaryStage.setTitle("Quadratic function drawing tool");
		primaryStage.setWidth(stageWidth);
		primaryStage.setHeight(stageHeight);
		primaryStage.setResizable(false);
		primaryStage.show();
	}

	private EventHandler<ActionEvent> handleDrawClick()
	{
		return event ->
		{
			logic = new CurveDrawingLogic(txtA.getText(), txtB.getText());
			ArrayList<Coordinate> coordinates = logic.calculateCoordinatesOfQuadFunc();

			checkIfThereAreAtLeast2PointsAndJoinThem(coordinates);

			centralPoint = new Point2D(centralPointX, centralPointY);

			Path path = new Path();

			// A starting point
			// Creates an addition to the path by moving to the specified
			// coordinates.
			MoveTo moveTo = new MoveTo();
			moveTo.setX(0);
			moveTo.setY(0);

			// Bezier curve
			QuadCurveTo quadFunction = new QuadCurveTo();
			quadFunction.setControlX(300);
			quadFunction.setControlY(300);
			quadFunction.setX(400);
			quadFunction.setY(0);

			path.getElements().add(moveTo);
			path.getElements().add(quadFunction);

			root.getChildren().add(path);

			path.setTranslateX(centralPointX + 20);
			path.setTranslateY(centralPointY + 20);
		};
	}

	private void checkIfThereAreAtLeast2PointsAndJoinThem(ArrayList<Coordinate> coordinates)
	{
		if (coordinates.size() >= 2)
		{
			for (int i = 0; i < coordinates.size(); i++)
			{
				Coordinate currentPoint = coordinates.get(i);

				checkIfNextPointIsPresent(coordinates, i, currentPoint);
			}
		}
	}

	private void checkIfNextPointIsPresent(ArrayList<Coordinate> coordinates, int i, Coordinate currentPoint)
	{
		if (coordinates.size() > i + 1)
		{
			Coordinate nextPoint = coordinates.get(i + 1);

			drawALineBetween2Points(currentPoint, nextPoint);
		}
	}

	private void drawALineBetween2Points(Coordinate currentPoint, Coordinate nextPoint)
	{
		Line l = new Line(
				translateXToPixelPosition(currentPoint.getX()),
				translateYToPixelPosition(currentPoint.getY()),
				translateXToPixelPosition(nextPoint.getX()),
				translateYToPixelPosition(nextPoint.getY()));
		
		root.getChildren().add(l);
	}

	private double translateXToPixelPosition(double x) {
		return centralPointX + (x * 10);
	}
	
	private double translateYToPixelPosition(double y) {
		return centralPointY - (y * 10);
	}
	
	private void drawAxisY()
	{
		Line axisY = new Line(centralPointX, canvas.getLayoutY(), centralPointX, canvas.getLayoutY() + canvasHeight);
		root.getChildren().add(axisY);
	}

	private void drawAxisX()
	{
		Line axisX = new Line(canvas.getLayoutX(), centralPointY, canvas.getLayoutX() + stageWidth, centralPointY);
		root.getChildren().add(axisX);
	}

	private void drawScaleOnAxisY()
	{
		for (int j = 0; j < canvasHeight; j += 10)
		{
			Line scaleAxisY = new Line(centralPointX - 3, j, centralPointX + 3, j);
			scaleAxisY.setStrokeWidth(0.5);

			root.getChildren().add(scaleAxisY);
		}
	}

	private void drawScaleOnAxisX()
	{
		for (int i = 0; i < stageWidth; i += 10)
		{
			Line scaleAxisX = new Line(i, centralPointY - 3, i, centralPointY + 3);
			scaleAxisX.setStrokeWidth(0.5);

			root.getChildren().add(scaleAxisX);
		}
	}

	public static void main(String[] args)
	{
		launch(args);
	}
}
