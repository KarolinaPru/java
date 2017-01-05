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
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurve;
import javafx.scene.shape.QuadCurveTo;

public class GUI extends Application
{
	private double stageWidth = 800;
	private double stageHeight = 960;
	public double canvasHeight = 800;
	public double canvasWidth = 800;
	public double canvasLayoutY;

	private Group root;

	CurveDrawingLogic logic;
	private double centralPointX;
	private double centralPointY;
	public Canvas canvas;
	public TextField txtA;
	public TextField txtB;
	private LineTo line;
	private ArrayList<Coordinate> coordinates;
	private GraphicsContext gc;

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
		gc = canvas.getGraphicsContext2D();
		paintCanvas();
		root.getChildren().add(canvas);

		centralPointX = canvasWidth / 2;
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

		Label lblFunction = new Label("y = ax^2 + b");
		lblFunction.setMinWidth(120);
		lblFunction.setTranslateX(20);

		Button drawButton = new Button("Draw");
		drawButton.setMinWidth(100);
		drawButton.setTranslateX(20);
		drawButton.setOnAction(handleDrawClick());

		Button clearButton = new Button("Clear");
		clearButton.setMinWidth(100);
		clearButton.setTranslateX(20);
		clearButton.setOnAction(event ->
		{
			coordinates.clear();
			gc.clearRect(canvas.getLayoutX(), canvas.getLayoutY(), canvasWidth, canvasHeight);
			paintCanvas();	
			drawAxisX();
			drawAxisY();
		});

		HBox aHBox = new HBox(10, labelA, txtA, labelB, txtB, drawButton, clearButton);
		drawButton.setTranslateX(250);
		clearButton.setTranslateX(drawButton.getTranslateX() + 20);
		aHBox.setPadding(new Insets(5));
		HBox bHBox = new HBox(10, labelB, txtB, lblFunction);
		lblFunction.setTranslateX(250);
		bHBox.setPadding(new Insets(5));
		HBox buttonsHBox = new HBox(10);
		buttonsHBox.setPadding(new Insets(10));

		VBox controlsVBox = new VBox(10, aHBox, bHBox);

		root.getChildren().add(controlsVBox);
		controlsVBox.setLayoutY(canvasHeight + 20);

		// TODO:
		// Doda� tooltipy pokazuj�ce wsp�rz�dne x y na paraboli
		// TODO
		// doda� s�uchaczy zdarze� to p�l tekstowych i guzika
		// TODO
		// slider? co�, �eby m�c porzerzy� wykres w razie potrzeby

		primaryStage.setScene(scene);
		primaryStage.setTitle("Quadratic function drawing tool: f(x) = ax^2 + b");
		primaryStage.setWidth(stageWidth);
		primaryStage.setHeight(stageHeight);
		primaryStage.setResizable(false);
		primaryStage.show();
	}

	private void paintCanvas()
	{
		gc.setFill(Color.web("#EAFAF1"));
		gc.fillRect(canvas.getLayoutX(), canvas.getLayoutY(), canvasWidth, canvasHeight);
	}

	private EventHandler<ActionEvent> handleDrawClick()
	{
		return event ->
		{
			
			logic = new CurveDrawingLogic(txtA.getText(), txtB.getText());
			coordinates = logic.calculateCoordinatesOfQuadFunc();

			checkIfThereAreAtLeast2PointsAndJoinThem(coordinates);
			coordinates.clear();
			
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
		gc.strokeLine(translateXToPixelPosition(currentPoint.getX()), 
				translateYToPixelPosition(currentPoint.getY()),
				translateXToPixelPosition(nextPoint.getX()), 
				translateYToPixelPosition(nextPoint.getY()));
		gc.setLineWidth(1);
	}

	private double translateXToPixelPosition(double x)
	{
		return centralPointX + (x * 10);
	}

	private double translateYToPixelPosition(double y)
	{
		return centralPointY - (y * 10);
	}

	private void drawAxisY()
	{
		gc.strokeLine(centralPointX, canvas.getLayoutY(), centralPointX, canvas.getLayoutY() + canvasHeight);
		gc.setLineWidth(0.5);
		drawScaleOnAxisY();
	}

	private void drawAxisX()
	{
		gc.strokeLine(canvas.getLayoutX(), centralPointY, canvas.getLayoutX() + stageWidth, centralPointY);
		gc.setLineWidth(0.5);
		drawScaleOnAxisX();
	
	}

	private void drawScaleOnAxisY()
	{
		for (int j = 0; j < canvasHeight; j += 10)
		{
			gc.strokeLine(centralPointX - 3, j, centralPointX + 3, j);
			gc.setLineWidth(0.5);
		}
	}

	private void drawScaleOnAxisX()
	{
		for (int i = 0; i < stageWidth; i += 10)
		{
			gc.strokeLine(i, centralPointY - 3, i, centralPointY + 3);
			gc.setLineWidth(0.5);

		}
	}

	public static void main(String[] args)
	{
		launch(args);
	}
}
