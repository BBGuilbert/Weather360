/**
 * TCSS 360 Software Development
 * Project 4
 */

package sensor;

import java.util.Random;

/**
 * This is the AbstractSensor class that is the
 * abstract class for all of the weather system
 * sensors.
 * 
 * @authors Michael Zachary Loria, Dung Thai, Nicholas La Tour-Telles, Brittany Guilbert, Duc Chau
 * @version 12.9.19
 */
public abstract class AbstractSensor {
	
	/** The random class needed to gather data from the sensor. */
	public final Random myR;

	/**
	 * Initializes random field.
	 */
	public AbstractSensor() {
		myR = new Random();
		
	}
	
	/**
	 * Gets the string representation of the 
	 * data in the sensor, without units.
	 * 
	 * @return String representation of the data.
	 */
	public abstract String getData();
	
	/**
	 * Gets the string representation of the 
	 * data in the sensor, with units.
	 * 
	 * @return String representation of the data.
	 */
	public abstract String toString();
	
}
