package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Group root = new Group();
			Scene scene = new Scene(root,512,256);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			// Płótno do rysowania
			Canvas canvas = new Canvas(512, 256);
			GraphicsContext gc = canvas.getGraphicsContext2D();

			Image image = new Image(
					getClass().getResourceAsStream("sloth.jpg")
					);

			int width = (int)image.getWidth();
			int height = (int)image.getHeight();
			gc.drawImage(image, 0, 0);

			PixelReader reader = image.getPixelReader();
			WritableImage dst = new WritableImage(width, height);

			PixelWriter writer = dst.getPixelWriter();

			for (int x = 0; x < width; x++)
			{
				for (int y = 0; y < height; y++)
				{

					// Podajemy współrzędne piksela, którego kolor chcemy odczytać
					Color color = reader.getColor(x, y);
					writer.setColor(x, y, 
							Color.color(
									color.getRed()/2,
									color.getBlue()/2,
									color.getGreen()/2)
							);
				}
			}

			// Rysujemy kopię obrazka obok oryginału
			gc.drawImage(dst, 256, 0);
			gc.setFill(Color.TRANSPARENT);
			gc.setStroke(Color.BLUE);
			gc.setLineWidth(3);
			
			// Rysujemy ramkę
			// PIKSELE - czyli nic się nie przesuwa, jak się narysowało, to jest
			gc.strokeLine(10, 10, 512-20, 10);
			gc.strokeLine(10, 256-20, 512-20, 256-20);
			gc.strokeLine(10, 10, 10, 256-20);
			gc.strokeLine(512-20, 10, 512-20, 256-20);
			
			
			
			root.getChildren().add(canvas);

			primaryStage.setTitle("Rysowanie na Canvas");
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
