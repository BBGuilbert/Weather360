/**
 * 
 */
package model;

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
		String[] mySensorData = new String[6];
		mySensorData[0] = myBarometer.getData();
		mySensorData[1] = myDewPointSensor.getData();
		mySensorData[2] = myForecastSensor.getData();
		mySensorData[3] = myHumiditySensor.getData();
		mySensorData[4] = myRainfallSensor.getData();
		mySensorData[5] = myWindSensor.getData();
		return mySensorData;
	}

}
