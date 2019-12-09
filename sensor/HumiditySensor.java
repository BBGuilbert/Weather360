/**
 * TCSS 360 Software Development
 * Project 4
 */

package sensor;

/**
 * This is the HumiditySensor class that represents
 * the Humidity sensor of the weather system.
 * 
 * @authors Michael Zachary Loria, Dung Thai, Nicholas La Tour-Telles, Brittany Guilbert, Duc Chau
 * @version 12.9.19
 */
public class HumiditySensor extends AbstractSensor {
	
	/** The low bound for the humidity. */
	private static final int MY_LOW_DATA = 65;
	
	/** The upper bound for the humidity. */
	private static final int MY_HIGH_DATA = 81;
	
	/**
	 * Initializes the sensor fields.
	 */
	public HumiditySensor() {
		super();
	}
	
	@Override
	public String getData() {
		
		return String.valueOf(myR.nextInt(MY_HIGH_DATA - MY_LOW_DATA) + MY_LOW_DATA);
	}
	
	@Override
	public String toString() {
		return String.valueOf(myR.nextInt(MY_HIGH_DATA - MY_LOW_DATA) + MY_LOW_DATA) + "  g/m³";
	}

}
