package controller;

import javafx.fxml.FXML;
import javafx.stage.Stage;

public class MainWindowController
{
	private Main main;
	private Stage primaryStage;

	public void setMain(Main main, Stage primaryStage) {
		this.main = main;
		this.primaryStage = primaryStage;

	}
	
	@FXML
	private void closeStage() {
		primaryStage.close();
	}
	
}
