/**
 * 
 */
package sensor;

import java.util.Random;

/**
 * @author Nicholas La Tour-Telles
 *
 */
public abstract class AbstractSensor {
	
	public Random myR;

	public AbstractSensor() {
		myR = new Random();
		
	}
	public abstract String getData();
	
}
