/**
 * TCSS 360 Software Development
 * Project 4
 */

package tests;

import org.junit.Test;

import sensor.AbstractSensor;
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

public abstract class AbstractSensorTest {
	
	AbstractSensor mySensor;
	String mySuffix;
	int myLow;
	int myHigh;
	
	/**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() 
    {
          
    }

    /**
     * Test method 
     */
    @Test
    public void testGetData() 
    {
    	String name = mySensor.toString();
    	String sansSuffix = name.replace(mySuffix, "");
    	double data = Double.parseDouble(sansSuffix);
        assertTrue(name.endsWith(mySuffix)); //check that data ends with its suffix
        
        //check that data is in the proper range
        for(int i= 0; i<100; i++) {
	        assertTrue(data <= myHigh);
	        assertTrue(data >= myLow);
	        assertTrue(Double.parseDouble(mySensor.getData()) <= myHigh);
	        assertTrue(Double.parseDouble(mySensor.getData()) >= myLow);
        }
    }
    
}
