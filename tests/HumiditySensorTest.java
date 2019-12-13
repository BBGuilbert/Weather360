/**
 * TCSS 360 Software Development
 * Project 4
 */

package tests;

/**
 * Unit tests of the HumiditySensor class.
 * 
 * @authors Michael Zachary Loria, Dung Thai, Nicholas La Tour-Telles, Brittany Guilbert, Duc Chau
 * @version 12/6/2019
 *
 */

import sensor.HumiditySensor;
import org.junit.Before;

public class HumiditySensorTest extends AbstractSensorTest{
	
	/**
     * @throws java.lang.Exception
     */
	@Override
    @Before
    public void setUp() 
    {
		mySensor =  new HumiditySensor();  
        mySuffix = "  g/m³";
        myLow = 65;
        myHigh = 81;        
    }

	
}
