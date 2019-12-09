/**
 * 
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
 * @author miclo
 *
 */
public class Console {
	
	private static final SimpleDateFormat MY_DATE_FORMAT = new SimpleDateFormat("MM-dd-yyyy");
	
	private static final SimpleDateFormat MY_TIME_FORMAT = new SimpleDateFormat("HH:mm:ss");
	
	private final Barometer myBarometer;
	
	private final DewPointSensor myDewPointSensor;
	
	private final ForecastSensor myForecastSensor;
	
	private final HumiditySensor myHumiditySensor;
	
	private final RainfallSensor myRainfallSensor;
	
	private final WindSensor myWindSensor;
	
	
	public Console() {
		myBarometer = new Barometer();
		myDewPointSensor = new DewPointSensor();
		myForecastSensor = new ForecastSensor();
		myHumiditySensor = new HumiditySensor();
		myRainfallSensor = new RainfallSensor();
		myWindSensor = new WindSensor();
		
	}
	
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
