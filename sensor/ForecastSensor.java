package sensor;

/**
 * 
 * @author Nicholas La Tour-Telles
 *
 */
public class ForecastSensor extends AbstractSensor {

	private String weather[] = {"Sunny", "Cloudy", "Rain", "Snow"};
	private int myLowData = 20;
	private int myHighData = 100;
	
	public ForecastSensor() {
		super();
	}

	public String getData() {
		return String.valueOf(myR.nextInt(myHighData - myLowData) + myLowData) + " | " + weather[myR.nextInt(4)];
	}

	public String toString() {
		int temp = myR.nextInt(myHighData - myLowData) + myLowData;
		int snowCheck = 4;
		if(temp > 32) { snowCheck = 3; }
		return String.valueOf(temp) + " degrees Farenheit | " + weather[myR.nextInt(snowCheck)];
	}
}
