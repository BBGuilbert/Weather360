/**
 * TCSS 360 Software Development
 * Project 4
 */

package tests;


import sensor.Barometer;

import org.junit.Before;


/**
 * Unit tests of the Barometer class.
 * 
 * @authors Michael Zachary Loria, Dung Thai, Nicholas La Tour-Telles, Brittany Guilbert, Duc Chau
 * @version 12/6/2019
 *
 */

public class BarometerTest extends AbstractSensorTest{
	Barometer bar;
	
	/**
     * @throws java.lang.Exception
     */
	@Override
    @Before
    public void setUp() 
    {
		mySensor =  new Barometer();  
        mySuffix = " millibars";
        myLow = 900;
        myHigh = 1100;
        
    }

    
    
}
