package tests;

import static org.junit.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sensor.Barometer;
import sensor.DewPointSensor;
import sensor.ForecastSensor;
import sensor.HumiditySensor;
import sensor.RainfallSensor;
import sensor.WindSensor;

import model.Console;

/**
 * This is the Tests for Console class that retrieves all of the
 * data from the weather sensors.
 * 
 * @authors Michael Zachary Loria, Dung Thai, Nicholas La Tour-Telles, Brittany Guilbert, Duc Chau
 * @version 12.12.19
 */
public class ConsoleTest extends Console {

	private Console myConsole;
	
	/** This is the date format used for the program. */
	private static final SimpleDateFormat MY_DATE_FORMAT = new SimpleDateFormat("MM-dd-yyyy");
	
	/** This is the time format used for the program. */
	private static final SimpleDateFormat MY_TIME_FORMAT = new SimpleDateFormat("HH:mm:ss");
	
	/** The barometer sensor. */
	private Barometer myBarometer;
	
	/** The dew point sensor. */
	private DewPointSensor myDewPointSensor;
	
	/** The forecast sensor. */
	private ForecastSensor myForecastSensor;
	
	/** The humidity sensor. */
	private HumiditySensor myHumiditySensor;
	
	/** The rainfall sensor. */
	private RainfallSensor myRainfallSensor;
	
	/** The wind sensor. */
	private WindSensor myWindSensor;
	
	/**
     * @throws java.lang.Exception
     */
	@BeforeEach
	void setUp() throws Exception {
		myConsole = new Console();
		myBarometer = new Barometer();
		myDewPointSensor = new DewPointSensor();
		myForecastSensor = new ForecastSensor();
		myHumiditySensor = new HumiditySensor();
		myRainfallSensor = new RainfallSensor();
		myWindSensor = new WindSensor();
	}

	
	/**
	 * Test retrieval of all the data from all of the sensors
	 * and provides time and date of when the data was 
	 * retrieved.
	 * 
	 * @return Array of strings representing the fetched data from the sensors.
	 */
	@Test
	public void testgetSensorData() {
		myConsole.getSensorData();
		//Checking if getting the date is correct
		String myDate = MY_DATE_FORMAT.format(new Date());
		String[] myDateParsed = myDate.split("-");
		boolean dateCheck = true;
		if (Integer.parseInt(myDateParsed[0]) < 0 || Integer.parseInt(myDateParsed[0]) > 13 ) {
			dateCheck = false;
		}
		if (Integer.parseInt(myDateParsed[1]) < 0 || Integer.parseInt(myDateParsed[1]) > 32 ) {
			dateCheck = false;
		}
		if (Integer.parseInt(myDateParsed[2]) < 0 || Integer.parseInt(myDateParsed[2]) > 2021 ) {
			dateCheck = false;
		}
		assertTrue(dateCheck);
		
		//Checking if time is correct
		String myTime = MY_TIME_FORMAT.format(new Date());
		String[] mytimeParsed = myTime.split(":");
		boolean timeCheck = true;
		if (Integer.parseInt(mytimeParsed[0]) < 0 || Integer.parseInt(mytimeParsed[0]) > 24 ) {
			timeCheck = false;
		}
		if (Integer.parseInt(mytimeParsed[1]) < 0 || Integer.parseInt(mytimeParsed[1]) > 60 ) {
			timeCheck = false;
		}
		if (Integer.parseInt(mytimeParsed[2]) < 0 || Integer.parseInt(mytimeParsed[2]) > 100 ) {
			timeCheck = false;
		}
		assertTrue(timeCheck);
		
		//Checking if the forecast data is correct format
		String myForecastData = myForecastSensor.getData();
		String[] myForecastParsed = myForecastData.split(" ");
		boolean forecastCheck = true;
		if (Integer.parseInt(myForecastParsed[0]) < 20 || Integer.parseInt(myForecastParsed[0]) > 100 ) {
			forecastCheck = false;
		}
		assertTrue(forecastCheck);
		
		//Checking if the wind speed is in bound
		String myWindSpeedData= myWindSensor.getWindSpeedData();
		String[] myWindSpeedParsed = myWindSpeedData.split(" ");
		boolean windSpeedCheck = true;
		if (Integer.parseInt(myWindSpeedParsed[0]) < 1 || Integer.parseInt(myWindSpeedParsed[0]) > 20 ) {
			windSpeedCheck = false;
		}
		assertTrue(windSpeedCheck);
		
		//Checking if wind direction is correct
		String myWindDirectionData= myWindSensor.getWindDirectionData();
		boolean windDirectionCheck = false;
		if (myWindDirectionData.equals("E") || myWindDirectionData.equals("N") || myWindDirectionData.equals("W") || myWindDirectionData.equals("S")
				|| myWindDirectionData.equals("NE") || myWindDirectionData.equals("NW") || myWindDirectionData.equals("SE") || myWindDirectionData.equals("SW")) {
			windDirectionCheck = true;
		}
		assertTrue(windDirectionCheck);
		
		//Checking Humidity Bounds
		String myHumidityData = myHumiditySensor.getData();
		String[] humidityParsed = myHumidityData.split(" ");
		boolean humidityCheck = true;
		if (Integer.parseInt(humidityParsed[0]) < 65 || Integer.parseInt(humidityParsed[0]) > 81 ) {
			humidityCheck = false;
		}
		assertTrue(humidityCheck);
		
		//Checking dewpoint data
		String myDewPointData = myDewPointSensor.getData();
		String[] dewPointParsed = myDewPointData.split(" ");
		boolean dewPointCheck = true;
		if (Integer.parseInt(dewPointParsed[0]) < 20 || Integer.parseInt(dewPointParsed[0]) > 100 ) {
			dewPointCheck = false;
		}
		assertTrue(dewPointCheck);
		
		//Checking rainfall
		String myRainfallData = myRainfallSensor.getData();
		String[] rainfallParsed = myRainfallData.split(" ");
		boolean rainfallCheck = true;
		if (Double.parseDouble(rainfallParsed[0]) < 0 || Double.parseDouble(rainfallParsed[0]) > 10 ) {
			rainfallCheck = false;
		}
		assertTrue(rainfallCheck);
		
		//Checking barometer data
		String myBarometerData = myBarometer.getData();
		String[] barometerParsed = myBarometerData.split(" ");
		boolean barometerCheck = true;
		if (Integer.parseInt(barometerParsed[0]) < 900 || Integer.parseInt(barometerParsed[0]) > 1100 ) {
			barometerCheck = false;
		}
		assertTrue(barometerCheck);
	
	}


}
