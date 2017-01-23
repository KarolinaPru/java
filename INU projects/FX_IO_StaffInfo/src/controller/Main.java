package controller;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

public class Main extends Application
{

	@Override
	public void start(Stage primaryStage)
	{

		FXMLLoader loader = new FXMLLoader(Main.class.getResource("/view/MainWindowView.fxml"));

		AnchorPane pane;
		try
		{
			pane = loader.load();
		} catch (IOException e)
		{
			e.printStackTrace();
			return;
		}
		primaryStage.setMinWidth(1277.0);
		primaryStage.setMinHeight(914.0);

		MainWindowController mainWindowController = loader.getController();

		mainWindowController.initialize(primaryStage);

		Scene scene = new Scene(pane);
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args)
	{
		launch(args);
	}
}