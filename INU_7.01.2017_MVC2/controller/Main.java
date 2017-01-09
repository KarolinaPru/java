package controller;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

public class Main extends Application {
	private Stage primaryStage;

	// Trzeba wykasowac srodek, zostawic tylko start
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		mainWindow();

	}

	// Tu będziemy chcieli zassać plik fmxl - miedzy ukośnikami package
	public void mainWindow() {
		try {

			FXMLLoader loader = new FXMLLoader(Main.class.getResource("/view/MainWindowView.fxml"));

			// Inicjalizujemy ten obiekt metodą load
			AnchorPane pane = loader.load();
			primaryStage.setMinWidth(500.0);
			primaryStage.setMinHeight(701.0);

			// Nie robimy przez new, tylko ładujemy
			MainWindowController mainWindowController = loader.getController();
			
			mainWindowController.setMain(this, primaryStage);

			Scene scene = new Scene(pane);
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		launch(args);
	}
}
