package controller;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.ParallelTransition;
import javafx.animation.PathTransition;
import javafx.animation.PauseTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.animation.PathTransition.OrientationType;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MainWindowController {

	@FXML
	private Group fish1;
	@FXML
	private Group fish2;
	private Animation animation;
	@FXML
	Button watchUsButton;
	@FXML
	Ellipse bubble1, bubble2, bubble3, bubble4;

	private Main main;
	private Stage primaryStage;

	public void setMain(Main main, Stage primaryStage) {

		this.main = main;
		this.primaryStage = primaryStage;

	}

	@FXML
	public void playAnimation() {
	
		moveFish21AlongACurve();
		bounceTheFish();
		bubbleEffect();

	}

	private void bounceTheFish() {
				
		TranslateTransition tt = new TranslateTransition();
		tt.setDuration(Duration.seconds(7));
		tt.setByX(400);
		tt.setByY(200);

		ScaleTransition st1 = new ScaleTransition();
		st1.setDuration(Duration.millis(500));
		st1.setFromX(0.9);
		st1.setToX(1.1); // rectangle's width: increase
		st1.setFromY(1.1);
		st1.setToY(0.9); // height: decrease

		ScaleTransition st2 = new ScaleTransition();
		st2.setDuration(Duration.millis(300));
		st2.setFromX(1.1);
		st2.setToX(0.9);
		st2.setFromY(0.9);
		st2.setToY(1.1);

		PauseTransition pt1 = new PauseTransition();
		pt1.setDuration(Duration.millis(1400));

		SequentialTransition seq1 = new SequentialTransition(st1, pt1, st2);
		ParallelTransition par1 = new ParallelTransition(fish1, tt, seq1);
		par1.setCycleCount(Animation.INDEFINITE);
		par1.setAutoReverse(true);
		
	

		animation = par1;
		animation.play();
	}

	
	private void moveFish21AlongACurve() {
		Path animationPath = new Path();
		MoveTo moveTo = new MoveTo(0, 200);
		CubicCurveTo sineCurve = new CubicCurveTo(300, -50, // first control
				// point
				300, 50, // second control point
				100, 20 // end
				);

		animationPath.getElements().addAll(moveTo, sineCurve);

		PathTransition pt = new PathTransition();
		pt.setNode(fish2);
		pt.setDuration(Duration.seconds(5));
		pt.setPath(animationPath);
		pt.setOrientation(OrientationType.ORTHOGONAL_TO_TANGENT);
		pt.setInterpolator(Interpolator.LINEAR);
		pt.setCycleCount(Animation.INDEFINITE);
		pt.setAutoReverse(true);
		animation = pt;
		animation.play();
	}
	private void bubbleEffect(){
		
	
	 FadeTransition ft = new FadeTransition();
     ft.setNode(bubble1);
     ft.setDuration(new Duration(2000));
     ft.setFromValue(1.0);
     ft.setToValue(0.0);
     ft.setCycleCount(6);
     ft.setAutoReverse(true);
     ft.play();
     
     FadeTransition ft1 = new FadeTransition();
     ft1.setNode(bubble3);
     ft1.setDuration(new Duration(2000));
     ft1.setFromValue(1.0);
     ft1.setToValue(0.0);
     ft1.setCycleCount(6);
     ft1.setAutoReverse(true);

     ft1.play();
     
     FadeTransition ft2 = new FadeTransition();
     ft2.setNode(bubble2);
     ft2.setDuration(new Duration(2000));
     ft2.setFromValue(1.0);
     ft2.setToValue(0.0);
     ft2.setCycleCount(6);
     ft2.setAutoReverse(true);

     ft2.play();
     
     FadeTransition ft3 = new FadeTransition();
     ft3.setNode(bubble4);
     ft3.setDuration(new Duration(2000));
     ft3.setFromValue(1.0);
     ft3.setToValue(0.0);
     ft3.setCycleCount(6);
     ft3.setAutoReverse(true);

     ft3.play();
	}
	
}