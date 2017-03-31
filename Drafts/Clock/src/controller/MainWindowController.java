package controller;

import java.time.LocalTime;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.DigitalClock;

public class MainWindowController {
	private Stage primaryStage;
	private Main main;
	@FXML
	private VBox minutesHand;
	@FXML
	private VBox secondsHand;
	@FXML
	private VBox hoursHand;
	@FXML
	private Label digitalClockLabel;
	@FXML
	Animation animation;

	public void setMain(Main main, Stage primaryStage) {
		this.main = main;
		this.primaryStage = primaryStage;
	}
	
	// TODO: Bind hour hands to the current time - 00:00:00 > initial position
	// other > changed by the appropriate angle
	
	
	public void startClocks() {
		setHandsInMotion();
		new DigitalClock().bindToTime(digitalClockLabel);
	}
	
	public void setHandsInMotion() {
		
		setSecondsHandInMotion();
		setMinutesHandInMotion();
		setHoursHandInMotion();
	}

	private void setSecondsHandInMotion() {
		RotateTransition rt = new RotateTransition();
		rt.setNode(secondsHand);
		rt.setInterpolator(Interpolator.LINEAR);
		rt.setByAngle(360);
		rt.setDuration(Duration.seconds(60));
		rt.setCycleCount(Animation.INDEFINITE);
		animation = rt;
		rt.play();
	}
	
	private void setMinutesHandInMotion() {
		RotateTransition rt = new RotateTransition();
		rt.setNode(minutesHand);
		rt.setInterpolator(Interpolator.LINEAR);
		rt.setByAngle(360);
		rt.setDuration(Duration.minutes(60));
		rt.setCycleCount(Animation.INDEFINITE);
		animation = rt;
		rt.play();
	}
	
	private void setHoursHandInMotion() {
		RotateTransition rt = new RotateTransition();
		rt.setNode(hoursHand);
		rt.setInterpolator(Interpolator.LINEAR);
		rt.setByAngle(360);
		rt.setDuration(Duration.hours(12));
		rt.setCycleCount(Animation.INDEFINITE);
		animation = rt;
		rt.play();
	}
		

	void bindClockHandsToTime() {
		
		LocalTime now = LocalTime.now();
		final double initialHoursHandDegrees = calculateHoursHandDegrees(now);
		final double initialMinutesHandDegrees = calculateMinutesHandDegrees(now);
		final double initialSecondsHandDegrees = calculateSecondsHandDegrees(now);

	}
	
	/**
	 * Performs a 360 degree rotation of the angleProperty once in every
	 * duration. rotation starts from initialRotation degrees.
	 */
	
	private void createRotationTimeline(DoubleProperty angleProperty, Duration duration, double initialRotation) {
		Timeline timeline = new Timeline(
				new KeyFrame(duration, new KeyValue(angleProperty, 360 + initialRotation, Interpolator.LINEAR)));
		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.play();
	}

	private int calculateSecondsHandDegrees(LocalTime time) {
		return time.getSecond() * (360 / 60);
	}

	private double calculateMinutesHandDegrees(LocalTime time) {
		return (time.getMinute() / 360.0) * (360 / 60);
	}

	private double calculateHoursHandDegrees(LocalTime time) {
		return (time.getHour() + calculateMinutesHandDegrees(time) / 360.0) * (360 / 12);
	}
}
