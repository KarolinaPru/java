package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Person;

public class MainWindowController {
	private Main main;
	private Stage primaryStage;

	@FXML
	private TableView<Person> tableView;
	@FXML
	private TableColumn<Person, String> firstNameColumn, lastNameColumn, ageColumn;
	@FXML
	private Button closeButton, addButton;
	@FXML
	private TextField txtFieldFirstName, txtFieldLastName, txtFieldAge;

	// Obserwowanie listy osób i jej zmian
	private ObservableList<Person> personList = FXCollections.observableArrayList();

	private void setTable() {
		personList.add(new Person("Charlie", "Brown", "10"));
		personList.add(new Person("Matt", "Murdock", "30"));
		personList.add(new Person("Zdenek", "Kutićka", "49"));
		personList.add(new Person("Elena", "Ramirez", "62"));
	}

	// dodajemy primaryStage ze względu na zamykanie okienka - sceny
	public void setMain(Main main, Stage primaryStage) {
		this.main = main;
		this.primaryStage = primaryStage;
		setTable();
		tableView.setItems(personList);
	}

	// Chcemy, zeby każda kolumna wiedziała, które pole klasy Person będzie
	// stanowiło treść tej kolumny
	public void initialize() {
		firstNameColumn.setCellValueFactory(
				// Będziemy pobierać z klasy Person zawartośc pola, które jest
				// Stringiem
				new PropertyValueFactory<Person, String>("firstName"));

		lastNameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));

		ageColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("age"));

		// Żeby to działało i żeby oldVal i newVal było typu Person, trzeba to
		// zaznaczyć w polu TableView<Person>
		tableView.getSelectionModel().selectedItemProperty().addListener(
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
		String firstName = txtFieldFirstName.getText();
		String lastName = txtFieldLastName.getText();
		String age = txtFieldAge.getText();

		Person person = new Person(firstName, lastName, age);
		personList.add(person);
		
		txtFieldFirstName.clear();
		txtFieldLastName.clear();
		txtFieldAge.clear();
	}
}
