package application;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.CubicCurve;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurve;
import javafx.scene.shape.QuadCurveTo;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeType;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Group root = new Group();
			Scene scene = new Scene(root,400,400, Color.rgb(44, 202, 217));
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			Line redLine = new Line(10, 10, 200, 10);
			redLine.setStroke(Color.RED);
			redLine.setStrokeWidth(10);
			//typ zakonczenia
			redLine.setStrokeLineCap(StrokeLineCap.ROUND);
			
			Line blueLine = new Line(10, 100, 300, 15);
			blueLine.setStroke(Color.BLUE);
			blueLine.setStrokeWidth(5);
			// typ zakonczenia
			blueLine.setStrokeLineCap(StrokeLineCap.BUTT);
			
			// Dodajemy wzorzec jak mają wyglądać kolejne kreski i przerwy
			blueLine.getStrokeDashArray().addAll(20d, 10d, 5d, 5d);
			
			// Zaczyna wzór od wybranego miejsca
			blueLine.setStrokeDashOffset(50);
						
			root.getChildren().add(redLine);
			root.getChildren().add(blueLine);
			
			// Suwak: wart. min, max i aktualna
			Slider slider = new Slider(0, 200, 0); 
			slider.setLayoutX(10);
			slider.setLayoutY(70);
			slider.setOrientation(Orientation.VERTICAL);
			root.getChildren().add(slider);
			
			blueLine.strokeDashOffsetProperty().bind(slider.valueProperty());
			
			CubicCurve cubicCurve = new CubicCurve(
					50, 	// start x
					75, 	// start y
					80, 	// controlPoint1 x
					-25, 	// controlPoint1 y
					110, 	// controlPoint2 x	
					175, 	// controlPoint2 y
					140,	// end x
					75		// end y
					);
			
			cubicCurve.setStrokeType(StrokeType.CENTERED);
			cubicCurve.setStroke(Color.rgb(200, 100, 200));
			cubicCurve.setStrokeWidth(3);
			// Dzięki temu nie ma wypełnienia całego kształtu, tyko linia
			cubicCurve.setFill(Color.TRANSPARENT);
			root.getChildren().add(cubicCurve);	
			
			
			// Rysowanie po ścieżce
			Path path = new Path();
			path.setStrokeWidth(3);
			MoveTo moveTo = new MoveTo(50, 150);
			//  moveTo.setX(50);
			// moveTo.setY(150);
			
			path.getElements().addAll(moveTo);
			root.getChildren().add(path);
			
			// Rysujemy ice-cream cone
			// Krzywa Beziera
			QuadCurveTo quadCurveTo = new QuadCurveTo();
			quadCurveTo.setX(150);
			quadCurveTo.setY(150);
			// Punkt kontrolny
			quadCurveTo.setControlX(100);
			quadCurveTo.setControlY(50);
			path.getElements().add(quadCurveTo);
			
			LineTo lineTo1 = new LineTo(50,150);
			LineTo lineTo2 = new LineTo(100, 275);
			LineTo lineTo3 = new LineTo(150, 150);
			
			path.getElements().add(lineTo1);
			path.getElements().add(lineTo2);
			path.getElements().add(lineTo3);
			
			path.setTranslateX(50);
			path.setTranslateY(100);
			
			Ellipse bigCircle = new Ellipse(
					100, 	// współrzędne środka: center x
					100,	// center y
					50, 	// radius x
					36		// radius y
					);
			
			Ellipse smallCircle = new Ellipse(
					100, 	// współrzędne środka: center x
					100,	// center y
					20, 	// radius x
					16		// radius y
					);
			
			// Checmy 1 elipsą wyciąć środek drugiej: donut
			Shape donut = Path.subtract(bigCircle, smallCircle);
			donut.setTranslateX(180);
			donut.setTranslateY(100);
			donut.setFill(Color.rgb(255, 200, 0));
			donut.setStroke(Color.BLACK);
			donut.setStrokeWidth(2);
			
			// Dodajemy cień
			DropShadow dropShadow = new DropShadow(
					5, 		// radius
					12.0,	// offset X
					12.0,	//offset Y
					Color.rgb(50, 50, 50, 1)	// ostatnia wartość: Alpha = przezroczystość
						);
			donut.setEffect(dropShadow);
			root.getChildren().add(donut);

			
			// Prostokąt z wypełnieniem gradientowym
			Rectangle roundRect = new Rectangle();
			roundRect.setX(50);
			roundRect.setY(50);
			roundRect.setWidth(100);
			roundRect.setHeight(70);
			
			// Zaokrąglenie brzegów
			roundRect.setArcWidth(20);
			roundRect.setArcHeight(20);
			
//			Ustawianie względem innych elementów, tutaj nie wygląda dobrze 
//			roundRect.setTranslateX(path.getBoundsInParent().getWidth() + 20);
//			roundRect.setTranslateY(donut.getBoundsInParent().getHeight() + 20);
			roundRect.setTranslateX(180);
			roundRect.setTranslateY(250);
			
			LinearGradient gradient1 = new LinearGradient(
					50,		// start x
					50,		// start y
					150,		// end x
					100,		// end y
					false,	// proportional
					CycleMethod.REFLECT,	 
					new Stop(1f, Color.rgb(171, 57, 132)),
					new Stop(0f, Color.rgb(0, 255, 0))
		//			new Stop(0f, Color.rgb(50, 0, 100))				Trzeba zdefiniować punkty
					);
			
			roundRect.setFill(gradient1);
			root.getChildren().add(roundRect);
			
			// Wypełnienie radialne
			Ellipse ellipse1 = new Ellipse(200, 200, 70, 70);
			RadialGradient gradient2 = new RadialGradient(
					0,		// focus angle: przesunięcie punktu, z którego wychodzi kolor w stosunku do centralnego
					0,		// focus distance
					220, 	// center x
					250,	// center y
					70,		// radius
					false, 	// proportional
					CycleMethod.NO_CYCLE,
					new Stop(0, Color.RED),
					new Stop(1, Color.BLUE)
					
					); 
			
			ellipse1.setFill(gradient2);
			ellipse1.setTranslateX(100);
			ellipse1.setTranslateY(-120);
			root.getChildren().add(ellipse1);
			
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
