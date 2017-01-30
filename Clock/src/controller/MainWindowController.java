package controller;

import com.sun.javafx.geom.Point2D;

import javafx.animation.Animation;
import javafx.animation.RotateTransition;
import javafx.fxml.FXML;
import javafx.geometry.Point3D;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MainWindowController
{
	private Stage primaryStage;
	private Main main;
	@FXML
	private Line longHand;
	@FXML
	Animation animation;

	public void setMain(Main main, Stage primaryStage)
	{
		this.main = main;
		this.primaryStage = primaryStage;
	}
	
	public void setLongHandInMotion() 
	{
		RotateTransition rt = new RotateTransition();
		rt.setNode(longHand);
		rt.setDuration(Duration.seconds(60));
		rt.setAxis(new Point3D(-100, 0, 0));
		rt.setFromAngle(0);
		rt.setToAngle(360);
		
		/*
		for (int i=0; i<360; i+=10)
		{
			rt.setFromAngle(i);
			rt.setToAngle(i+10);
		}
		*/
		rt.setCycleCount(Animation.INDEFINITE);
		animation = rt;
		rt.play();
		
	}
}
