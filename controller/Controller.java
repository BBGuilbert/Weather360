/**
 * TCSS 360 Software Development
 * Project 4
 */

package controller;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import model.WeatherSystem;
import view.GUIWeatherStation;

/**
 * This is the Controller class connects the weather
 * system to the graphical user interface.
 * 
 * @authors Michael Zachary Loria, Dung Thai, Nicholas La Tour-Telles, Brittany Guilbert, Duc Chau
 * @version 12.9.19
 */
public class Controller implements PropertyChangeListener {
	
	/** The GUI of the weather system. */
	private GUIWeatherStation myGUI;
	
	/** The weather system of program. */
	private WeatherSystem myWeatherSystem;
	
	/**
	 * Initializes the GUI and the WeatherSystem.
	 */
	public Controller() {
		myGUI = new GUIWeatherStation();
		myGUI.addPropertyChangeListener(this);
		myWeatherSystem = new WeatherSystem();
		myGUI.fetchAllData();

	}
	
	@Override
	public void propertyChange(PropertyChangeEvent theEvent) {
        if (theEvent.getPropertyName().equals("retrieve")) {
        	myGUI.updateData(myWeatherSystem.getCurrentWeather(), (String[])theEvent.getNewValue());
        }
	}
}
