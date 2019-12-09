/**
 * TCSS 360 Software Development
 * Project 4
 */

package tests;

import org.junit.Test;

import sensor.HumiditySensor;

import static org.junit.Assert.assertTrue;

import org.junit.Before;

public class HumiditySensorTest {

	HumiditySensor dew;
	
	/**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() 
    {
    	dew = new HumiditySensor();
        
        
    }

    /**
     * Test method for {@link sensor.DewPointSensor#getData()}.
     */
    @Test
    public void testGetData() 
    {
    	String humidity = dew.getData();
    	String humidityNum = humidity.replace(" g/m3", "");
    	int humidityInt = Integer.parseInt(humidityNum);
        assertTrue(humidity.endsWith(" g/m3")); //check that dewPoint data ends with degrees
        
        //check that dewPoint data is in the proper range
        for(int i= 0; i<100; i++) {
	        assertTrue(humidityInt < 82);
	        assertTrue(humidityInt > 64);
        }
    }
	
	
}
