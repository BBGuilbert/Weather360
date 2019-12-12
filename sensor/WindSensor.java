/**
 * TCSS 360 Software Development
 * Project 4
 */

package sensor;

/**
 * This is the WindSensor class that represents
 * the wind sensor of the weather system.
 * 
 * @authors Michael Zachary Loria, Dung Thai, Nicholas La Tour-Telles, Brittany Guilbert, Duc Chau
 * @version 12.9.19
 */
public class WindSensor extends AbstractSensor {

	/** Array of strings representing the different possible wind directions. */
	private static final String DIR[] = {"N", "NE", "E", "SE", "S", "SW", "W", "NW"};
	
	/** Lower bound of the wind speed. */
	private static final int LOW_DATA = 1;
	
	/** Upper bound of the wind speed. */
	private static final int HIGH_DATA = 20;
	
	/**
	 * Initializes the sensor fields.
	 */
	public WindSensor() {
		super();
	}
	
	@Override
	public String getData() {
		return "Wind speed - " + String.valueOf(myR.nextInt(HIGH_DATA - LOW_DATA) + LOW_DATA) + 
				" MPH | Direction - " + DIR[myR.nextInt(8)];
	}
	
	/**
	 * Gets the wind direction.
	 * 
	 * @return String representing wind direction.
	 */
	public String getWindDirectionData() {
		return DIR[myR.nextInt(8)];
	}
	
	/**
	 * Gets the wind speed data.
	 * 
	 * @return String representing wind speed.
	 */
	public String getWindSpeedData() {
		return String.valueOf(myR.nextInt(HIGH_DATA - LOW_DATA) + LOW_DATA);
	}
	
	/**
	 * Gets the wind speed data with units. 
	 * 
	 * @return String representing wind speed with units.
	 */
	public String getWindSpeedDataString() {
		return String.valueOf(myR.nextInt(HIGH_DATA - LOW_DATA) + LOW_DATA) + " mph";
	}
	
	//I just added this so that I could put toString in the abstract it is the same as get data in this class
	@Override
	public String toString() {
		return "Wind speed - " + String.valueOf(myR.nextInt(HIGH_DATA - LOW_DATA) + LOW_DATA) + 
				" MPH | Direction - " + DIR[myR.nextInt(8)];
	}

}
