/**
 * TCSS 360 Software Development
 * Project 4
 */

package tests;

import sensor.DewPointSensor;

import org.junit.Before;

/**
 * Unit tests of the DewPointSensor class.
 * 
 * @authors Michael Zachary Loria, Dung Thai, Nicholas La Tour-Telles, Brittany Guilbert, Duc Chau
 * @version 12/6/2019
 *
 */
public class DewPointSensorTest extends AbstractSensorTest{
	
	/**
     * @throws java.lang.Exception
     */
	@Override
    @Before
    public void setUp() 
    {
		mySensor =  new DewPointSensor();  
        mySuffix = " degrees";
        myLow = 20;
        myHigh = 100;        
    }

}
