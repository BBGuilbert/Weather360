/**
 * TCSS 360 Software Development
 * Project 4
 */

package sensor;

/**
 * This is the DewPointSensor class that represents
 * the dew point sensor of the weather system.
 * 
 * @authors Michael Zachary Loria, Dung Thai, Nicholas La Tour-Telles, Brittany Guilbert, Duc Chau
 * @version 12.9.19
 */
public class DewPointSensor extends AbstractSensor {

	/** Lower bound for the dew point sensor. */
	private static final int MY_LOW_DATA = 20;
	
	/** Upper bound for the dew point sensor. */
	private static final int MY_HIGH_DATA = 100;
	
	/**
	 * Initializes the sensor fields.
	 */
	public DewPointSensor() {
		super();
	}

	@Override
	public String getData() {
		return String.valueOf(myR.nextInt(MY_HIGH_DATA - MY_LOW_DATA) + MY_LOW_DATA);
	}
	
	@Override
	public String toString() {
		return String.valueOf(myR.nextInt(MY_HIGH_DATA - MY_LOW_DATA) + MY_LOW_DATA) + " degrees";
	}

}
