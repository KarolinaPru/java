package controller;

import java.util.ArrayList;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Callback;
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
	private TextField firstNameTextField;
	@FXML
	private TextField lastNameTextField;
	@FXML
	private ComboBox<Integer> officeNumberComboBox;
	@FXML
	private ComboBox<String> comboBoxMmFrom;
	@FXML
	private ComboBox<String> comboBoxMmTo;
	@FXML
	private ComboBox<String> comboBoxHhFrom;
	@FXML
	private ComboBox<String> comboBoxHhTo;
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

		staffTableView.getSelectionModel().selectedItemProperty()
		.addListener((ov, oldVal, newVal) -> markProperOfficeWithCircle());
		
		displayInfoAboutStaffMemberWhenClickedOn();

		allowStaffMemberDeletionFromTheList();

	}

	private void displayInfoAboutStaffMemberWhenClickedOn()
	{
		staffTableView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) ->
		{
			StaffMember selectedMember = staffTableView.getSelectionModel().getSelectedItem();
			String firstName = selectedMember.getFirstName();
			String lastName = selectedMember.getLastName();
			String hhFrom = selectedMember.getHoursFrom();
			String mmFrom = selectedMember.getMinutesFrom();
			String hhTo = selectedMember.getHoursTo();
			String mmTo = selectedMember.getMinutesTo();
			int officeNo = selectedMember.getOfficeNumber();

			firstNameTextField.setText(firstName);
			lastNameTextField.setText(lastName);
			officeNumberComboBox.setValue(officeNo);
			comboBoxHhFrom.setValue(hhFrom);
			comboBoxMmFrom.setValue(mmFrom);
			comboBoxHhTo.setValue(hhTo);
			comboBoxMmTo.setValue(mmTo);
		});
	}

	private void allowStaffMemberDeletionFromTheList()
	{
		staffTableView.setRowFactory(new Callback<TableView<StaffMember>, TableRow<StaffMember>>()
		{
			@Override
			public TableRow<StaffMember> call(TableView<StaffMember> tableView)
			{
				final TableRow<StaffMember> row = new TableRow<>();
				final ContextMenu rowMenu = new ContextMenu();
				MenuItem removeItem = new MenuItem("Delete from the list");
				removeItem.setOnAction(new EventHandler<ActionEvent>()
				{
					@Override
					public void handle(ActionEvent event)
					{
						staffTableView.getItems().remove(row.getItem());
					}
				});
				rowMenu.getItems().add(removeItem);

				row.contextMenuProperty().bind(Bindings.when(Bindings.isNotNull(row.itemProperty())).then(rowMenu)
				.otherwise((ContextMenu) null));
				
				return row;
			}

			private void displayContextMenuForNonNullElements(final TableRow<StaffMember> row,
					final ContextMenu rowMenu)
			{
				row.contextMenuProperty().bind(Bindings.when(Bindings.isNotNull(row.itemProperty())).then(rowMenu)
						.otherwise((ContextMenu) null));
			}
		});
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

	@FXML
	private void handleAddButtonClick()
	{
		String validInput = ("[A-Za-z]+\\-{0,1}[A-Za-z]+");

		String firstName = firstNameTextField.getText();
		String lastName = lastNameTextField.getText();

		if (firstName.matches(validInput) && lastName.matches(validInput))
		{
			addStaffMemberToTheList(firstName, lastName);

			firstNameTextField.clear();
			lastNameTextField.clear();
			setDefaultSelectionForComboBoxes();
		}
	}

	private void addStaffMemberToTheList(String firstName, String lastName)
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
		else
		{
			return;
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

		saveSortedListInSelectedFile();
	}

	private void saveSortedListInSelectedFile()
	{
		ReportGenerator rg = new ReportGenerator();
		ArrayList<StaffMember> listToSort = new ArrayList<StaffMember>();
		ArrayList<StaffMember> sortedList;

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

	private void markProperOfficeWithCircle()
	{
		int officeNumberSelected = staffTableView.getSelectionModel().getSelectedItem().getOfficeNumber();

		switch (officeNumberSelected)
		{
		case 1:
			setCirclePosition(CirclePosition.POSITION1.getX(), CirclePosition.POSITION1.getY());
			break;

		case 2:
			setCirclePosition(CirclePosition.POSITION2.getX(), CirclePosition.POSITION2.getY());
			break;

		case 3:
			setCirclePosition(CirclePosition.POSITION3.getX(), CirclePosition.POSITION3.getY());
			break;

		case 4:
			setCirclePosition(CirclePosition.POSITION4.getX(), CirclePosition.POSITION4.getY());
			break;

		case 5:
			setCirclePosition(CirclePosition.POSITION5.getX(), CirclePosition.POSITION5.getY());
			break;

		case 6:
			setCirclePosition(CirclePosition.POSITION6.getX(), CirclePosition.POSITION6.getY());
			break;

		case 7:
			setCirclePosition(CirclePosition.POSITION7.getX(), CirclePosition.POSITION7.getY());
			break;

		case 8:
			setCirclePosition(CirclePosition.POSITION8.getX(), CirclePosition.POSITION8.getY());
			break;

		case 9:
			setCirclePosition(CirclePosition.POSITION9.getX(), CirclePosition.POSITION9.getY());
			break;

		case 10:
			setCirclePosition(CirclePosition.POSITION10.getX(), CirclePosition.POSITION10.getY());
			break;

		case 11:
			setCirclePosition(CirclePosition.POSITION11.getX(), CirclePosition.POSITION11.getY());
			break;

		case 12:
			setCirclePosition(CirclePosition.POSITION12.getX(), CirclePosition.POSITION12.getY());
			break;

		default:
			circle.setVisible(false);
		}
	}

	private void setCirclePosition(double positionX, double positionY)
	{
		circle.setLayoutX(positionX);
		circle.setLayoutY(positionY);
		circle.setVisible(true);
	}
}
