/**
 * TCSS 360 Software Development
 * Project 4
 */

package sensor;

/**
 * @author Nicholas La Tour-Telles
 *
 */
public class Barometer extends AbstractSensor {
	private int myLowData = 900;
	private int myHighData = 1100;

	public Barometer() {
		super();
	}
	
	public String getData() {
		return String.valueOf(myR.nextInt(myHighData - myLowData) + myLowData);
	}
	
	@Override
	public String toString() {
		return String.valueOf(myR.nextInt(myHighData - myLowData) + myLowData) + " millibars";
	}

}
