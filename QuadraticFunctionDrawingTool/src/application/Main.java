package application;
	
import com.sun.xml.internal.ws.dump.LoggingDumpTube.Position;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurveTo;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Group root = new Group();
			Scene scene = new Scene(root,600,690);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			Canvas canvas = new Canvas(600, 560);

			GraphicsContext gc = canvas.getGraphicsContext2D();
			gc.setFill(Color.web("#EAFAF1"));
			gc.fillRect(
					canvas.getLayoutX(),
					canvas.getLayoutY(),
					canvas.getWidth(),
					canvas.getHeight()
					);
			// W celu dokonywania wyliczen w obrebie canvas ?
			canvas.boundsInParentProperty();
			root.getChildren().add(canvas);
			
			drawAxisX(root, canvas);
			drawAxisY(root, canvas);

			drawScaleOnAxisX(root, canvas);
			drawScaleOnAxisY(root, canvas);

			Label labelA = new Label("Enter A: ");
			labelA.setMinWidth(100);
			labelA.setAlignment(Pos.BOTTOM_RIGHT);
			Label labelB = new Label("Enter B: ");
			labelB.setMinWidth(100);
			labelB.setAlignment(Pos.BOTTOM_RIGHT);
			
			TextField txtA = new TextField();
			txtA.setMaxWidth(80);
			TextField txtB = new TextField();
			txtB.setMaxWidth(80);
			
			Label lblFunction = new Label("f(x) = ax^2 + b");
			lblFunction.setMinWidth(120);
			lblFunction.setTranslateX(180);
			
			Button drawButton = new Button("Draw");
			drawButton.setMinWidth(100);
			drawButton.setTranslateX(180);
			
			HBox a = new HBox(10, labelA, txtA, lblFunction);
			a.setPadding(new Insets(10));
			HBox b = new HBox(10, labelB, txtB, drawButton);
			b.setPadding(new Insets(10));
			
			VBox bottomControls = new VBox(10, a, b);
			bottomControls.setAlignment(Pos.BOTTOM_CENTER);
			
			root.getChildren().add(bottomControls);
			bottomControls.setLayoutY(570);
			
			//TODO: Draw a curve based on given data
			
			// Making a path 
			Path path = new Path();
			
			// A starting point
			// Creates an addition to the path by moving to the specified coordinates.
			MoveTo moveTo = new MoveTo();
			moveTo.setX(200);
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
			
			
			//TODO:
			// Wyznaczyæ œrodek uk³adu
			//TODO:
			// Dodaæ tooltipy pokazuj¹ce wspó³rzêdne x y na paraboli
			//TODO
			// dodaæ s³uchaczy zdarzeñ to pól tekstowych i guzika
			//TODO
			// slider? coœ, ¿eby móc porzerzyæ wykres w razie potrzeby
			
			
			primaryStage.setScene(scene);
			primaryStage.setTitle("Quadratic function drawing tool");
			primaryStage.setResizable(false);
			primaryStage.show();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private void drawAxisY(Group root, Canvas canvas)
	{
		Line axisY = new Line(
				canvas.getWidth()/2,
				canvas.getLayoutY(),
				canvas.getWidth()/2,
				canvas.getLayoutY() + canvas.getHeight()					
				);
		root.getChildren().add(axisY);
	}

	private void drawAxisX(Group root, Canvas canvas)
	{
		Line axisX = new Line(
				canvas.getLayoutX(), 
				canvas.getHeight()/2, 
				canvas.getLayoutX() + canvas.getWidth(), 
				canvas.getHeight()/2
				);
		root.getChildren().add(axisX);
	}

	private void drawScaleOnAxisY(Group root, Canvas canvas)
	{
		for (int j = 0; j < canvas.getHeight(); j+=10)
		{
			Line scaleAxisY = new Line(
				canvas.getWidth() / 2 - 3,
				j,
				canvas.getWidth()/2 + 3,
				j
				);
			scaleAxisY.setStrokeWidth(0.5);
			
			root.getChildren().add(scaleAxisY);
		}
	}

	private void drawScaleOnAxisX(Group root, Canvas canvas)
	{
		for (int i = 0; i < canvas.getWidth(); i+=10)
		{
			Line scaleAxisX = new Line(
				i,
				canvas.getHeight()/2 - 3,
				i,
				canvas.getHeight()/2 + 3
				);
			scaleAxisX.setStrokeWidth(0.5);
			
			root.getChildren().add(scaleAxisX);
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
