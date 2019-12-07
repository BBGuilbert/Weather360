/**
 * 
 */
package controller;

import model.WeatherSystem;
import view.GUI;

/**
 * @author miclo
 *
 */
public class Controller {
	
	private GUI myGUI;
	
	private WeatherSystem myWeatherSystem;
	
	public Controller() {
		myGUI = new GUI();
		myWeatherSystem = new WeatherSystem();
	}

}
