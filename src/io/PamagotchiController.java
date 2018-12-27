package io;

import java.time.LocalDateTime;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.media.MediaView;
import javafx.util.Duration;
import service.Config;
import service.Soundtrack;
import service.Pamagotchi;

/**
 * 
 * @author ptrcklehmann
 * 
 * Pamagotchi
 * My own version of the classic Tamagotchi, using JavaFX
 * Final School Project at the Web/Java Development specialization @ Cimdata Bildungsakademie Berlin
 * 
 * image copyrights from the 1997's Tamagotchi for Game Boy, sprite sheet riped by xdonthave1xx
 * I do not intend to own any money with this project
 * 
 *
 */

public class PamagotchiController {
	private static final Integer STARTTIME = 15;
	private Timeline timeline;
	private IntegerProperty timeSeconds = new SimpleIntegerProperty(STARTTIME*100);
	Pamagotchi tamagotchi = null;
	Soundtrack soundtrack = new Soundtrack();
	Soundtrack sounds = new Soundtrack();
	Config properties = new Config();
	
    @FXML
    private ImageView tamagotchiImageView;

	@FXML Button newMonsterButton;
	
	@FXML private Button feedButton;

    @FXML  private Button sleepButton;
    
    @FXML private Button playButton;

	@FXML ProgressBar progressBar;
	
	@FXML
    private Label statusLabel;
	

    @FXML
    private MediaView mediaView;


    private void Calculate() {
		if(tamagotchi != null) {
    		tamagotchi.calculateStage(tamagotchi.getCreated());
    		tamagotchi.calculateFullness(tamagotchi.getLastfed());
    		tamagotchi.calculateMood(tamagotchi.getLastplayed());
    		tamagotchi.calculateFatigue(tamagotchi.getLastslept());
    		//properties.save(tamagotchi.getName(), tamagotchi.getCreated(), tamagotchi.getLastfed(), tamagotchi.getLastplayed(), tamagotchi.getLastslept(), tamagotchi.getStage(), tamagotchi.getMood(), tamagotchi.getFullness(), tamagotchi.getFatigue());
    	}
	}
    
    @FXML
    void initialize() {
    	
    	//properties.loadstage();
    	feedButton.cursorProperty().set(Cursor.HAND); //setting cursor to HAND
    	playButton.cursorProperty().set(Cursor.HAND);
    	sleepButton.cursorProperty().set(Cursor.HAND);
    	newMonsterButton.cursorProperty().set(Cursor.HAND);
    	
    	feedButton.setDisable(true);
    	
    	soundtrack.getBackgroundmusic().setOnEndOfMedia(new Runnable() { //this makes the backgroundmusic repeat
    		public void run() {
    			soundtrack.getBackgroundmusic().seek(Duration.ZERO);
    		}
    	});
    	soundtrack.getBackgroundmusic().play();
    	
    	Timeline twoSecondsWonder = new Timeline(new KeyFrame(Duration.seconds(2), new EventHandler<ActionEvent>() {

			@Override
    	    public void handle(ActionEvent event) {
    	    	if(tamagotchi != null) {
    	    	Calculate();
    	    	// Here starts the proofing and setting of the image view accordingly to the Tamagotchi status
    	    	if(tamagotchi.getStage() != 0) {
	    		soundtrack.getNewmonster().play();
	    		if ((tamagotchi.getFatigue() < 85 && tamagotchi.getFullness() > 60)) {
             		tamagotchiImageView.setImage(tamagotchi.chilling);
             		progressBar.setVisible(false);
             		statusLabel.setVisible(true);
             		statusLabel.setText("JUST CHILLING");
             		sounds.getSnoring().stop();
             		sounds.getPlaying().stop();
             		soundtrack.getBackgroundmusic().setVolume(0.6);
	         		
	         	} 
    	    	if (tamagotchi.getMood() < 80 && tamagotchi.getFatigue() < 90) {
	         		tamagotchiImageView.setImage(tamagotchi.bored);
	         		statusLabel.setText("BORED");
	         		playButton.setDisable(false);
	         		sounds.getSnoring().stop();
	         		sounds.getPlaying().stop();
	         		soundtrack.getBackgroundmusic().setVolume(0.6);
	         		
	         		
        	    } 
    	    	if (tamagotchi.getFatigue() < 50) {
	         		tamagotchiImageView.setImage(tamagotchi.tired);
	         		statusLabel.setText("TIRED");
	         		feedButton.setDisable(true);
	         		sleepButton.setDisable(false);
	         		soundtrack.getSnoring().stop();
	         		soundtrack.getBackgroundmusic().setVolume(0.6);
	         		
    	    	}
    	    	if (tamagotchi.getFullness() < 60) {
	         		tamagotchiImageView.setImage(tamagotchi.tired);
	         		statusLabel.setText("HUNGRY");
	         		feedButton.setDisable(false);
	         		soundtrack.getBackgroundmusic().setVolume(0.6);
	         		soundtrack.getSnoring().stop();
	         		
        	    } 
    	    	
    	    	if (tamagotchi.getFullness() > 90 || tamagotchi.getMood() > 90 && tamagotchi.getFatigue() < 85) {
	         		tamagotchiImageView.setImage(tamagotchi.happy);
	         		statusLabel.setText("HAPPY");
	         		feedButton.setDisable(true);
	         		playButton.setDisable(true);
	         		soundtrack.getSnoring().stop();
	         		soundtrack.getBackgroundmusic().setVolume(0.6);
	         		
        	    }
    	    	if(tamagotchi.getFullness() < 30 && tamagotchi.getFatigue() < 30) {
    	    		sounds.getGameover().play();
	         		tamagotchiImageView.setImage(tamagotchi.dead);
	         		statusLabel.setText("DEAD");
	         		feedButton.setDisable(true);
	         		playButton.setDisable(true);
	         		sleepButton.setDisable(true);
	         		newMonsterButton.setDisable(false);
	         		tamagotchi = null;
	         		
	        	 }
    	    	}    	
	        	    
	    	 }  
    	  	}
    	}));
    	twoSecondsWonder.setCycleCount(Timeline.INDEFINITE);
    	twoSecondsWonder.play();
        
    	
    }
    
