package service;

import java.time.LocalDateTime;

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

public interface IPamagotchi {

	//Calculate methods // must be changed to hours to 
	void calculateStage(LocalDateTime tempDateTime);

	void calculateFullness(LocalDateTime tempDateTime);

	void calculateMood(LocalDateTime tempDateTime);

	void calculateFatigue(LocalDateTime tempDateTime);

	//Getters and Setters
	String getName();

	void setName(String name);

	LocalDateTime getCreated();

	void setCreated(LocalDateTime created);

	LocalDateTime getLastfed();

	void setLastfed(LocalDateTime lastfed);

	LocalDateTime getLastplayed();

	void setLastplayed(LocalDateTime lastplayed);

	LocalDateTime getLastslept();

	void setLastslept(LocalDateTime lastslept);

	int getStage();

	void setStage(int stage);

	long getMood();

	void setMood(long mood);

	long getFullness();

	void setFullness(long i);

	long getFatigue();

	void setFatigue(long fatigue);	
	
	String toString();

}