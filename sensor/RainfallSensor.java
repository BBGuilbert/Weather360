/**
 * 
 */
package sensor;

/**
 * @author Nicholas La Tour-Telles
 *
 */
public class RainfallSensor extends AbstractSensor {

	
	private int myLowData = 1;
	private int myHighData= 7;
	
	/**
	 * 
	 */
	public RainfallSensor() {
		super();
	}

	public String getData() {
		return String.valueOf(myR.nextInt(myHighData - myLowData) + myLowData);
	}
	
	public String toString() {
		return String.valueOf(myR.nextInt(myHighData - myLowData) + myLowData) + " Inches";
	}

}
