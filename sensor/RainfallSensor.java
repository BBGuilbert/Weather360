/**
 * TCSS 360 Software Development
 * Project 4
 */

package sensor;

/**
 * @author Nicholas La Tour-Telles
 *
 */
public class RainfallSensor extends AbstractSensor {

	
	private int myLowData = 0;
	private int myHighData= 10;
	
	/**
	 * 
	 */
	public RainfallSensor() {
		super();
	}

	public String getData() {
		return String.valueOf((myR.nextInt(myHighData - myLowData) + myLowData)/10.0);
	}
	
	public String toString() {
		return String.valueOf((myR.nextInt(myHighData - myLowData) + myLowData)/10.0) + " inches";
	}

}
