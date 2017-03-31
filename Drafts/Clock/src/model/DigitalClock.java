package model;

import java.time.LocalTime;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class DigitalClock {

	  // the digital clock updates once a second.
	  public void bindToTime(Label label) {
	
		  
	    Timeline timeline = new Timeline(
	      new KeyFrame(Duration.seconds(0),
	        new EventHandler<ActionEvent>() {
	    	  
	          @Override 
	          public void handle(ActionEvent actionEvent) {
	        	  
	        	LocalTime time = LocalTime.now();
	     
	        	String hourString; 
	        	if (time.getHour() < 10) {
	        		hourString =  "0" + String.valueOf(time.getHour());	
	        	} else {
	        		hourString = String.valueOf(time.getHour());
	        	}
	        	
	            String minuteString;
	            if (time.getMinute() < 10) {
	        		minuteString =  "0" + String.valueOf(time.getMinute());	
	        	} else {
	        		minuteString = String.valueOf(time.getMinute());
	        	}
	            
	            String secondString;
	            if (time.getSecond() < 10) {
	        		secondString =  "0" + String.valueOf(time.getSecond());	
	        	} else {
	        		secondString = String.valueOf(time.getSecond());
	        	}
	            
	            label.setText(hourString + ":" + minuteString + ":" + secondString);
	          }
	        }
	      ),
	      new KeyFrame(Duration.seconds(1))
	    );
	    
	    timeline.setCycleCount(Animation.INDEFINITE);
	    timeline.play();
	  }
	}
