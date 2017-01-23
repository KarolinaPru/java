package javaFX;

import java.util.*;

import javafx.application.Application;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,450,450);
			// Class loader wie, skąd zassać zasoby do programu, tutaj: w katalogu 
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			//etykieta z napisem
			Label label = new Label("Hi Mate!");
			Label label1 = new Label("How are you doing?");

			//kontener porządkujacy elementy w pionie
			VBox left_vbox = new VBox(10);
			left_vbox.getChildren().add(label);
			left_vbox.getChildren().add(label1);
			root.setLeft(left_vbox);

			//Utworzenie kontenera typu Group
			Group center_group = new Group();
			root.setCenter(center_group);

			//dodanie pola tekstowego - setLayout w obrębie grupy
			TextField text1 = new TextField();
			text1.getStyleClass().add("my-field");
			text1.setLayoutX(10);
			text1.setLayoutY(10);
			center_group.getChildren().add(text1);

			//dodanie pola tekstowego nr 2
			TextField text2 = new TextField();
			text2.getStyleClass().add("my-field");
			text2.setLayoutX(10);
			text2.setLayoutY(60);
			center_group.getChildren().add(text2);
			
			// Dodajemy radio button i umieszczamy w ToggleGroup, żeby tylko 1 mógł być włączony
			// Button1 ma informację o tym, który jest wybrany
			RadioButton radioButton1 = new RadioButton("1");
			radioButton1.setUserData("1 has been selected");
			RadioButton radioButton2 = new RadioButton("2");
			radioButton2.setUserData("2 has been selected");
			ToggleGroup toggle_group = new ToggleGroup();
			radioButton1.setToggleGroup(toggle_group);
			radioButton2.setToggleGroup(toggle_group);
			//Można ustawić domyślnie zaznaczony guzik, żeby nie walnęło błędem
			toggle_group.selectToggle(radioButton1);
			//Sprawdzamy, czy stan się nie zmienił. Jeśli tak, druk na konsolę, który jest zaznaczony
			// Nie ma potrzeby angażować button1
			toggle_group.selectedToggleProperty().addListener(
					(ov, oldToggle, newToggle) -> 
					{
					if (toggle_group.getSelectedToggle() != null)
						System.out.println(
							toggle_group.getSelectedToggle().getUserData().toString()
							);		
					} 
					);
			
			//kontener, który będzie przechowywał oba przyciski
			VBox right_vbox = new VBox(15);
			right_vbox.getChildren().add(radioButton1);
			right_vbox.getChildren().add(radioButton2);
			root.setRight(right_vbox);
			
			// dodanie przycisku do okna dialogowego
			Button button1 = new Button();
			button1.setId("my-button1");
			button1.setText("Let's do some magic!");
			button1.setOnAction(
					event -> 
					{
						System.out.println("You've made the right choice!");
						System.out.println(text1.getText());

						//Spr, czy zawartość jest nr tel w formacie xxx-xx-xx
						if (text1.getText().matches("[0-9]{3}-[0-9]{2}-[0-9]{2}")) {
							System.out.println("Good, it's a phone number");
						Alert alert = new Alert(
							AlertType.INFORMATION, 
							"You have typed in a phone number correctly");
						Optional<ButtonType> result = alert.showAndWait();

						//sprawdzenie jakim przyciskiem zamknięto okno
						if(result.isPresent() && result.get() == ButtonType.OK)
							System.out.println("Message window closed with OK button");
						}
						
						//Chcę się dowiedzieć, który radio button jest naciśnięty i czy nie jest pusty - inaczej błąd
						if (toggle_group.getSelectedToggle() != null)
						System.out.println(
							toggle_group.getSelectedToggle().getUserData().toString()
							);
					}			
					);

			Button button2 = new Button();
			button2.setText("Click me");
			button2.setOnAction(
					event ->  
					{
						System.out.println("You clicked me, nice!");					

						//utworzenie nowego okna
						Stage stage = new Stage();
						stage.setTitle("Dialog box");
						//korzeń grafu sceny okna dialogowego
						BorderPane rootDialog = new BorderPane();
						stage.setScene(new Scene(rootDialog));

						Label message = new Label("Hop hoooop!");
						rootDialog.setCenter(message);

						stage.initOwner(primaryStage);
						stage.initModality(Modality.WINDOW_MODAL);
						stage.show();
					}
					);

			Button button3 = new Button();
			button3.setText("Check group symbol");
			button3.setOnAction(
					event ->
					{
						//Sprawdzamy, czy poprawny sumbol grupy
						if (text2.getText().matches("(JA|GK|BD|DS)\\d{2}[LZ]\\d{2}")) 
						{
							String test = text2.getText().substring(2, 4);
							int year = Integer.parseInt(test);
							if (year >= 15 && year <= 20)
								System.out.println("Yes, that's a group symbol");
						}
					});

			//dodanie w sekcji bottom elementu grupującego w poziomie
			HBox bottom_hbox = new HBox(10); 
			bottom_hbox.getChildren().add(button1);
			bottom_hbox.getChildren().add(button2);
			bottom_hbox.getChildren().add(button3);
			root.setBottom(bottom_hbox);

			// Dodajemy obrazek
			Image test_image = new Image(getClass().getResourceAsStream("indeks.jpg"));
			ImageView test_image_view = new ImageView(test_image);
			root.setTop(test_image_view);
			
			
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}


	public static void main(String[] args) {
		launch(args);
	}
}
