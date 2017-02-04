package controller;

import java.io.File;
import java.net.MalformedURLException;

import javax.imageio.ImageIO;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;

public class MainWindowController {

	private Stage primaryStage;
	private Main main;
	
	@FXML
	private ImageView imageView;
	@FXML
	private TextField barcodeTextField;
	
	public void setMain(Stage promaryStage, Main main)
	{
		this.primaryStage = primaryStage;
		this.main = main;
	}
	
	@FXML
	private void loadBarcode() throws MalformedURLException {
		
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Load a barcode to scan");
		fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Image Files", "*.jpg","*.png","*.gif", "*.bmp"));

		File file = fileChooser.showOpenDialog(primaryStage);
		
		if (file != null) {
			String imagePath = file.toURI().toURL().toString();
			Image barcode = new Image(imagePath);
			imageView.setImage(barcode);
		}	
	}
	
	@FXML
	private void scanBarcode() {
		
		//TODO: Implement scanBarcode method
	}
}
