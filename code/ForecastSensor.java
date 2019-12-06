package code;

/**
 * 
 * @author Nicholas La Tour-Telles
 *
 */
public class ForecastSensor extends AbstractSensor {

	private String weather[] = {"Sunny", "Snow", "Cloudy", "Rain"};
	private int myLowData = 20;
	private int myHighData = 100;
	
	public ForecastSensor() {
		super();
	}

	public String getData() {
		return "Temp is - " + String.valueOf(myR.nextInt(myHighData - myLowData) + myLowData) + 
				" degrees | Weather is - " + weather[myR.nextInt(4)];
	}

}
