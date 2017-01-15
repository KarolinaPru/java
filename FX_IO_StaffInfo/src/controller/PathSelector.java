package controller;

import java.io.File;

import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class PathSelector
{
	public String pathToLoadFile;
	public String pathToSaveFile;
	private Stage primaryStage;

	public PathSelector(Stage primaryStage)
	{
		this.primaryStage = primaryStage;
	}
	
	public void getPathToLoadFile()
	{
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Load a file");
		fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Text files", "*.txt"));

		File selectedFile = fileChooser.showOpenDialog(primaryStage);

		if (selectedFile != null)
		{
			pathToLoadFile = selectedFile.getAbsolutePath();
		}
	}

	public void getPathToSaveFile()
	{
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Save");
		fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Text files", "*.txt"));

		File selectedFile = fileChooser.showSaveDialog(primaryStage);

		if (selectedFile != null)
		{
			pathToSaveFile = selectedFile.getAbsolutePath();
		}
	}
}