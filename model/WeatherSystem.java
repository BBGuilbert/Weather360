/**
 * 
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
// TODO How often do we update database - do we update only if they select to retrieve data,
// and if they do do we update all fields or just some of the fields
public class WeatherSystem {
	
	private final Timer myTimer;
	
	private final WeatherDatabase myWeatherDatabase;
	
	private final Console myConsole;
	
	public WeatherSystem() {
		myTimer = new Timer();
		myTimer.schedule(new TimerTask() {
		    @Override
		    public void run() {
		    	List<String> tempList = Arrays.asList(myConsole.getSensorData());
		    	myWeatherDatabase.addData(tempList);
		    }
		}, 0, 30000);
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
