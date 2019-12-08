/**
 * 
 */
package model;

import java.io.File;

/**
 * @author miclo
 *
 */
// TODO How represent historical data (with different selections by the user)
// TODO How often do we update database - do we update only if they select to retrieve data,
// and if they do do we update all fields or just some of the fields
public class WeatherSystem {
	
	private final WeatherDatabase myWeatherDatabase;
	
	private final Console myConsole;
	
	public WeatherSystem() {
		myWeatherDatabase = new WeatherDatabase();
		myConsole = new Console();
	}
	
	public String[] getCurrentWeather() {
		return myConsole.getSensorData();
	}
	
	public File getHistoricalData() {
		return myWeatherDatabase.sendReport();
	}	
}
