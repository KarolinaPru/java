package controller;

import java.util.ArrayList;
import java.util.regex.Pattern;

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

	private ObservableList<StaffMember> staffMemberList = FXCollections.observableArrayList();


	public void setMain(Main main, Stage primaryStage) {
		this.main = main;
		this.primaryStage = primaryStage;
		staffTableView.setItems(staffMemberList);
	}

	
	public void initialize() {
		firstNameColumn.setCellValueFactory(new PropertyValueFactory<StaffMember, String>("firstName"));

		lastNameColumn.setCellValueFactory(new PropertyValueFactory<StaffMember, String>("lastName"));

		officeNumberColumn.setCellValueFactory(new PropertyValueFactory<StaffMember, Integer>("officeNumber"));

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

	//TODO: block unwanted input whatsoever
	private void allowOnlyDoublesInTextFields()
	{
		// Compiles the given regular expression into a pattern.
		Pattern validInteger = Pattern.compile("\\d*");

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
		String sOfficeNumber = officeNumberTextField.getText();
		String sWorkingFrom = workingFromTextField.getText();	
		String sWorkingTo = workingToTextField.getText();
		
		if (isInteger(sOfficeNumber) 
				&& isInteger(sWorkingFrom) 
				&& isInteger(sWorkingTo)
				&& !isInteger(firstName)
				&& !isInteger(lastName))

		{
			int officeNumber = Integer.parseInt(sOfficeNumber);
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
	
	@FXML
	private void handleLoadClick()
	{
		StaffMemberSerializer serializer = new StaffMemberSerializer();
		ArrayList<StaffMember> loadedStaffList = serializer.deserialize();
		
		staffMemberList.clear();
	
		for (StaffMember s : loadedStaffList)
		{
			staffMemberList.add(s);
		}
	}
	
	@FXML
	private void handleSaveClick()
	{
		StaffMemberSerializer serializer = new StaffMemberSerializer();
		ArrayList<StaffMember> listToSerialize = new ArrayList<StaffMember>();
		
		for (StaffMember s : staffMemberList)
		{
			listToSerialize.add(s);
		}
		serializer.serialize(listToSerialize);
	}
}
