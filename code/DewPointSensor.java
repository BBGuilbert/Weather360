/**
 * 
 */
package code;

/**
 * @author Nicholas La Tour-Telles
 *
 */
public class DewPointSensor extends AbstractSensor {

	
	private int myLowData = 20;
	private int myHighData = 100;
	/**
	 * 
	 */
	public DewPointSensor() {
		super();
	}

	public String getData() {
		return String.valueOf(myR.nextInt(myHighData - myLowData) + myLowData) + " degrees";
	}

}
