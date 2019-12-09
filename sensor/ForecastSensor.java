/**
 * TCSS 360 Software Development
 * Project 4
 */

package sensor;

/**
 * This is the ForecastSensor class that represents
 * the forecast sensor of the weather system.
 * 
 * @authors Michael Zachary Loria, Dung Thai, Nicholas La Tour-Telles, Brittany Guilbert, Duc Chau
 * @version 12.9.19
 */
public class ForecastSensor extends AbstractSensor {

	/** String array containing all possible weather conditions. */
	private static final String MY_WEATHER[] = {"Sunny", "Cloudy", "Rain", "Snow"};
	
	/** Lower bound of temperature. */
	private static final int MY_LOW_DATA = 20;
	
	/** Upper bound of temperature. */
	private static final int MY_HIGH_DATA = 100;
	
	/**
	 * Initializes the sensor fields.
	 */
	public ForecastSensor() {
		super();
	}

	@Override
	public String getData() {
		return String.valueOf(myR.nextInt(MY_HIGH_DATA - MY_LOW_DATA) + MY_LOW_DATA) + " | " + MY_WEATHER[myR.nextInt(4)];
	}

	@Override
	public String toString() {
		int temp = myR.nextInt(MY_HIGH_DATA - MY_LOW_DATA) + MY_LOW_DATA;
		int snowCheck = 4;
		if(temp > 32) { snowCheck = 3; }
		return MY_WEATHER[myR.nextInt(snowCheck)] + " | " + String.valueOf(temp) + " degrees Farenheit";
	}
}
