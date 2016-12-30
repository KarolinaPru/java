package application;
	
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurveTo;


public class Main extends Application {
	private double centralPointX;
	private double centralPointY;
	private Point2D centralPoint;
	private Canvas canvas;
	private Group root;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			root = new Group();
			Scene scene = new Scene(root,600,690);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			canvas = new Canvas(600, 560);

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
			
			
			centralPointX = canvas.getWidth()/2;
			centralPointY = canvas.getHeight()/2;
			
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
			
			// Wyznaczam środek układu, później będę dokonywać przesunięć względem niego
			centralPoint = new Point2D (centralPointX, centralPointY); 
			
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
			
			
//			roundRect.setTranslateX(path.getBoundsInParent().getWidth() + 20);
//			roundRect.setTranslateY(donut.getBoundsInParent().getHeight() + 20);
			
			
			//TODO:
			// Doda� tooltipy pokazuj�ce wsp�rz�dne x y na paraboli
			//TODO
			// doda� s�uchaczy zdarze� to p�l tekstowych i guzika
			//TODO
			// slider? co�, �eby m�c porzerzy� wykres w razie potrzeby
			
			
			primaryStage.setScene(scene);
			primaryStage.setTitle("Quadratic function drawing tool");
			primaryStage.setResizable(false);
			primaryStage.show();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private void drawAxisY()
	{
		Line axisY = new Line(
				centralPointX,
				canvas.getLayoutY(),
				centralPointX,
				canvas.getLayoutY() + canvas.getHeight()					
				);
		root.getChildren().add(axisY);
	}

	private void drawAxisX()
	{
		Line axisX = new Line(
				canvas.getLayoutX(), 
				centralPointY, 
				canvas.getLayoutX() + canvas.getWidth(), 
				centralPointY
				);
		root.getChildren().add(axisX);
	}

	private void drawScaleOnAxisY()
	{
		for (int j = 0; j < canvas.getHeight(); j+=10)
		{
			Line scaleAxisY = new Line(
				centralPointX - 3,
				j,
				centralPointX + 3,
				j
				);
			scaleAxisY.setStrokeWidth(0.5);
			
			root.getChildren().add(scaleAxisY);
		}
	}

	private void drawScaleOnAxisX()
	{
		for (int i = 0; i < canvas.getWidth(); i+=10)
		{
			Line scaleAxisX = new Line(
				i,
				centralPointY - 3,
				i,
				centralPointY + 3
				);
			scaleAxisX.setStrokeWidth(0.5);
			
			root.getChildren().add(scaleAxisX);
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
