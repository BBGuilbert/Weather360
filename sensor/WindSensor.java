/**
 * 
 */
package sensor;

/**
 * @author Nicholas La Tour-Telles
 *
 */
public class WindSensor extends AbstractSensor {

	private String myDir[] = {"N", "NE", "E", "SE", "S", "SW", "W", "NW"};
	private int myLowData = 1;
	private int myHighData = 10;
	
	
	public WindSensor() {
		super();
	}
	
	public String getData() {
		return "Wind speed - " + String.valueOf(myR.nextInt(myHighData - myLowData) + myLowData) + 
				" MPH | Direction - " + myDir[myR.nextInt(8)];
	}
	
	public String getWindDirectionData() {
		return myDir[myR.nextInt(8)];
	}
	
	public String getWindSpeedData() {
		return String.valueOf(myR.nextInt(myHighData - myLowData) + myLowData);
	}

}
