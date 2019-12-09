/**
 * TCSS 360 Software Development
 * Project 4
 */

package sensor;

/**
 * This is the Barometer class that represents
 * the Barometer sensor of the weather system.
 * 
 * @authors Michael Zachary Loria, Dung Thai, Nicholas La Tour-Telles, Brittany Guilbert, Duc Chau
 * @version 12.9.19
 */
public class Barometer extends AbstractSensor {
	
	/** Lower bound of the barometer. */
	private static final int MY_LOW_DATA = 900;
	
	/** Upper bound of the barometer. */
	private static final int MY_HIGH_DATA = 1100;

	/**
	 * Initializes the sensor fields. 
	 */
	public Barometer() {
		super();
	}
	
	@Override
	public String getData() {
		return String.valueOf(myR.nextInt(MY_HIGH_DATA - MY_LOW_DATA) + MY_LOW_DATA);
	}
	
	@Override
	public String toString() {
		return String.valueOf(myR.nextInt(MY_HIGH_DATA - MY_LOW_DATA) + MY_LOW_DATA) + " millibars";
	}

}
