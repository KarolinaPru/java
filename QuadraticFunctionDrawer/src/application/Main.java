package application;
	
import com.sun.xml.internal.ws.dump.LoggingDumpTube.Position;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			VBox root = new VBox(10);
			Scene scene = new Scene(root,600,600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
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
			
			Button drawButton = new Button("Draw");
			drawButton.setMinWidth(100);
			drawButton.setTranslateX(180);
		
			
			HBox a = new HBox(10, labelA, txtA, drawButton);
			a.setPadding(new Insets(10));
			HBox b = new HBox(10, labelB, txtB);
			b.setPadding(new Insets(10));
			
			root.getChildren().add(a);
			root.getChildren().add(b);
			
			root.setAlignment(Pos.BOTTOM_CENTER);
			primaryStage.setScene(scene);
			primaryStage.show();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
