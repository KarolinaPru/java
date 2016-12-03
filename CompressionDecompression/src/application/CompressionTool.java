package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;


public class CompressionTool extends Application 
{
	TextField textField1;
	TextField textField2;
	String inputText;
	String outputText;

	@Override
	public void start(Stage primaryStage) 
	{
		try 
		{
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Compression tool");

			RadioButton rbtn1 = createRadioButton1();
			RadioButton rbtn2 = createRadioButton2();

			Group centerGroup = createCenterGroup(root);
			
			createVBoxWithRadioButtons(centerGroup, rbtn1, rbtn2);
			
			ToggleGroup toggle = createToggleGroup(rbtn1, rbtn2);
			toggle.selectToggle(rbtn1);
			addListenerToToggle(toggle);

			Label yourTextLabel = createYourTextLabel();
			Label outputLabel = createOutputLabel();
			addLabelsToCenterGroup(centerGroup, yourTextLabel, outputLabel);

			createTextField1();
			createTextField2();
			addTextFieldsToCenterGroup(centerGroup);
			
			Button copyButton = createCopyButton();
			centerGroup.getChildren().add(copyButton);
			setCopyButtonOnAction(copyButton);

			Button calculateButton = createCalculateButton();
			centerGroup.getChildren().add(calculateButton);
			setCalculateButtonOnAction(rbtn1, rbtn2, toggle, calculateButton);

			primaryStage.setScene(scene);
			primaryStage.show();

		} 
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}

	private void setCalculateButtonOnAction(RadioButton rbtn1, RadioButton rbtn2, ToggleGroup toggle,
			Button calculateButton) {
		calculateButton.setOnAction(
				event -> 
				{
					inputText = textField1.getText();

					if (inputText.matches("[A-Za-z]+") && toggle.getSelectedToggle() == rbtn1)
					{	
						Compressor c = new Compressor();
						String compressedString = c.compress(inputText);
						textField2.setText(compressedString);

					} else if (inputText.matches("[A-Za-z0-9]+") && toggle.getSelectedToggle() == rbtn2){
						
						Decompressor d = new Decompressor();
						String decompressedString = d.decompress(inputText);
						textField2.setText(decompressedString);

					} else {
						System.out.println("Only letters are allowed");
					}
				});
	}

	private Button createCalculateButton() {
		Button calculateButton = new Button();
		calculateButton.setText("Calculate");
		calculateButton.setLayoutX(-60);
		calculateButton.setLayoutY(40);
		calculateButton.getStyleClass().add("buttons");
		return calculateButton;
	}

	private void setCopyButtonOnAction(Button copyButton) {
		copyButton.setOnAction(
				event ->
				{
					outputText = textField2.getText();
					if (!outputText.isEmpty())
						textField1.setText(outputText);	
				});
	}

	private Button createCopyButton() {
		Button copyButton = new Button();
		copyButton.setText("Copy output");
		copyButton.setLayoutX(80);
		copyButton.setLayoutY(-60);
		copyButton.getStyleClass().add("buttnons");
		return copyButton;
	}

	private void addTextFieldsToCenterGroup(Group centerGroup) {
		centerGroup.getChildren().add(textField1);
		centerGroup.getChildren().add(textField2);
	}

	private void createTextField2() {
		textField2 = new TextField();
		textField2.setLayoutX(0);
		textField2.setLayoutY(-20);	
		textField2.getStyleClass().add("my-field");
	}

	private void createTextField1() {
		textField1 = new TextField();
		textField1.setPromptText("Enter text here");
		textField1.setLayoutX(0);
		textField1.setLayoutY(-100);
		textField1.getStyleClass().add("my-field");
	}

	private void addLabelsToCenterGroup(Group centerGroup, Label yourTextLabel, Label outputLabel) {
		centerGroup.getChildren().add(yourTextLabel);
		centerGroup.getChildren().add(outputLabel);
	}

	private Label createOutputLabel() {
		Label outputLabel = new Label("Output");
		outputLabel.getStyleClass().add("labels");
		outputLabel.setLayoutX(-100);
		outputLabel.setLayoutY(-15);
		return outputLabel;
	}

	private Label createYourTextLabel() {
		Label yourTextLabel = new Label("Your text");
		yourTextLabel.getStyleClass().add("labels");
		yourTextLabel.setLayoutX(-100);
		yourTextLabel.setLayoutY(-95);
		return yourTextLabel;
	}

	private Group createCenterGroup(BorderPane root) {
		Group centerGroup = new Group();
		root.setCenter(centerGroup);
		return centerGroup;
	}

	private void addListenerToToggle(ToggleGroup toggle) {
		toggle.selectedToggleProperty().addListener(
				(ov, oldToggle, newToggle) -> 
				{
					if (toggle.getSelectedToggle() != null)
						System.out.println(
								toggle.getSelectedToggle().getUserData().toString()
								);		
				});
	}

	private ToggleGroup createToggleGroup(RadioButton rbtn1, RadioButton rbtn2) {
		ToggleGroup toggle = new ToggleGroup();
		rbtn1.setToggleGroup(toggle);
		rbtn2.setToggleGroup(toggle);
		return toggle;
	}

	private RadioButton createRadioButton2() {
		RadioButton rbtn2 = new RadioButton("Decompress");
		rbtn2.setUserData("Decompression in progress");
		rbtn2.getStyleClass().add("labels");
		return rbtn2;
	}

	private RadioButton createRadioButton1() {
		RadioButton rbtn1 = new RadioButton("Compress");
		rbtn1.setUserData("Compression in progress");	
		rbtn1.getStyleClass().add("labels");
		return rbtn1;
	}

	private void createVBoxWithRadioButtons(Group centerGroup, RadioButton rbtn1, RadioButton rbtn2) {
		VBox vbox = new VBox(5);
		vbox.getChildren().add(rbtn1);
		vbox.getChildren().add(rbtn2);
		vbox.setLayoutX(60);
		vbox.setLayoutY(40);
		centerGroup.getChildren().add(vbox);
	}
	
	public static void main(String[] args) 
	{
		launch(args);
	}
}