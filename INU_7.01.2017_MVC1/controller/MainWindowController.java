package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Person;

public class MainWindowController 
{
	public Person person;
	private Main main;
	
	// Inicjalizacje kontrolek zostaną wykonane automatycznie, jeśli te same nazwy, co w fxmlu
	@FXML private Button button;
	@FXML private TextField txtField;
	@FXML private Label label;
	
	// Trzeba wywołać w Main
	// INicjalizyjemt osobę
	public void setMain(Main main)
	{
		this.main = main;
		person = new Person("Charlie");
	}
	
	// W SceneBuilderze zapisujemy tę funkcję w polu OnAction
	@FXML
	public void handleButton()
	{
		System.out.println("Button pressed.");
		String text = txtField.getText();
		person.setFirstName(text);
		
		label.setText(person.getFirstName());
		txtField.clear();
	}
	
}
 