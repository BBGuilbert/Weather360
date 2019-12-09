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
 * @author miclo
 *
 */
public class Controller implements PropertyChangeListener {
	
	private GUIWeatherStation myGUI;
	
	private WeatherSystem myWeatherSystem;
	
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
