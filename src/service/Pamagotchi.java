package service;

import java.io.File;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import javafx.scene.image.Image;

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
 */

public class Pamagotchi implements IPamagotchi {
	
	private String name = null;
	private LocalDateTime created = null;
	private LocalDateTime lastfed = null;
	private LocalDateTime lastplayed = null;
	private LocalDateTime lastslept = null;
	private int stage = 0;
	private long mood;
	private long fullness;
	private long fatigue;
	
	
	/**
	 *  [Images for the ImageView] Created them public since they won't change at any time
	 */
	public Image chilling = new Image(new File("img/Tamagotchi_chilling.gif").toURI().toString());
	public Image bored = new Image(new File("img/Tamagotchi_bored.gif").toURI().toString());
	public Image hungry = new Image(new File("img/Tamagotchi_hungry.gif").toURI().toString());
	public Image tired = new Image(new File("img/Tamagotchi_hungry.gif").toURI().toString());
	public Image happy = new Image(new File("img/Tamagotchi_happy.gif").toURI().toString());
	public Image dead = new Image(new File("img/Tamagotchi_dead.gif").toURI().toString());
	public Image egg = new Image(new File("img/Tamagotchi_egg.gif").toURI().toString());
	public Image asleep = new Image(new File("img/Tamagotchi_asleep.gif").toURI().toString());
	
	
	/**[Tamagotchi Constructors]
	 * 
	 * @param name 
	 * @param created
	 * @param lastfed
	 * @param lastplayed
	 * @param lastslept
	 * @param stage
	 * @param mood
	 * @param fullness
	 * @param fatigue
	 */
	public Pamagotchi(String name, LocalDateTime created, LocalDateTime lastfed, LocalDateTime lastplayed,
			LocalDateTime lastslept, int stage, long mood, long fullness, long fatigue) {
		super();
		this.name = name;
		this.created = created;
		this.lastfed = lastfed;
		this.lastplayed = lastplayed;
		this.lastslept = lastslept;
		this.stage = stage;
		this.mood = mood;
		this.fullness = fullness;
		this.fatigue = fatigue;
	}
	public Pamagotchi() {
		
	}
	
    /** [Calculate Methods]
	/ used the ChronoUnit temporal class to calculate the seconds since it's creation, last fed, last played usw.
	 * 
	 */
	@Override
	public void calculateStage(LocalDateTime tempDateTime) { //TODO change to hours
		long seconds = tempDateTime.until(LocalDateTime.now(), ChronoUnit.SECONDS);
		if(seconds > 15) {
			setStage(1);
			System.out.println("stage: "+stage);
			
		}
		if(seconds > 600) {
			setStage(2);
			System.out.println(stage);
		}
	}

	@Override
	public void calculateFullness(LocalDateTime tempDateTime) { //TODO change to hours
		long seconds = tempDateTime.until(LocalDateTime.now(), ChronoUnit.SECONDS);
		fullness = 100 - seconds;
		if(fullness > 100) fullness = 100;
		if(fullness < 0) fullness = 0;
		fullness = Math.round(fullness);
		setFullness(fullness);
		System.out.println("fullness: "+fullness);
		
		
	}

	@Override
	public void calculateMood(LocalDateTime tempDateTime) {
	    long seconds = tempDateTime.until(LocalDateTime.now(), ChronoUnit.SECONDS);
	    mood = 100 - seconds;
	    if(mood > 100) mood = 100;
		if(mood < 0) mood = 0;
		mood = Math.round(mood);
		setMood(mood);
		System.out.println("mood: "+mood);
	}
	
	/* (non-Javadoc)
	 * @see service.ITamagotchi#calculateFatigue(java.time.LocalDateTime)
	 */
	@Override
	public void calculateFatigue(LocalDateTime tempDateTime) {
		long seconds = tempDateTime.until(LocalDateTime.now(), ChronoUnit.SECONDS);
		fatigue = 100 - seconds;
	    if(fatigue > 100) fatigue = 100;
	   	if(fatigue < 0) fatigue = 0;
	   	fatigue = Math.round(fatigue);
		setFatigue(fatigue);
		System.out.println("fatigue: "+fatigue);
	}


	//Getters and Setters
	
	
	@Override
	public String getName() {
		return name;
	}


	@Override
	public void setName(String name) {
		this.name = name;
	}


	@Override
	public LocalDateTime getCreated() {
		return created;
	}


	@Override
	public void setCreated(LocalDateTime created) {
		this.created = created;
	}


	@Override
	public LocalDateTime getLastfed() {
		return lastfed;
	}

	@Override
	public void setLastfed(LocalDateTime lastfed) {
		this.lastfed = lastfed;
	}


	@Override
	public LocalDateTime getLastplayed() {
		return lastplayed;
	}


	@Override
	public void setLastplayed(LocalDateTime lastplayed) {
		this.lastplayed = lastplayed;
	}


	@Override
	public LocalDateTime getLastslept() {
		return lastslept;
	}


	@Override
	public void setLastslept(LocalDateTime lastslept) {
		this.lastslept = lastslept;
	}


	@Override
	public int getStage() {
		return stage;
	}


	@Override
	public void setStage(int stage) {
		this.stage = stage;
	}


	@Override
	public long getMood() {
		return mood;
	}


	@Override
	public void setMood(long mood) {
		this.mood = mood;
	}


	@Override
	public long getFullness() {
		return fullness;
	}


	@Override
	public void setFullness(long i) {
		this.fullness = i;
	}



	@Override
	public long getFatigue() {
		return fatigue;
	}


	@Override
	public void setFatigue(long fatigue) {
		this.fatigue = fatigue;
	}


	@Override
	public String toString() {
		return "Tamagotchi [name=" + name + ", created=" + created + ", lastfed=" + lastfed + ", lastplayed="
				+ lastplayed + ", lastslept=" + lastslept + ", stage=" + stage + ", mood=" + mood + ", fullness="
				+ fullness + ", fatigue=" + fatigue + "]";
	}
	
	

}
