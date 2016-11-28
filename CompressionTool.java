package application;
	
import java.lang.reflect.Array;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class CompressionTool extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application2.css").toExternalForm());
			
			Label label = new Label("Compression tool");
			
			Group centerGroup = new Group();
			root.setCenter(centerGroup);
			
			TextField textField1 = new TextField();
			TextField textField2 = new TextField();
			centerGroup.getChildren().add(textField1);
			centerGroup.getChildren().add(textField2);
			textField1.setLayoutX(-20);
			textField1.setLayoutY(-100);
			textField2.setLayoutX(-20);
			textField2.setLayoutY(-20);	
			
			Button centerButton = new Button();
			centerButton.setText("Copy text above");
			centerGroup.getChildren().add(centerButton);
			centerButton.setLayoutX(0);
			centerButton.setLayoutY(-60);
			
					
			Button bottomButton = new Button();
			bottomButton.setText("Calculate");
			bottomButton.setLayoutX(-60);
			bottomButton.setLayoutY(40);
			centerGroup.getChildren().add(bottomButton);
			
			bottomButton.setOnAction(
					event -> 
					{
					String userInput = textField1.getText();
					
					if (userInput.matches("[A-Za-z]+"))
						{	
						int count = 0;
						for (int i = 0; i < userInput.length(); i++)
						{	
							char charAt = userInput.charAt(i);
							count++;				
						}	
						System.out.println("");
						}
					}			
					);
			
			RadioButton rbtn1 = new RadioButton("Compress");
			rbtn1.setUserData("Compression in progress");	
			RadioButton rbtn2 = new RadioButton("Decompress");
			rbtn2.setUserData("Decompression in progress");
			
			ToggleGroup toggle = new ToggleGroup();
			rbtn1.setToggleGroup(toggle);
			rbtn2.setToggleGroup(toggle);
			
			VBox vbox = new VBox(5);
			vbox.getChildren().add(rbtn1);
			vbox.getChildren().add(rbtn2);
			vbox.setLayoutX(60);
			vbox.setLayoutY(40);
			centerGroup.getChildren().add(vbox);

		
			toggle.selectToggle(rbtn1);
			
			toggle.selectedToggleProperty().addListener(
					(ov, oldToggle, newToggle) -> 
					{
					if (toggle.getSelectedToggle() != null)
						System.out.println(
							toggle.getSelectedToggle().getUserData().toString()
							);		
					} 
					);
			
			
			
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
