/**
 * 
 */
package code;

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
		return String.valueOf(myR.nextInt(myHighData - myLowData) + myLowData) + " millibars";
	}

}
