/**
 * TCSS 360 Software Development
 * Project 4
 */

package Tests;

import org.junit.Test;

import sensor.HumiditySensor;

import static org.junit.Assert.assertTrue;

import org.junit.Before;

public class HumiditySensorTest {

	HumiditySensor humSen;
	
	/**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() 
    {
    	humSen = new HumiditySensor();
        
        
    }

    /**
     * Test method for {@link sensor.DewPointSensor#getData()}.
     */
    @Test
    public void testGetData() 
    {
    	String humidity = humSen.toString();
    	String humidityNum = humidity.replace("  g/m�", "");
    	int humidityInt = Integer.parseInt(humidityNum);
        assertTrue(humidity.endsWith("  g/m�")); //check that dewPoint data ends with degrees
        
        //check that dewPoint data is in the proper range
        for(int i= 0; i<100; i++) {
	        assertTrue(humidityInt < 82);
	        assertTrue(humidityInt > 64);
        }
    }
	
	
}
