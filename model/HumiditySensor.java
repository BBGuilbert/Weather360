/**
 * 
 */
package model;

/**
 * @author Nicholas La Tour-Telles
 *
 */
public class HumiditySensor extends AbstractSensor {
	
	/**
	 * The low end for the humidity.
	 */
	private int myLowData = 65;
	
	/**
	 * The high end for the humidity.
	 */
	private int myHighData = 81;
	
	public HumiditySensor() {
		super();
	}
	public String getData() {
		
		return String.valueOf(myR.nextInt(myHighData - myLowData) + myLowData) + " g/m3";
	}

}
