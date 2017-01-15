package controller;

import java.io.File;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import model.StaffMember;
import model.StaffMemberSerializer;

public class MainWindowController
{
	private Main main;
	private Stage primaryStage;

	@FXML
	private TableView<StaffMember> staffTableView;
	@FXML
	private TableColumn<StaffMember, String> firstNameColumn, lastNameColumn;
	@FXML
	private TableColumn<StaffMember, Integer> officeNumberColumn;
	@FXML
	private Button addButton, saveButton, loadButton, reportButton;
	@FXML
	private TextField firstNameTextField, lastNameTextField, officeNumberTextField, workingFromTextField,
			workingToTextField;
	@FXML
	private Label firstNameLabel, lastNameLabel, officeNumberLabel, workingFromLabel, workingToLabel;
	@FXML
	private ComboBox<Integer> officeNumberComboBox;
	@FXML
	private ComboBox<String>  comboBoxMmFrom,comboBoxMmTo, comboBoxHhFrom, comboBoxHhTo;
	
	private String pathToFile;
	private ObservableList<StaffMember> staffMemberList = FXCollections.observableArrayList();

	
	public void setMain(Main main, Stage primaryStage)
	{
		this.main = main;
		this.primaryStage = primaryStage;
		staffTableView.setItems(staffMemberList);
		initializeComboBoxes();
	}
	
	private void initializeComboBoxes()
	{
		addOfficeNumbersToComboBox();
		addHoursToComboBoxes();
		addMinutesToComboBoxes();
	}

	private void addOfficeNumbersToComboBox()
	{
		ObservableList<Integer> officeNumbers = FXCollections.observableArrayList();
		
		for (int i=1; i<13; i++)
		{
			officeNumbers.addAll(i);			
		}
		
		officeNumberComboBox.setItems(officeNumbers);
	}

	private void addHoursToComboBoxes()
	{
		ObservableList<String> hours = FXCollections.observableArrayList();
	
		for (int i=0; i < 10; i++)
		{
			hours.add("0" + String.valueOf(i));
		}
		for (int i=10; i<24; i++)
		{
			hours.add(String.valueOf(i));
		}
		comboBoxHhFrom.setItems(hours);
		comboBoxHhTo.setItems(hours);
	}
	
	private void addMinutesToComboBoxes()
	{
		ObservableList<String> minutes = FXCollections.observableArrayList();
		
		for (int i=0; i < 10; i++)
		{
			minutes.add("0" + String.valueOf(i));
		}
		
		for (int i=10; i < 60; i++)
		{
			minutes.add(String.valueOf(i));
		}
		
		comboBoxMmFrom.setItems(minutes);
		comboBoxMmTo.setItems(minutes);
	}
	
	
	public void initialize()
	{
		firstNameColumn.setCellValueFactory(new PropertyValueFactory<StaffMember, String>("firstName"));

		lastNameColumn.setCellValueFactory(new PropertyValueFactory<StaffMember, String>("lastName"));

		officeNumberColumn.setCellValueFactory (new PropertyValueFactory<StaffMember,Integer>("officeNumber"));

		staffTableView.getSelectionModel().selectedItemProperty().addListener(
				(ov, oldVal, newVal) -> System.out.println(newVal.getFirstName() + " " + newVal.getLastName()));
	}

	@FXML
	private void closeStage()
	{
		primaryStage.close();
	}


	private static boolean isInteger(String str)
	{
		return str.matches("\\d*");
	}

	@FXML
	private void handleAddButtonClick()
	{

		String firstName = firstNameTextField.getText();
		String lastName = lastNameTextField.getText();
		String sWorkingFrom = comboBoxHhFrom.getValue();
		String sWorkingTo = comboBoxHhTo.getValue();

		if (!isInteger(firstName) && !isInteger(lastName))

		{
		
			int officeNumber = officeNumberComboBox.getValue();
			int workingFrom = Integer.parseInt(sWorkingFrom);
			int workingTo = Integer.parseInt(sWorkingTo);

			StaffMember sm = new StaffMember(firstName, lastName, officeNumber, workingFrom, workingTo);
			staffMemberList.add(sm);

			firstNameTextField.clear();
			lastNameTextField.clear();
			officeNumberTextField.clear();
			workingFromTextField.clear();
			workingToTextField.clear();
		}
		return;

	}

	private String getPathToLoadFile()
	{
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Load a file");
		fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Text files", "*.txt"));

		File selectedFile = fileChooser.showOpenDialog(primaryStage);

		if (selectedFile != null)
		{
			return selectedFile.getAbsolutePath();
		}
		return null;
	}

	private String getPathToSaveFile()
	{
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Save");
		fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Text files", "*.txt"));

		File selectedFile = fileChooser.showSaveDialog(primaryStage);

		if (selectedFile != null)
		{
			return selectedFile.getAbsolutePath();
		}
		return null;
	}

	@FXML
	private void handleLoadClick()
	{
		if (pathToFile == null)
		{
			pathToFile = getPathToLoadFile();

			if (pathToFile == null)
			{
				return;
			}
		}
		StaffMemberSerializer serializer = new StaffMemberSerializer();
		ArrayList<StaffMember> loadedStaffList = serializer.deserialize(pathToFile);

		staffMemberList.clear();

		for (StaffMember s : loadedStaffList)
		{
			staffMemberList.add(s);
		}
	}

	@FXML
	private void handleSaveClick()
	{
		if (pathToFile == null)
		{
			pathToFile = getPathToSaveFile();

			if (pathToFile == null)
			{
				return;
			}
		}
		StaffMemberSerializer serializer = new StaffMemberSerializer();
		ArrayList<StaffMember> listToSerialize = new ArrayList<StaffMember>();

		for (StaffMember s : staffMemberList)
		{
			listToSerialize.add(s);
		}
		serializer.serialize(listToSerialize, pathToFile);
	}
}
