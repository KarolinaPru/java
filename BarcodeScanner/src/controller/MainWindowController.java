package controller;

import java.io.File;
import java.net.MalformedURLException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.BarcodeReader;
import javafx.stage.FileChooser.ExtensionFilter;

public class MainWindowController {

	private Stage primaryStage;
	private Main main;

	@FXML
	private ImageView imageView;
	@FXML
	private TextField barcodeTextField;

	public void setMain(Stage primaryStage, Main main) {
		this.primaryStage = primaryStage;
		this.main = main;
	}

	@FXML
	private void loadBarcode() throws MalformedURLException {

		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Load a barcode to scan");
		fileChooser.getExtensionFilters()
		.addAll(new ExtensionFilter("Image Files", "*.jpg", "*.png", "*.gif", "*.bmp"));

		File file = fileChooser.showOpenDialog(primaryStage);

		if (file != null) {
			String imagePath = file.toURI().toURL().toString();
			Image barcode = new Image(imagePath);
			imageView.setImage(barcode);
		}
	}

	@FXML
	private void scanBarcode() {
	
		BarcodeReader br = new BarcodeReader();
		br.determineBarsInBarcode(readPixelColors());


	}

	private String readPixelColors() {
		Image image = imageView.getImage();
		int width = (int) image.getWidth();
		PixelReader reader = image.getPixelReader();

		StringBuilder sb = new StringBuilder();

		for (int x = 0; x < width; x++) {

			Color currentColor = reader.getColor(x, 1);

			if(currentColor.equals(Color.WHITE)) {
				sb.append('w');
			}
			else if (currentColor.equals(Color.BLACK))
			{
				sb.append('b');
			}
			else {
				System.out.println("Scan a proper barcode");
			}
		}	
		return sb.toString();	
	}
}