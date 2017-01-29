package controller;

import javafx.stage.Stage;

public class MainWindowController
{
	private Stage primaryStage;
	private Main main;

	public void setMain(Main main, Stage primaryStage)
	{
		this.main = main;
		this.primaryStage = primaryStage;
	}
}
