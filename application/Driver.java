/**
 * TCSS 360 Software Development
 * Project 4
 */

package application;

import java.awt.EventQueue;

import controller.Controller;

/**
 * This is the Console class that retrieves all of the
 * data from the weather sensors.
 * 
 * @authors Michael Zachary Loria, Dung Thai, Nicholas La Tour-Telles, Britanny Guilbert, Duc Chau
 * @version 12.9.19
 */
public class Driver {

	/**
	 * Launches the weather system software application.
	 * 
	 * @param args The console options from the OS.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new Controller();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
