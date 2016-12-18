package application;

import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.NumberBinding;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root, 400, 400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// launch(args);

		Bill electricBill = new Bill();
		electricBill.amountDueProperty().addListener((observableValue, oldValue, newValue) -> {
			System.out.println("The bill has changed.");
		});
		electricBill.setAmountDue(100.0);
		electricBill.setAmountDue(50.0);

		// ==========================================================================

		IntegerProperty num1 = new SimpleIntegerProperty(1);
		IntegerProperty num2 = new SimpleIntegerProperty(1);
		IntegerProperty num3 = new SimpleIntegerProperty(3);
		IntegerProperty num4 = new SimpleIntegerProperty(4);

		// Uzycie Fluent API
		// Za kazdym razem jak zmieni sie wartosc skladnikow, suma bedzie
		// uaktualniona
		NumberBinding sum = num1.add(num2);

		// Uzycie klasy Bindings
		NumberBinding total = Bindings.add(num1.multiply(num2), num3.multiply(num4));

		System.out.println("Sum before: " + sum.getValue());
		System.out.println("Total before: " + total.getValue());
		num1.set(2);

		System.out.println("Sum after: " + sum.getValue());
		System.out.println("Total after: " + total.getValue());

		// ===========================================================================

		Bill bill1 = new Bill();
		Bill bill2 = new Bill();
		Bill bill3 = new Bill();

		// WAZNE: dodac amountDueProperty, bo wiazanie dziala na OBIEKTACH
		NumberBinding totalBill =
				Bindings.add(
				  bill1.amountDueProperty().add(bill2.amountDueProperty()),
				  bill3.amountDueProperty());

		totalBill.addListener(
				new InvalidationListener()
				{

				@Override
				public void invalidated(Observable observable) 
				{
				
					System.out.println("Binding invalid.");
				}
				});
		
		bill1.setAmountDue(200.0);  		// Binding invalid - przez to funcja wywolywana tylko raz
		bill2.setAmountDue(50.0);			// Dopiero po kolejnym odczycie wartosci
		bill3.setAmountDue(500.0);
		
		System.out.println(totalBill.getValue());		// Wartosc staje sie wazna przy nowym przeliczeniu 
		
		bill1.setAmountDue(1000.0);				// Znowu invalid
		
		
		// ===========================================================================

		Bill bill4 = new Bill();
		Bill bill5 = new Bill();
		Bill bill6 = new Bill();

		// WAZNE: dodac amountDueProperty, bo wiazanie dziala na OBIEKTACH
		NumberBinding totalBill2 =
				Bindings.add( 
				  bill4.amountDueProperty().add(bill5.amountDueProperty()),
				  bill6.amountDueProperty());

		totalBill.addListener(
				(ChangeListener) (observable, oldValue, newValue) -> System.out.println("Binding has changed: " + totalBill2));
		
		bill4.setAmountDue(100.0);  		// Binding invalid - przez to funcja wywolywana tylko raz
		bill5.setAmountDue(30.0);			// Dopiero po kolejnym odczycie wartosci
		bill6.setAmountDue(400.0);
		
		System.out.println(totalBill2.getValue());		// Wartosc staje sie wazna przy nowym przeliczeniu 
		
		bill5.setAmountDue(4000.0);				// Znowu invalid
		System.out.println(totalBill2.getValue());
	}
}
