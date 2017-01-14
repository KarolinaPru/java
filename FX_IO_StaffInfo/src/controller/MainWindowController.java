package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
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
    private TextField firstNameTextField, lastNameTextField, officeNumberTextField, workingFromTextField, workingToTextField;
    @FXML
    private Label firstNameLabel, lastNameLabel, officeNumberLabel, workingFromLabel, workingToLabel;
    
    private int id;

	// Obserwowanie listy osób i jej zmian
	private ObservableList<StaffMember> staffMemberList = FXCollections.observableArrayList();

	private void setTable() {
	
		
		new StaffMemberSerializer().deserialize();
	}

	// dodajemy primaryStage ze wzglêdu na zamykanie okienka - sceny
	public void setMain(Main main, Stage primaryStage) {
		this.main = main;
		this.primaryStage = primaryStage;
		setTable();
		staffTableView.setItems(staffMemberList);
	}

	// Chcemy, zeby ka¿da kolumna wiedzia³a, które pole klasy Person bêdzie
	// stanowi³o treœæ tej kolumny
	public void initialize() {
		firstNameColumn.setCellValueFactory(
				// Bêdziemy pobieraæ z klasy Person zawartoœc pola, które jest
				// Stringiem
				new PropertyValueFactory<StaffMember, String>("firstName"));

		lastNameColumn.setCellValueFactory(new PropertyValueFactory<StaffMember, String>("lastName"));

		officeNumberColumn.setCellValueFactory(new PropertyValueFactory<StaffMember, Integer>("officeNumber"));

		// ¯eby to dzia³a³o i ¿eby oldVal i newVal by³o typu Person, trzeba to
		// zaznaczyæ w polu TableView<Person>
		staffTableView.getSelectionModel().selectedItemProperty().addListener(
				(ov, oldVal, newVal) ->
				System.out.println(
					newVal.getFirstName() + "" 
					+ newVal.getLastName())
					);
	}

	@FXML
	private void closeStage() {
		primaryStage.close();
	}

	@FXML
	private void handleAddButtonClick() {
		id = staffMemberList.size();
		String firstName = firstNameTextField.getText();
		String lastName = lastNameTextField.getText();
		int officeNumber = Integer.parseInt(officeNumberTextField.getText());
		int workingFrom = Integer.parseInt(workingToTextField.getText());
		int workingTo = Integer.parseInt(workingToTextField.getText());

		StaffMember sm = new StaffMember(++id, firstName, lastName, officeNumber, workingFrom, workingTo);
		staffMemberList.add(sm);
		
		firstNameTextField.clear();
		lastNameTextField.clear();
		officeNumberTextField.clear();
		workingFromTextField.clear();
		workingToTextField.clear();
		
		
	}
	
}
