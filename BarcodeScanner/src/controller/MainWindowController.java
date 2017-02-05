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
import model.BarcodeConversionController;
import javafx.stage.FileChooser.ExtensionFilter;

public class MainWindowController {

	private Stage primaryStage;
	private Main main;

	@FXML
	private ImageView barcodeImage;
	@FXML
	private TextField barcodeTextField;

	public void setMain(Stage primaryStage, Main main) {
		this.primaryStage = primaryStage;
		this.main = main;
	}

	@FXML
	private void loadBarcode() throws MalformedURLException {

        File file = getFileFromChooser();

		if (file != null) {
			String imagePath = file.toURI().toURL().toString();
			Image barcode = new Image(imagePath);
			barcodeImage.setImage(barcode);
		}
		
		scanBarcode();
	}

    private File getFileFromChooser() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Load a barcode to scan");

        ExtensionFilter extensionFilter = new ExtensionFilter("Image Files", "*.jpg", "*.png", "*.gif", "*.bmp");
        fileChooser.getExtensionFilters().addAll(extensionFilter);

        return fileChooser.showOpenDialog(primaryStage);
    }

	private void scanBarcode() {
		BarcodeConversionController br = new BarcodeConversionController();
        String colors = readPixelColors();
        String decodedBarcode = br.convert(colors);
        barcodeTextField.setText(decodedBarcode);
	}

	private String readPixelColors() {
		Image barcode = barcodeImage.getImage();
		int barcodeWidth = (int) barcode.getWidth();
		PixelReader pixelReader = barcode.getPixelReader();

		StringBuilder colors = new StringBuilder();

		for (int x = 0; x < barcodeWidth; x++) {

			Color currentColor = pixelReader.getColor(x, 1);

			if(currentColor.equals(Color.WHITE)) {
				colors.append('w');
			}
			else if (currentColor.equals(Color.BLACK))
			{
				colors.append('b');
			}
			else {
				System.out.println("Scan a proper barcode");
			}
		}

		return colors.toString();
	}
}