package controller;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import model.DeserializationFailedException;
import model.ReportGenerator;
import model.StaffMember;
import model.StaffMemberSerializer;
import view.CirclePosition;

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
	@FXML
	private Circle circle;
	
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
				(ov, oldVal, newVal) -> makeCircleMarkingOfficeVisible());
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

		for (int i = 0; i < 10; i += 15)
		{
			minutes.add("0" + String.valueOf(i));
		}

		for (int i = 15; i < 60; i += 15)
		{
			minutes.add(String.valueOf(i));
		}

		comboBoxMmFrom.setItems(minutes);
		comboBoxMmTo.setItems(minutes);
	}

	private void setDefaultSelectionForComboBoxes()
	{
		comboBoxHhFrom.getSelectionModel().selectFirst();
		comboBoxHhTo.getSelectionModel().selectLast();
		comboBoxMmFrom.getSelectionModel().selectFirst();
		comboBoxMmTo.getSelectionModel().selectFirst();
		officeNumberComboBox.getSelectionModel().selectFirst();
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
			Alert alert = new Alert(AlertType.INFORMATION, "Please select a valid text file", ButtonType.OK);
			alert.showAndWait();

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

	@FXML
	private void handleReportClick()
	{
		if (staffMemberList.isEmpty())
		{
			return;
		}
		if (pathToReportFileIsNotSelected())
		{
			pathSelector.getPathToReportFile();

			if (pathToReportFileIsNotSelected())
			{
				return;
			}
		}
		
		ReportGenerator rg = new ReportGenerator();
		ArrayList<StaffMember> listToSort = new ArrayList<StaffMember>();
		ArrayList<StaffMember> sortedList = new ArrayList<StaffMember>();
		
		for (StaffMember s : staffMemberList)
		{
			listToSort.add(s);
		}
		
		sortedList = rg.generateReport(listToSort);
		StaffMemberSerializer serializer = new StaffMemberSerializer();
		serializer.serializeReport(sortedList, pathSelector.pathToReportFile);		
	}
	
	private boolean pathToReportFileIsNotSelected()
	{
		return pathSelector.pathToReportFile == null;
	}

	private void makeCircleMarkingOfficeVisible()
	{
		int officeNumberSelected = staffTableView.getSelectionModel().getSelectedItem().getOfficeNumber();

		switch(officeNumberSelected)
		{
			case 1:
				circle.setLayoutY(CirclePosition.POSITION1.getX());
				circle.setLayoutY(CirclePosition.POSITION1.getY());
				circle.setVisible(true);
				break;

			case 2:
				circle.setLayoutX(CirclePosition.POSITION2.getX());
				circle.setLayoutY(CirclePosition.POSITION2.getY());
				circle.setVisible(true);
				break;

			case 3:
				circle.setLayoutY(CirclePosition.POSITION3.getX());
				circle.setLayoutY(CirclePosition.POSITION3.getY());
				circle.setVisible(true);
				break;

			case 4:
				circle.setLayoutX(CirclePosition.POSITION4.getX());
				circle.setLayoutY(CirclePosition.POSITION4.getY());
				circle.setVisible(true);
				break;

			case 5:
				circle.setLayoutY(CirclePosition.POSITION5.getX());
				circle.setLayoutY(CirclePosition.POSITION6.getY());
				circle.setVisible(true);
				break;

			case 6:
				circle.setLayoutX(CirclePosition.POSITION6.getX());
				circle.setLayoutY(CirclePosition.POSITION6.getY());
				circle.setVisible(true);
				break;

			case 7:
				circle.setLayoutY(CirclePosition.POSITION7.getX());
				circle.setLayoutY(CirclePosition.POSITION7.getY());
				circle.setVisible(true);
				break;

			case 8:
				circle.setLayoutX(CirclePosition.POSITION8.getX());
				circle.setLayoutY(CirclePosition.POSITION8.getY());
				circle.setVisible(true);
				break;

			case 9:
				circle.setLayoutY(CirclePosition.POSITION9.getX());
				circle.setLayoutY(CirclePosition.POSITION9.getY());
				circle.setVisible(true);
				break;

			case 10:
				circle.setLayoutX(CirclePosition.POSITION10.getX());
				circle.setLayoutY(CirclePosition.POSITION10.getY());
				circle.setVisible(true);
				break;

			case 11:
				circle.setLayoutY(CirclePosition.POSITION11.getX());
				circle.setLayoutY(CirclePosition.POSITION11.getY());
				circle.setVisible(true);
				break;

			case 12:
				circle.setLayoutX(CirclePosition.POSITION12.getX());
				circle.setLayoutY(CirclePosition.POSITION12.getY());
				circle.setVisible(true);
				break;

			default:
				circle.setVisible(false);

		}


	}


	@FXML
	private void closeStage()
	{
		primaryStage.close();
	}
}
