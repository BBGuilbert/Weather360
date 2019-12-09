/**
 * TCSS 360 Software Development
 * Project 4
 */

package model;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * This is the Console class that retrieves all of the
 * data from the weather sensors.
 * 
 * @authors Michael Zachary Loria, Dung Thai, Nicholas La Tour-Telles, Britanny Guilbert, Duc Chau
 * @version 12.9.19
 */
public class WeatherSystem {
	
	/** The timer used for the weather system to update the data. */
	private final Timer myTimer;
	
	/** The database where the weather data is stored. */
	private final WeatherDatabase myWeatherDatabase;
	
	/** The console where the weather data is retrieved. */
	private final Console myConsole;
	
	/**
	 * Initializes the database and console for the weather
	 * system. Creates timer used for updating the database
	 * every thirty seconds.
	 */
	public WeatherSystem() {
		myTimer = new Timer();
		myWeatherDatabase = new WeatherDatabase();
		myConsole = new Console();
		myTimer.schedule(new TimerTask() {
		    @Override
		    public void run() {
		    	List<String> tempList = Arrays.asList(myConsole.getSensorData());
		    	myWeatherDatabase.addData(tempList);
		    }
		}, 0, 30000);
	}
	
	/**
	 * Gets the current weather from the console.
	 * 
	 * @return The array of strings containing the fetched data.
	 */
	public String[] getCurrentWeather() {
		return myConsole.getSensorDataFormatted();
	}
	
	/**
	 * Gets the historical data from the database. 
	 * 
	 * @return The File containing the historical data from the database.
	 */
	public File getHistoricalData() {
		return myWeatherDatabase.sendReport();
	}	
}
