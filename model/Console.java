/**
 * TCSS 360 Software Development
 * Project 4
 */

package model;

import java.text.SimpleDateFormat;
import java.util.Date;

import sensor.Barometer;
import sensor.DewPointSensor;
import sensor.ForecastSensor;
import sensor.HumiditySensor;
import sensor.RainfallSensor;
import sensor.WindSensor;

/**
 * This is the Console class that retrieves all of the
 * data from the weather sensors.
 * 
 * @authors Michael Zachary Loria, Dung Thai, Nicholas La Tour-Telles, Brittany Guilbert, Duc Chau
 * @version 12.9.19
 */
public class Console {
	
	/** This is the date format used for the program. */
	private static final SimpleDateFormat MY_DATE_FORMAT = new SimpleDateFormat("MM-dd-yyyy");
	
	/** This is the time format used for the program. */
	private static final SimpleDateFormat MY_TIME_FORMAT = new SimpleDateFormat("HH:mm:ss");
	
	/** The barometer sensor. */
	private final Barometer myBarometer;
	
	/** The dew point sensor. */
	private final DewPointSensor myDewPointSensor;
	
	/** The forecast sensor. */
	private final ForecastSensor myForecastSensor;
	
	/** The humidity sensor. */
	private final HumiditySensor myHumiditySensor;
	
	/** The rainfall sensor. */
	private final RainfallSensor myRainfallSensor;
	
	/** The wind sensor. */
	private final WindSensor myWindSensor;
	
	/**
	 * Initializes all of the weather sensors of the
	 * weather system.
	 */
	public Console() {
		myBarometer = new Barometer();
		myDewPointSensor = new DewPointSensor();
		myForecastSensor = new ForecastSensor();
		myHumiditySensor = new HumiditySensor();
		myRainfallSensor = new RainfallSensor();
		myWindSensor = new WindSensor();
		
	}
	
	/**
	 * Retrieves all of the data from all of the sensors
	 * and provides time and date of when the data was 
	 * retrieved.
	 * 
	 * @return Array of strings representing the fetched data from the sensors.
	 */
	public String[] getSensorData() {
		String[] mySensorData = new String[9];
		mySensorData[0] = MY_DATE_FORMAT.format(new Date());
		mySensorData[1] = MY_TIME_FORMAT.format(new Date());
		mySensorData[2] = myForecastSensor.getData();
		mySensorData[3] = myWindSensor.getWindSpeedData();
		mySensorData[4] = myWindSensor.getWindDirectionData();
		mySensorData[5] = myHumiditySensor.getData();
		mySensorData[6] = myDewPointSensor.getData();
		mySensorData[7] = myRainfallSensor.getData();
		mySensorData[8] = myBarometer.getData();
		return mySensorData;
	}
	
	/**
	 * Retrieves all of the data from all of the sensors
	 * in a formatted format.
	 * 
	 * @return Array of formatted strings representing the data from the sensors.
	 */
	public String[] getSensorDataFormatted() {
		String[] mySensorData = new String[9];
		mySensorData[0] = MY_DATE_FORMAT.format(new Date());
		mySensorData[1] = MY_TIME_FORMAT.format(new Date());
		mySensorData[2] = myForecastSensor.toString();
		mySensorData[3] = myWindSensor.getWindSpeedDataString();
		mySensorData[4] = myWindSensor.getWindDirectionDataString();
		mySensorData[5] = myHumiditySensor.toString();
		mySensorData[6] = myDewPointSensor.toString();
		mySensorData[7] = myRainfallSensor.toString();
		mySensorData[8] = myBarometer.toString();
		return mySensorData;
	}

}
