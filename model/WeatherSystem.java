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
 * @author miclo
 *
 */
public class WeatherSystem {
	
	private final Timer myTimer;
	
	private final WeatherDatabase myWeatherDatabase;
	
	private final Console myConsole;
	
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
	
	public String[] getCurrentWeather() {
		return myConsole.getSensorDataFormatted();
	}
	
	public File getHistoricalData() {
		return myWeatherDatabase.sendReport();
	}	
}
