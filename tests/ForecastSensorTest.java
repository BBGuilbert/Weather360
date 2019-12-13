package tests;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import sensor.ForecastSensor;


public class ForecastSensorTest extends AbstractSensorTest{
	
	/** String array containing all possible weather conditions. */
	private static final String MY_WEATHER[] = {"Sunny", "Cloudy", "Rain", "Snow"};
	
	/**
     * @throws java.lang.Exception
     */
	@Override
    @Before
    public void setUp() 
    {
		mySensor =  new ForecastSensor();  
        mySuffix = " degrees Farenheit";
        myLow = 20;
        myHigh = 100;        
    }
	
	/**
     * Test method 
     */
	@Override
    @Test
    public void testToString() 
    {
    	
    	String name = mySensor.toString();
    	
    	boolean isCorrect=false;
    	String weather= "";
        for(int i = 0; i<4; i++) {
			if(name.contains(MY_WEATHER[i])){
				isCorrect = true;
				weather = MY_WEATHER[i];
			}
		}
        weather = weather + " | ";
    	assertTrue(isCorrect);
    	
    	String sansSuffix = name.replace(weather, "");
    	sansSuffix = sansSuffix.replace(mySuffix, "");
    	double data = Double.parseDouble(sansSuffix);
        assertTrue(name.endsWith(mySuffix)); //check that data ends with its suffix
        assertTrue(name.startsWith(weather));
        
        //check that data is in the proper range
        for(int i= 0; i<100; i++) {
	        assertTrue(data <= myHigh);
	        assertTrue(data >= myLow);
        }
    }
	
	/**
     * Test method 
     */
	@Override
    @Test
    public void testGetData() 
    {
    	String name = mySensor.getData();
    	
    	boolean isCorrect=false;
    	String weather= "";
        for(int i = 0; i<4; i++) {
			if(name.contains(MY_WEATHER[i])){
				isCorrect = true;
				weather = MY_WEATHER[i];
			}
		}
        weather = " | " + weather;
    	assertTrue(isCorrect);
    	
    	String sansSuffix = name.replace(weather, "");
    	double data = Double.parseDouble(sansSuffix);
        assertTrue(name.endsWith(weather)); //check that data ends with its suffix
        
        //check that data is in the proper range
        for(int i= 0; i<100; i++) {
	        assertTrue(data <= myHigh);
	        assertTrue(data >= myLow);
        }
    }

}
