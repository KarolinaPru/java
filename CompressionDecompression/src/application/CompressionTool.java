package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class CompressionTool extends Application {
	TextField textField1;
	TextField textField2;
	String input;
	String outputText;

	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Compression tool");

			Group centerGroup = new Group();
			root.setCenter(centerGroup);


			RadioButton rbtn1 = new RadioButton("Compress");
			rbtn1.setUserData("Compression in progress");	
			RadioButton rbtn2 = new RadioButton("Decompress");
			rbtn2.setUserData("Decompression in progress");
			rbtn1.getStyleClass().add("labels");
			rbtn2.getStyleClass().add("labels");


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
					});

			Label yourTextLabel = new Label("Your text");
			Label outputLabel = new Label("Output");
			yourTextLabel.getStyleClass().add("labels");
			outputLabel.getStyleClass().add("labels");
			centerGroup.getChildren().add(yourTextLabel);
			centerGroup.getChildren().add(outputLabel);
			yourTextLabel.setLayoutX(-100);
			yourTextLabel.setLayoutY(-95);
			outputLabel.setLayoutX(-100);
			outputLabel.setLayoutY(-15);
			
			textField1 = new TextField();
			textField1.setPromptText("Enter text here");
			textField2 = new TextField();
			centerGroup.getChildren().add(textField1);
			centerGroup.getChildren().add(textField2);
			textField1.setLayoutX(0);
			textField1.setLayoutY(-100);
			textField2.setLayoutX(0);
			textField2.setLayoutY(-20);	
			textField1.getStyleClass().add("my-field");
			textField2.getStyleClass().add("my-field");

			Button copyButton = new Button();
			copyButton.setText("Copy output");
			centerGroup.getChildren().add(copyButton);
			copyButton.setLayoutX(80);
			copyButton.setLayoutY(-60);
			copyButton.getStyleClass().add("buttnons");

			copyButton.setOnAction(
					event ->
					{
						outputText = textField2.getText();
						if (!outputText.isEmpty())
							textField1.setText(outputText);	
					});

			Button calculateButton = new Button();
			calculateButton.setText("Calculate");
			calculateButton.setLayoutX(-60);
			calculateButton.setLayoutY(40);
			centerGroup.getChildren().add(calculateButton);
			calculateButton.getStyleClass().add("buttnons");

			calculateButton.setOnAction(
					event -> 
					{
						input = textField1.getText();

						if (input.matches("[A-Za-z]+") && toggle.getSelectedToggle() == rbtn1)
						{	
							compress();

						} else if (input.matches("[A-Za-z0-9]+") && toggle.getSelectedToggle() == rbtn2){
							
							Decompressor d = new Decompressor();
							String decompressedString = d.decompress(input);
							textField2.setText(decompressedString);

						} else {
							System.out.println("Only letters are allowed");
						}
					});



			primaryStage.setScene(scene);
			primaryStage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private void compress() {
		StringBuilder str = new StringBuilder();
		char lastChar = input.charAt(0);
		int count = 1;

		for (int i = 1; i < input.length(); i++)
		{	
			if (input.charAt(i) == lastChar)
				count++;
			else {
				if (count > 1)			
					str.append("" + lastChar + count);
				else 
					str.append(lastChar);

				count = 1;
				lastChar = input.charAt(i);
			}
		}

		if (count > 1)
			str.append("" + lastChar + count);
		else
			str.append(lastChar);		

		String compressedString = str.toString();

		textField2.setText(compressedString);
		System.out.println(compressedString);
	}

	public static void main(String[] args) {
		launch(args);
	}
}