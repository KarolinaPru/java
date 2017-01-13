package controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.StaffMember;

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


	public void setMain(Main main, Stage primaryStage) {
		this.main = main;
		this.primaryStage = primaryStage;
	}
	
	@FXML
	private void closeStage() {
		primaryStage.close();
	}
	
}
