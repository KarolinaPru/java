package application;

import java.util.ArrayList;
import java.util.regex.Pattern;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.util.converter.DoubleStringConverter;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class GUI extends Application
{
	private double stageWidth = 800;
	private double stageHeight = 960;
	public double canvasHeight = 800;
	public double canvasWidth = 800;
	private Group root;
	CurveDrawingLogic logic;
	private double centralPointX, centralPointY;
	public Canvas canvas;
	public TextField txtA, txtB;
	private ArrayList<Coordinate> coordinates;
	private GraphicsContext gc;
	private Label labelA, labelB;
	private Pattern validDoubleText;
	private Button drawButton, clearButton;

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

		renderCanvas();

		centralPointX = canvasWidth / 2;
		centralPointY = canvasHeight / 2;

		drawAxisX();
		drawAxisY();

		drawScaleOnAxisX();
		drawScaleOnAxisY();

		labelA = renderLabelA();
		labelB = renderLabelB();

		createTextFields();
		allowOnlyDoublesInTextFields();

		// TODO: Delete or use in a different way
		// textFormatterA.valueProperty().addListener((obs, oldValue, newValue)
		// ->
		// {
		// System.out.println("New double value " + newValue);
		// });

		Label lblFunctionY = new Label("y =  ");
		Label lblFunctionA = new Label();
		Label lblFunctionX = new Label(" x^2 + ");
		Label lblFunctionB = new Label();

		lblFunctionA.textProperty().bind(txtA.textProperty());
		lblFunctionB.textProperty().bind(txtB.textProperty());

		drawButton = createDrawButton();
		drawButton.setOnAction(handleDrawClick());

		clearButton = createClearButton();
		clearButton.setOnAction(handleClearClick());

		renderLayoutOfLowerControls(lblFunctionY, lblFunctionA, lblFunctionX, lblFunctionB, drawButton, clearButton);
		renderPrimaryStage(primaryStage, scene);
	}

	private void renderPrimaryStage(Stage primaryStage, Scene scene)
	{
		primaryStage.setScene(scene);
		primaryStage.setTitle("Quadratic function drawing tool: f(x) = ax^2 + b");
		primaryStage.setWidth(stageWidth);
		primaryStage.setHeight(stageHeight);
		primaryStage.setResizable(false);
		primaryStage.show();
	}

	private void createTextFields()
	{
		txtA = new TextField();
		txtA.setMaxWidth(80);

		txtB = new TextField();
		txtB.setMaxWidth(80);
	}

	private Button createDrawButton()
	{
		Button drawButton = new Button("Draw");
		drawButton.setMinWidth(100);
		drawButton.setTranslateX(20);
		return drawButton;
	}

	private Button createClearButton()
	{
		Button clearButton = new Button("Clear");
		clearButton.setMinWidth(100);
		clearButton.setTranslateX(20);
		return clearButton;
	}

	private void renderCanvas()
	{
		canvas = new Canvas(stageWidth, canvasHeight);
		gc = canvas.getGraphicsContext2D();
		paintCanvas();
		root.getChildren().add(canvas);
	}

	private Label renderLabelB()
	{
		Label labelB = new Label("Enter B: ");
		labelB.setMinWidth(100);
		labelB.setAlignment(Pos.BOTTOM_RIGHT);
		return labelB;
	}

	private Label renderLabelA()
	{
		Label labelA = new Label("Enter A: ");
		labelA.setMinWidth(100);
		labelA.setAlignment(Pos.BOTTOM_RIGHT);
		return labelA;
	}

	private void allowOnlyDoublesInTextFields()
	{
		validDoubleText = Pattern.compile("-?((\\d*)|(\\d+\\.\\d*))");
		allowOnlyDoublesForA();
		allowOnlyDoublesForB();
	}

	private void allowOnlyDoublesForB()
	{
		TextFormatter<Double> textFormatterB = new TextFormatter<Double>(new DoubleStringConverter(), 0.0, change ->
		{
			String textB = change.getControlNewText();
			if (validDoubleText.matcher(textB).matches())
			{

				return change;
			} else
				return null;
		});

		txtB.setTextFormatter(textFormatterB);
	}

	private void allowOnlyDoublesForA()
	{
		TextFormatter<Double> textFormatterA = new TextFormatter<Double>(new DoubleStringConverter(), 0.0, change ->
		{
			String textA = change.getControlNewText();
			if (validDoubleText.matcher(textA).matches())
			{
				return change;
			} else
				return null;
		});
		txtA.setTextFormatter(textFormatterA);
	}

	private EventHandler<ActionEvent> handleClearClick()
	{
		return event -> 
		{
		coordinates.clear();
		gc.clearRect(canvas.getLayoutX(), canvas.getLayoutY(), canvasWidth, canvasHeight);
		paintCanvas();
		drawAxisX();
		drawAxisY();
		};
	}

	private void renderLayoutOfLowerControls(Label lblFunctionY, Label lblFunctionA, Label lblFunctionX,
			Label lblFunctionB, Button drawButton, Button clearButton)
	{
		HBox aHBox = new HBox(10, labelA, txtA, labelB, txtB, drawButton, clearButton);
		drawButton.setTranslateX(250);
		clearButton.setTranslateX(drawButton.getTranslateX() + 20);
		aHBox.setPadding(new Insets(5));

		HBox hBoxFunctionLabels = new HBox(20, lblFunctionY, lblFunctionA, lblFunctionX, lblFunctionB);
		hBoxFunctionLabels.setTranslateX(250);
		HBox bHBox = new HBox(10, labelB, txtB, hBoxFunctionLabels);

		bHBox.setPadding(new Insets(5));
		HBox buttonsHBox = new HBox(10);
		buttonsHBox.setPadding(new Insets(10));

		VBox controlsVBox = new VBox(10, aHBox, bHBox);

		root.getChildren().add(controlsVBox);
		controlsVBox.setLayoutY(canvasHeight + 20);
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
		gc.strokeLine(translateXToPixelPosition(currentPoint.getX()), translateYToPixelPosition(currentPoint.getY()),
				translateXToPixelPosition(nextPoint.getX()), translateYToPixelPosition(nextPoint.getY()));
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
