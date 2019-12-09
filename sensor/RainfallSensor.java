/**
 * TCSS 360 Software Development
 * Project 4
 */

package sensor;

/**
 * This is the RainFallSensor class that represents
 * the rain fall sensor of the weather system.
 * 
 * @authors Michael Zachary Loria, Dung Thai, Nicholas La Tour-Telles, Brittany Guilbert, Duc Chau
 * @version 12.9.19
 */
public class RainfallSensor extends AbstractSensor {

	/** Lower bound of the rainfall sensor. */
	private static final int LOW_DATA = 0;
	
	/** Upper bound of the rainfall sensor. */
	private static final int HIGH_DATA= 10;
	
	/**
	 * Initializes the sensor fields.
	 */
	public RainfallSensor() {
		super();
	}

	@Override
	public String getData() {
		return String.valueOf((myR.nextInt(HIGH_DATA - LOW_DATA) + LOW_DATA)/10.0);
	}
	
	@Override
	public String toString() {
		return String.valueOf((myR.nextInt(HIGH_DATA - LOW_DATA) + LOW_DATA)/10.0) + " inches";
	}

}
