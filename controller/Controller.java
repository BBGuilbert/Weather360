/**
 * 
 */
package controller;

import model.WeatherSystem;
import view.GUIWeatherStation;

/**
 * @author miclo
 *
 */
public class Controller {
	
	private GUIWeatherStation myGUI;
	
	private WeatherSystem myWeatherSystem;
	
	public Controller() {
		myGUI = new GUIWeatherStation();
		myWeatherSystem = new WeatherSystem();
	}

}
