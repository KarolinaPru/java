package controller;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.DeserializationFailedException;
import model.StaffMember;
import model.StaffMemberSerializer;

public class MainWindowController
{
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
	private ComboBox<String> comboBoxMmFrom, comboBoxMmTo, comboBoxHhFrom, comboBoxHhTo;
	private ObservableList<StaffMember> staffMemberList = FXCollections.observableArrayList();
	private PathSelector pathSelector;

	public void initialize(Stage primaryStage)
	{
		this.primaryStage = primaryStage;
		pathSelector = new PathSelector(primaryStage);
		initializeComboBoxes();
		bindTableColumnsToStaffMemberList();
	}

	private void bindTableColumnsToStaffMemberList()
	{
		staffTableView.setItems(staffMemberList);
		
		firstNameColumn.setCellValueFactory(new PropertyValueFactory<StaffMember, String>("firstName"));

		lastNameColumn.setCellValueFactory(new PropertyValueFactory<StaffMember, String>("lastName"));

		officeNumberColumn.setCellValueFactory(new PropertyValueFactory<StaffMember, Integer>("officeNumber"));

		staffTableView.getSelectionModel().selectedItemProperty().addListener(
				(ov, oldVal, newVal) -> System.out.println(newVal.getFirstName() + " " + newVal.getLastName()));
	}

	private void initializeComboBoxes()
	{
		addOfficeNumbersToComboBox();
		addHoursToComboBoxes();
		addMinutesToComboBoxes();
		setDefaultSelectionForComboBoxes();
	}

	private void addOfficeNumbersToComboBox()
	{
		ObservableList<Integer> officeNumbers = FXCollections.observableArrayList();

		for (int i = 1; i < 13; i++)
		{
			officeNumbers.addAll(i);
		}

		officeNumberComboBox.setItems(officeNumbers);
		officeNumberComboBox.getSelectionModel().selectFirst();
	}

	private void addHoursToComboBoxes()
	{
		ObservableList<String> hours = FXCollections.observableArrayList();

		for (int i = 7; i < 10; i++)
		{
			hours.add("0" + String.valueOf(i));
		}
		for (int i = 10; i < 20; i++)
		{
			hours.add(String.valueOf(i));
		}
		comboBoxHhFrom.setItems(hours);
		comboBoxHhTo.setItems(hours);
	}

	private void addMinutesToComboBoxes()
	{
		ObservableList<String> minutes = FXCollections.observableArrayList();

		for (int i = 0; i < 10; i+=15)
		{
			minutes.add("0" + String.valueOf(i));
		}

		for (int i = 15; i < 60; i+=15)
		{
			minutes.add(String.valueOf(i));
		}

		comboBoxMmFrom.setItems(minutes);	
		comboBoxMmTo.setItems(minutes);
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

		if (!isInteger(firstName) && !isInteger(lastName))

		{
			int officeNumber = officeNumberComboBox.getValue();
			String workingFromHours = comboBoxHhFrom.getValue();
			String workingFromMinutes = comboBoxMmFrom.getValue();
			String workingFrom = workingFromHours + ":" + workingFromMinutes;

			String workingToHours = comboBoxHhTo.getValue();
			String workingToMinutes = comboBoxMmTo.getValue();
			String workingTo = workingToHours + ":" + workingToMinutes;

			StaffMember sm = new StaffMember(firstName, lastName, officeNumber, workingFrom, workingTo);
			staffMemberList.add(sm);

			firstNameTextField.clear();
			lastNameTextField.clear();
			setDefaultSelectionForComboBoxes();
		}
	}

	private void setDefaultSelectionForComboBoxes()
	{
		comboBoxHhFrom.getSelectionModel().selectFirst();
		comboBoxHhTo.getSelectionModel().selectLast();	
		comboBoxMmFrom.getSelectionModel().selectFirst();
		comboBoxMmTo.getSelectionModel().selectFirst();
		officeNumberComboBox.getSelectionModel().selectFirst();
	}

	@FXML
	private void handleLoadClick()
	{
		if (pathToLoadFileIsNotSelected())
		{
			pathSelector.getPathToLoadFile();

			if (pathToLoadFileIsNotSelected())
			{
				return;
			}
		}
		StaffMemberSerializer serializer = new StaffMemberSerializer();
		ArrayList<StaffMember> loadedStaffList;
		
		try
		{
			loadedStaffList = serializer.deserialize(pathSelector.pathToLoadFile);
		} catch (DeserializationFailedException e)
		{
			pathSelector.pathToLoadFile = null;
			return;
		}

		staffMemberList.clear();

		for (StaffMember s : loadedStaffList)
		{
			staffMemberList.add(s);
		}
	}

	private boolean pathToLoadFileIsNotSelected()
	{
		return pathSelector.pathToLoadFile == null;
	}

	@FXML
	private void handleSaveClick()
	{
		if (pathToSaveFileIsNotSelected())
		{
			pathSelector.getPathToSaveFile();

			if (pathToSaveFileIsNotSelected())
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
		serializer.serialize(listToSerialize, pathSelector.pathToSaveFile);
	}

	private boolean pathToSaveFileIsNotSelected()
	{
		return pathSelector.pathToSaveFile == null;
	}
}
