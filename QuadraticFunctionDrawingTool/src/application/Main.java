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


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Group root = new Group();
			Scene scene = new Scene(root,600,690);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			Canvas canvas = new Canvas(580, 560);
			canvas.setLayoutX(10);
			canvas.setLayoutY(10);
			GraphicsContext gc = canvas.getGraphicsContext2D();
			gc.setFill(Color.web("#EAFAF1"));
			gc.fillRect(10, 10, 580, 560);
			// W celu dokonywania wyliczen w obrebie canvas ?
			canvas.boundsInParentProperty();
			root.getChildren().add(canvas);
			
			
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
			
			primaryStage.setScene(scene);
			primaryStage.setTitle("Quadratic function drawing tool");
			primaryStage.setResizable(false);
			primaryStage.show();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
