package service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

public class Config {
	
	
	private Pamagotchi tamagotchi;
	public void save(String name, LocalDateTime created, LocalDateTime lastfed, LocalDateTime lastplayed, LocalDateTime lastslept, int stage, long mood, long fullness, long fatigue) {
		Properties prop = new Properties();
		OutputStream output = null;

		try {

			output = new FileOutputStream("config.properties");

			// set the properties value
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			
			prop.setProperty("name", name);
			prop.setProperty("created", created.format(formatter));
			prop.setProperty("lastfed", lastfed.format(formatter));
			prop.setProperty("lastplayed", lastplayed.format(formatter));
			prop.setProperty("lastslept", lastslept.format(formatter));

			// save properties to project root folder
			prop.store(output, null);

		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
	}
	public Pamagotchi loadstage() {
		Properties prop = new Properties();
    	InputStream input = null;

    	try {

    		input = new FileInputStream("config.properties");

    		// load a properties file
    		prop.load(input);

    		// get the property value and print it out
    		//System.out.println(prop.getProperty("database"));
    		
			
			String str = prop.getProperty("created");		
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			LocalDateTime created = LocalDateTime.parse(str, formatter);
			
			
			str = prop.getProperty("lastfed");
			LocalDateTime lastfed = LocalDateTime.parse(str, formatter);
			
			str = prop.getProperty("lastplayed");
			LocalDateTime lastplayed = LocalDateTime.parse(str, formatter);
			
			str = prop.getProperty("lastslept");
			LocalDateTime lastslept = LocalDateTime.parse(str, formatter);
			tamagotchi = new Pamagotchi();
			tamagotchi.setName(prop.getProperty("name"));
			tamagotchi.setCreated(created);
			tamagotchi.setLastfed(lastfed);
			tamagotchi.setLastplayed(lastplayed);
			tamagotchi.setLastslept(lastslept);
			
    	} catch (IOException ex) {
    		ex.printStackTrace();
    	} finally {
    		if (input != null) {
    			try {
    				input.close();
    			} catch (IOException e) {
    				e.printStackTrace();
    			}
    		}
    	}
    	return tamagotchi;
		
	}
}
