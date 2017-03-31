package application;

import java.util.ArrayList;
import java.util.regex.Pattern;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.converter.DoubleStringConverter;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class GUI extends Application
{
	private double stageWidth = 805, stageHeight = 960;
	public double canvasHeight = 800, canvasWidth = 800;
	private Pane root;
	public Canvas canvas;
	CurveDrawingLogic logic;
	private double centralPointX, centralPointY;
	public TextField txtA, txtB;
	private ArrayList<Coordinate> coordinates;
	private GraphicsContext gc;
	private Label labelA, labelB, lblFunctionY, lblFunctionA, lblFunctionX, lblFunctionB;
	private Pattern validDoubleText;
	private Button drawButton, clearButton;
	private HBox hBoxFunctionLabels, bHBox, aHBox;
	private VBox controlsVBox;

	public static void main(String[] args)
	{
		launch(args);
	}

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
		root = new Pane();

		renderCanvas();

		centralPointX = canvasWidth / 2;
		centralPointY = canvasHeight / 2;

		drawAxisX();
		drawAxisY();

		renderLabelA();
		renderLabelB();

		createTextFields();
		allowOnlyDoublesInTextFields();

		createFunctionLabelsAndBindThem();

		createDrawButton();
		drawButton.setOnAction(handleDrawClick());

		createClearButton();
		clearButton.setOnAction(handleClearClick());

		renderLayoutOfLowerControls();

		primaryStage.setTitle("Quadratic function drawing tool: f(x) = ax^2 + b");
		primaryStage.setWidth(stageWidth);
		primaryStage.setHeight(stageHeight);
		primaryStage.setResizable(true);
		Scene scene = new Scene(root, stageWidth, stageHeight);
		scene.getStylesheets().add(getClass().getResource("app.css").toExternalForm());
		primaryStage.setScene(scene);
		root.setStyle("-fx-background-color: #99ebff");
		primaryStage.initStyle(StageStyle.DECORATED);
		primaryStage.show();
	}

	private void renderCanvas()
	{
		canvas = new Canvas(canvasWidth, canvasHeight);
		gc = canvas.getGraphicsContext2D();
		paintCanvas();
		root.getChildren().add(canvas);
	}

	private void paintCanvas()
	{
		gc.setFill(Color.web("#1ad1ff"));
		gc.fillRect(canvas.getLayoutX(), canvas.getLayoutY(), canvasWidth, canvasHeight);
	}

	private void drawAxisX()
	{
		gc.strokeLine(canvas.getLayoutX(), centralPointY, canvas.getLayoutX() + stageWidth, centralPointY);
		gc.setLineWidth(0.5);
		drawScaleOnAxisX();
		drawVectorOnAxisX();
	}

	private void drawScaleOnAxisX()
	{
		for (int i = 0; i < canvasWidth; i += 10)
		{
			gc.strokeLine(i, centralPointY - 3, i, centralPointY + 3);
			gc.setLineWidth(0.5);
		}
	}

	private void drawVectorOnAxisX()
	{
		double[] xPoints =
		{ canvas.getWidth() - 15, canvas.getWidth(), canvas.getWidth() - 15, };
		double[] yPoints =
		{ centralPointY - 10, centralPointY, centralPointY + 10 };

		gc.setFill(Color.BLACK);
		gc.fillPolygon(xPoints, yPoints, 3);
	}

	private void drawAxisY()
	{
		gc.strokeLine(centralPointX, canvas.getLayoutY(), centralPointX, canvas.getLayoutY() + canvasHeight);
		gc.setLineWidth(0.5);
		drawScaleOnAxisY();
		drawVectorOnAxisY();
	}

	private void drawScaleOnAxisY()
	{
		for (int j = 0; j < canvasHeight; j += 10)
		{
			gc.strokeLine(centralPointX - 3, j, centralPointX + 3, j);
			gc.setLineWidth(0.5);
		}
	}

	private void drawVectorOnAxisY()
	{
		double[] xPoints =
		{ centralPointX - 10, centralPointX, centralPointX + 10 };

		double[] yPoints =
		{ canvas.getLayoutY() + 15, canvas.getLayoutY(), canvas.getLayoutY() + 15 };

		gc.setFill(Color.BLACK);
		gc.fillPolygon(xPoints, yPoints, 3);
	}

	private void renderLabelA()
	{
		labelA = new Label("Enter A: ");
		labelA.setMinWidth(100);
		labelA.setAlignment(Pos.BOTTOM_RIGHT);
		labelA.setStyle("-fx-font-size: 20px");
	}

	private void renderLabelB()
	{
		labelB = new Label("Enter B: ");
		labelB.setMinWidth(100);
		labelB.setAlignment(Pos.BOTTOM_RIGHT);
		labelB.setStyle("-fx-font-size: 20px");
	}

	private void createTextFields()
	{
		txtA = new TextField();
		txtA.setMaxWidth(80);
		txtA.setAlignment(Pos.CENTER);

		txtB = new TextField();
		txtB.setMaxWidth(80);
		txtB.setAlignment(Pos.CENTER);
	}

	private void allowOnlyDoublesInTextFields()
	{
		// Compiles the given regular expression into a pattern.
		validDoubleText = Pattern.compile("-?((\\d*)|(\\d+\\.\\d*))");
		allowOnlyDoublesForA();
		allowOnlyDoublesForB();
	}

	private void allowOnlyDoublesForA()
	{
		TextFormatter<Double> textFormatterA = new TextFormatter<Double>(new DoubleStringConverter(), 0.0, change ->
		{
			// Gets the complete new text which will be used on the control
			// after this change
			String textA = change.getControlNewText();
			if (validDoubleText.matcher(textA).matches())
			{
				return change;
			} else
				return null;
		});
		txtA.setTextFormatter(textFormatterA);

		textFormatterA.valueProperty().addListener((obs, oldValue, newValue) ->
		{
			System.out.println("New double value " + newValue);
		});
	}

	private void allowOnlyDoublesForB()
	{
		TextFormatter<Double> textFormatterB = new TextFormatter<Double>(new DoubleStringConverter(), 0.0, change ->
		{
			// Gets the complete new text which will be used on the control
			// after this change
			String textB = change.getControlNewText();
			if (validDoubleText.matcher(textB).matches())
			{
				return change;
			} else
				return null;
		});

		txtB.setTextFormatter(textFormatterB);

		textFormatterB.valueProperty().addListener((obs, oldValue, newValue) ->
		{
			System.out.println("New double value " + newValue);
		});
	}

	private void createFunctionLabelsAndBindThem()
	{
		lblFunctionY = new Label("y =  ");
		lblFunctionA = new Label();
		lblFunctionX = new Label(" x^2 + ");
		lblFunctionB = new Label();

		lblFunctionY.setStyle("-fx-font-size: 20px");
		lblFunctionA.setStyle("-fx-font-size: 20px");
		lblFunctionX.setStyle("-fx-font-size: 20px");
		lblFunctionB.setStyle("-fx-font-size: 20px");

		lblFunctionA.textProperty().bind(txtA.textProperty());
		lblFunctionB.textProperty().bind(txtB.textProperty());
	}

	private void createDrawButton()
	{
		drawButton = new Button("Draw");
		drawButton.setMinWidth(100);
		drawButton.setTranslateX(20);
		drawButton.setStyle("-fx-background-color: #b3b3b3");
	}

	private EventHandler<ActionEvent> handleDrawClick()
	{
		return event ->
		{
			if (Double.parseDouble(txtA.getText()) == 0.0 && Double.parseDouble(txtB.getText()) == 0.0)
			{
				return;
			} else
			{
				logic = new CurveDrawingLogic(txtA.getText(), txtB.getText());
				coordinates = logic.calculateCoordinatesOfQuadFunc();

				checkIfThereAreAtLeast2PointsAndJoinThem(coordinates);
				coordinates.clear();
			}
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
		gc.setStroke(Color.web("#4527A0"));
		gc.strokeLine(translateXToPixelPosition(currentPoint.getX()), translateYToPixelPosition(currentPoint.getY()),
				translateXToPixelPosition(nextPoint.getX()), translateYToPixelPosition(nextPoint.getY()));
		gc.setLineWidth(1.3);
	}

	private double translateXToPixelPosition(double x)
	{
		return centralPointX + (x * 10);
	}

	private double translateYToPixelPosition(double y)
	{
		return centralPointY - (y * 10);
	}

	private void createClearButton()
	{
		clearButton = new Button("Clear");
		clearButton.setMinWidth(100);
		clearButton.setTranslateX(20);
		clearButton.setStyle("-fx-background-color: #b3b3b3");
	}

	private EventHandler<ActionEvent> handleClearClick()
	{
		return event ->
		{
			if (Double.parseDouble(txtA.getText()) == 0.0 && Double.parseDouble(txtB.getText()) == 0.0)
			{
				return;
			} else
			{
				coordinates.clear();
				gc.clearRect(canvas.getLayoutX(), canvas.getLayoutY(), canvasWidth, canvasHeight);
				txtA.setText("0.0");
				txtB.setText("0.0");
				paintCanvas();
				gc.setStroke(Color.BLACK);
				drawAxisX();
				drawAxisY();
			}
		};
	}

	private void renderLayoutOfLowerControls()
	{
		putTopControlsInHBox();
		putBottomControlsInHBox();
		placeAllControlsInVBox();
	}

	private void putTopControlsInHBox()
	{
		aHBox = new HBox(10, labelA, txtA, labelB, txtB, drawButton, clearButton);
		drawButton.setTranslateX(250);
		clearButton.setTranslateX(drawButton.getTranslateX() + 20);
		aHBox.setPadding(new Insets(5));
	}

	private void putBottomControlsInHBox()
	{
		hBoxFunctionLabels = new HBox(20, lblFunctionY, lblFunctionA, lblFunctionX, lblFunctionB);
		hBoxFunctionLabels.setTranslateX(250);

		bHBox = new HBox(10, labelB, txtB, hBoxFunctionLabels);
		bHBox.setPadding(new Insets(5));
	}

	private void placeAllControlsInVBox()
	{
		controlsVBox = new VBox(10, aHBox, bHBox);
		root.getChildren().add(controlsVBox);
		controlsVBox.setLayoutY(canvasHeight + 20);
		controlsVBox.setId("v-box");
	}
}
