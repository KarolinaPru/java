package application;

import java.util.Optional;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.Group;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;

public class CompressionTool extends Application
{
	private TextField inputTextField;
	private TextField outputTextField;
	private String inputText;
	private String outputText;
	private RadioButton compressButton;
	private RadioButton decompressButton;
	private Button calculateButton;
	private ToggleGroup toggle;
	private Label yourTextLabel;
	private Label outputLabel;
	private Group centerGroup;
	private Button copyButton;

	@Override
	public void start(Stage primaryStage)
	{
		try
		{
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root, 500, 500);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Compression tool");
			primaryStage.setMinWidth(500);
			primaryStage.setMinHeight(500);
			primaryStage.setMaxWidth(600);
			primaryStage.setMaxHeight(600);

			createCompressButton();
			createDecompressButton();

			createCenterGroup(root);

			createVBoxWithRadioButtons();

			createToggleGroup();
			toggle.selectToggle(compressButton);
			addListenerToToggle();

			createYourTextLabel();
			createOutputLabel();
			addLabelsToCenterGroup();

			createInputTextField();
			createOutputTextField();
			addTextFieldsToCenterGroup();

			createCopyButton();
			centerGroup.getChildren().add(copyButton);
			setCopyButtonOnAction();

			createCalculateButton();
			centerGroup.getChildren().add(calculateButton);
			setCalculateButtonOnAction();

			primaryStage.setScene(scene);
			primaryStage.show();
		}

		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	private void setCalculateButtonOnAction()
	{
		calculateButton.setOnAction(event ->
		{
			inputText = inputTextField.getText();
			if (inputText.isEmpty())
			{
				Alert alert = new Alert(AlertType.INFORMATION, "Please enter text.");
				Optional<ButtonType> result = alert.showAndWait();
			} else if (inputText.matches("[A-Za-z]+") && toggle.getSelectedToggle() == compressButton)
			{
				Compressor c = new Compressor();
				String compressedString = c.compress(inputText);
				outputTextField.setText(compressedString);
			} else if (Character.isLetter(inputText.charAt(0)) && inputText.matches("[A-Za-z0-9]+")
					&& toggle.getSelectedToggle() == decompressButton)
			{

				Decompressor d = new Decompressor();
				String decompressedString = d.decompress(inputText);
				outputTextField.setText(decompressedString);
			} else
			{
				Alert alert = new Alert(AlertType.INFORMATION, "Please enter valid characters.");
				Optional<ButtonType> result = alert.showAndWait();
			}
		});
	}

	private void createCalculateButton()
	{
		calculateButton = new Button();
		calculateButton.setText("Calculate");
		calculateButton.setLayoutX(-60);
		calculateButton.setLayoutY(80);
		calculateButton.getStyleClass().add("buttons");
	}

	private void setCopyButtonOnAction()
	{
		copyButton.setOnAction(event ->
		{
			outputText = outputTextField.getText();
			if (!outputText.isEmpty())
				inputTextField.setText(outputText);
		});
	}

	private void createCopyButton()
	{
		copyButton = new Button();
		copyButton.setText("Copy output");
		copyButton.setLayoutX(80);
		copyButton.setLayoutY(-60);
		copyButton.getStyleClass().add("buttons");
	}

	private void addTextFieldsToCenterGroup()
	{
		centerGroup.getChildren().add(inputTextField);
		centerGroup.getChildren().add(outputTextField);
	}

	private void createOutputTextField()
	{
		outputTextField = new TextField();
		outputTextField.setLayoutX(-20);
		outputTextField.setLayoutY(-5);
		outputTextField.getStyleClass().add("my-field");
	}

	private void createInputTextField()
	{
		inputTextField = new TextField();
		inputTextField.setPromptText("Enter text here");
		inputTextField.setLayoutX(-20);
		inputTextField.setLayoutY(-120);
		inputTextField.getStyleClass().add("my-field");
	}

	private void addLabelsToCenterGroup()
	{
		centerGroup.getChildren().add(yourTextLabel);
		centerGroup.getChildren().add(outputLabel);
	}

	private void createOutputLabel()
	{
		outputLabel = new Label("Output text:");
		outputLabel.getStyleClass().add("labels");
		outputLabel.setLayoutX(-118);
		outputLabel.setLayoutY(7);
	}

	private void createYourTextLabel()
	{
		yourTextLabel = new Label("Your text:");
		yourTextLabel.getStyleClass().add("labels");
		yourTextLabel.setLayoutX(-117);
		yourTextLabel.setLayoutY(-108);
	}

	private void createCenterGroup(BorderPane root)
	{
		centerGroup = new Group();
		root.setCenter(centerGroup);
	}

	private void addListenerToToggle()
	{
		toggle.selectedToggleProperty().addListener((ov, oldToggle, newToggle) ->
		{
			if (toggle.getSelectedToggle() != null)
				System.out.println(toggle.getSelectedToggle().getUserData().toString());
		});
	}

	private void createToggleGroup()
	{
		toggle = new ToggleGroup();
		compressButton.setToggleGroup(toggle);
		decompressButton.setToggleGroup(toggle);
	}

	private void createDecompressButton()
	{
		decompressButton = new RadioButton("Decompress");
		decompressButton.setUserData("Decompression in progress");
		decompressButton.getStyleClass().add("labels");
	}

	private void createCompressButton()
	{
		compressButton = new RadioButton("Compress");
		compressButton.setUserData("Compression in progress");
		compressButton.getStyleClass().add("labels");

	}

	private void createVBoxWithRadioButtons()
	{
		VBox vbox = new VBox(10);
		vbox.getChildren().add(compressButton);
		vbox.getChildren().add(decompressButton);
		vbox.setLayoutX(140);
		vbox.setLayoutY(60);
		centerGroup.getChildren().add(vbox);
	}

	public static void main(String[] args)
	{
		launch(args);
	}
}