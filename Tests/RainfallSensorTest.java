/**
 * TCSS 360 Software Development
 * Project 4
 */

package Tests;

import sensor.RainfallSensor;

import org.junit.Before;

/**
 * Unit tests of the Barometer class.
 * 
 * @authors Michael Zachary Loria, Dung Thai, Nicholas La Tour-Telles, Brittany Guilbert, Duc Chau
 * @version 12/6/2019
 *
 */

public class RainfallSensorTest extends AbstractSensorTest {
	
	
	/**
     * @throws java.lang.Exception
     */
	@Override
    @Before
    public void setUp() 
    {
		mySensor =  new RainfallSensor();  
        mySuffix = " inches";
        myLow = 0;
        myHigh = 10;
        
    }
	 
    
}
