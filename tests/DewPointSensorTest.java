/**
 * TCSS 360 Software Development
 * Project 4
 */

package Tests;

import org.junit.Test;

import sensor.DewPointSensor;

import static org.junit.Assert.assertTrue;

import org.junit.Before;

/**
 * Unit tests of the DewPointSensor class.
 * 
 * @authors Michael Zachary Loria, Dung Thai, Nicholas La Tour-Telles, Brittany Guilbert, Duc Chau
 * @version 12/6/2019
 *
 */
public class DewPointSensorTest {
	
	DewPointSensor dew;
	
	/**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() 
    {
    	dew = new DewPointSensor();
        
        
    }

    /**
     * Test method for {@link sensor.DewPointSensor#getData()}.
     */
    @Test
    public void testGetData() 
    {
    	String dewPoint = dew.toString();
    	String dewPointNum = dewPoint.replace(" degrees", "");
    	int dewPointInt = Integer.parseInt(dewPointNum);
        assertTrue(dewPoint.endsWith(" degrees")); //check that dewPoint data ends with degrees
        
        //check that dewPoint data is in the proper range
        for(int i= 0; i<100; i++) {
	        assertTrue(dewPointInt < 101);
	        assertTrue(dewPointInt > 19);
        }
    }

}
