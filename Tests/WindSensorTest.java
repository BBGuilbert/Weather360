package Tests;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import sensor.WindSensor;

public class WindSensorTest extends AbstractSensorTest{
	
	private WindSensor mySensor;
	private String myPrefix;
	private String myInsert;

	/** Array of strings representing the different possible wind directions. */
	private static final String DIR[] = {"N", "NE", "E", "SE", "S", "SW", "W", "NW"};
	
	/**
     * @throws java.lang.Exception
     */
	@Override
    @Before
    public void setUp() 
    {
		mySensor =  new WindSensor();  
        mySuffix = " mph";
        myLow = 1;
        myHigh = 20;
        myPrefix = "Wind speed - ";
        myInsert = " MPH | Direction - ";
    }
	
	 /**
     * Test method 
     */
    @Test
    public void testGetWindSpeedDataString() 
    {
    	String name = mySensor.getWindSpeedDataString();
    	String sansSuffix = name.replace(mySuffix, "");
    	double data = Double.parseDouble(sansSuffix);
        assertTrue(name.endsWith(mySuffix)); //check that barometer data ends with its suffix
        
        //check that barometer data is in the proper range
        for(int i= 0; i<100; i++) {
	        assertTrue(data <= myHigh);
	        assertTrue(data >= myLow);
	        assertTrue(Double.parseDouble(mySensor.getWindSpeedData()) <= myHigh);
	        assertTrue(Double.parseDouble(mySensor.getWindSpeedData()) >= myLow);
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
    	String sansPrefix = name.replace(myPrefix, "");
    	int indexOfDirection = name.lastIndexOf(myInsert);
    	String direction = name.substring(indexOfDirection);
    	String windSpeed = sansPrefix.substring(0, sansPrefix.indexOf(myInsert));
    	double data = Double.parseDouble(windSpeed);
        assertTrue(name.startsWith(myPrefix)); 
        assertTrue(name.contains(myInsert));
        
        boolean isDirectCorrect=false;
        for(int i = 0; i<8; i++) {
			if(direction.contains(DIR[i])){
				isDirectCorrect = true;
			}
		}
        assertTrue(isDirectCorrect);
        
        //check that data is in the proper range
        for(int i= 0; i<100; i++) {
	        assertTrue(data <= myHigh);
	        assertTrue(data >= myLow); 
        }
    }
    
    @Test
    public void testToString() 
    {
    	
    	String name = mySensor.toString();
    	String sansPrefix = name.replace(myPrefix, "");
    	int indexOfDirection = name.lastIndexOf(myInsert);
    	String direction = name.substring(indexOfDirection);
    	String windSpeed = sansPrefix.substring(0, sansPrefix.indexOf(myInsert));
    	double data = Double.parseDouble(windSpeed);
        assertTrue(name.startsWith(myPrefix)); 
        assertTrue(name.contains(myInsert));
        
        boolean isDirectCorrect=false;
        for(int i = 0; i<8; i++) {
			if(direction.contains(DIR[i])){
				isDirectCorrect = true;
			}
		}
        assertTrue(isDirectCorrect);
        
        //check that data is in the proper range
        for(int i= 0; i<100; i++) {
	        assertTrue(data <= myHigh);
	        assertTrue(data >= myLow); 
        }
    	
    
    }
	
	
}
