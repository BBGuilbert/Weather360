/**
 * TCSS 360 Software Development
 * Project 4
 */

package Tests;

import org.junit.Test;

import sensor.Barometer;

import static org.junit.Assert.assertTrue;

import org.junit.Before;


/**
 * Unit tests of the Barometer class.
 * 
 * @authors Michael Zachary Loria, Dung Thai, Nicholas La Tour-Telles, Brittany Guilbert, Duc Chau
 * @version 12/6/2019
 *
 */

public class BarometerTest {
	Barometer bar;
	
	/**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() 
    {
    	bar = new Barometer();
        
        
    }

    /**
     * Test method for {@link sensor.Barometer#getData()}.
     */
    @Test
    public void testGetData() 
    {
    	String pressure = bar.toString();
    	String pressureNum = pressure.replace(" millibars", "");
    	int pressureInt = Integer.parseInt(pressureNum);
        assertTrue(pressure.endsWith(" millibars")); //check that barometer data ends with millibars
        
        //check that barometer data is in the proper range
        for(int i= 0; i<100; i++) {
	        assertTrue(pressureInt < 1101);
	        assertTrue(pressureInt > 899);
        }
    }
    
}
