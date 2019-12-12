/**
 * TCSS 360 Software Development
 * Project 4
 */

package Tests;

import org.junit.Test;

/**
 * Unit tests of the HumiditySensor class.
 * 
 * @authors Michael Zachary Loria, Dung Thai, Nicholas La Tour-Telles, Brittany Guilbert, Duc Chau
 * @version 12/6/2019
 *
 */

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
     * Test method for {@link sensor.HumiditySensor#getData()}.
     */
    @Test
    public void testGetData() 
    {
    	String humidity = humSen.toString();
    	String humidityNum = humidity.replace("  g/m³", "");
    	int humidityInt = Integer.parseInt(humidityNum);
        assertTrue(humidity.endsWith("  g/m³")); //check that Humidity data ends with g/m³
        
        //check that dewPoint data is in the proper range
        for(int i= 0; i<100; i++) {
	        assertTrue(humidityInt < 82);
	        assertTrue(humidityInt > 64);
        }
    }
	
	
}
