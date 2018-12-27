package service;

/**
 * soundtrack: The background track was extracted from Stardew Valey OST 
 * - This game is for educational purposes only, I do not intend to get any money with it. All rights reserved.
 * The rest of the sounds are Free of License sounds, downloaded at https://freesound.org 
 */

import java.nio.file.Paths;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Soundtrack {
	
	private MediaPlayer backgroundmusic = new MediaPlayer(new Media(Paths.get("music/Stardew Valley OST - Summer (The Sun Can Bend An Orange Sky).mp3").toUri().toString()));
	private MediaPlayer newmonster = new MediaPlayer(new Media(Paths.get("music/arcade_game_tone_001.mp3").toUri().toString()));
	private MediaPlayer snoring = new MediaPlayer(new Media (Paths.get("music/human_male_snoring_001.mp3").toUri().toString()));
	private MediaPlayer playing = new MediaPlayer(new Media(Paths.get("music/arcade_game_level_up_tone.mp3").toUri().toString()));
	private MediaPlayer eating = new MediaPlayer(new Media (Paths.get("music/chewing.wav").toUri().toString()));
	private MediaPlayer jingle = new MediaPlayer(new Media (Paths.get("music/jingle.mp3").toUri().toString()));
	private MediaPlayer gameover = new MediaPlayer(new Media (Paths.get("music/gameover.wav").toUri().toString()));
	private MediaPlayer menu = new MediaPlayer(new Media (Paths.get("music/menu-fx.wav").toUri().toString()));
	

	public Soundtrack() {
	
	}


	public synchronized MediaPlayer getBackgroundmusic() {
		return backgroundmusic;
	}


	public synchronized void setBackgroundmusic(MediaPlayer backgroundmusic) {
		this.backgroundmusic = backgroundmusic;
	}


	public synchronized MediaPlayer getNewmonster() {
		return newmonster;
	}


	public synchronized void setNewmonster(MediaPlayer newmonster) {
		this.newmonster = newmonster;
	}


	public synchronized MediaPlayer getSnoring() {
		return snoring;
	}


	public synchronized void setSnoring(MediaPlayer snoring) {
		this.snoring = snoring;
	}


	public synchronized MediaPlayer getPlaying() {
		return playing;
	}


	public synchronized void setPlaying(MediaPlayer playing) {
		this.playing = playing;
	}


	public synchronized MediaPlayer getEating() {
		return eating;
	}


	public synchronized void setEating(MediaPlayer eating) {
		this.eating = eating;
	}


	public synchronized MediaPlayer getJingle() {
		return jingle;
	}


	public synchronized void setJingle(MediaPlayer jingle) {
		this.jingle = jingle;
	}


	public synchronized MediaPlayer getGameover() {
		return gameover;
	}


	public synchronized void setGameover(MediaPlayer gameover) {
		this.gameover = gameover;
	}


	public synchronized MediaPlayer getMenu() {
		return menu;
	}


	public synchronized void setMenu(MediaPlayer menu) {
		this.menu = menu;
	}


	//GETTERS AND SETTERS

	
	

}