    @FXML
    void newMonsterAction(ActionEvent event) { //Creates a new Tamagotchi
    	
    	statusLabel.setText("");
    	LocalDateTime now = LocalDateTime.now();
    	sounds.getNewmonster().play();
    	tamagotchi = new Pamagotchi("tamagothi", now, now, now, now, 0, 100,
    			85, 95);
    	//properties.save();
    	System.out.println(tamagotchi.toString());
    	if(tamagotchi.getStage() == 0) { // creates a 15 seconds progress bar and the egg won't hatch until then
    		tamagotchiImageView.setImage(tamagotchi.egg); //this sets the imageView to egg
    		newMonsterButton.setDisable(true);
    		progressBar.progressProperty().bind(
                    timeSeconds.divide(STARTTIME*100.0).subtract(1).multiply(-1));
    		if (timeline != null) {
                timeline.stop();
            }
            timeSeconds.set((STARTTIME+1)*100);
            timeline = new Timeline();
            timeline.getKeyFrames().add(
                    new KeyFrame(Duration.seconds(STARTTIME+1),
                    new javafx.animation.KeyValue(timeSeconds, 0)));
            timeline.playFromStart();
              
        }

    	
    }
	@FXML
	void feedAction(ActionEvent event) { //the feed action sets the lastfed to now
	    	tamagotchi.setLastfed(LocalDateTime.now());
	    	feedButton.setDisable(true);
	    	sounds.getEating().play();
	    	
	    	
	    }
	
    @FXML
    void playAction(ActionEvent event) {
    	tamagotchi.setLastplayed(LocalDateTime.now());
    	playButton.setDisable(true);
    	sounds.getPlaying().play();
    	
    	
    }

    @FXML
    void sleepAction(ActionEvent event) { //Diferent than the other actions, sleep action actually sets the imageView to the sleeping .gif, that only disappears when the fatigue < 85
    	tamagotchi.setLastslept(LocalDateTime.now());
    	sleepButton.setDisable(true);
 		tamagotchiImageView.setImage(tamagotchi.asleep);
 		statusLabel.setText("SLEEPING");
 		soundtrack.getBackgroundmusic().setVolume(0.3);
 		sounds.getSnoring().play();
 		
    	
    }
    

	


}
