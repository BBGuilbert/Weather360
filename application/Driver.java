/**
 * TCSS 360 Software Development
 * Project 4
 */

package application;

import java.awt.EventQueue;

import controller.Controller;

/**
 * @author miclo
 *
 */
public class Driver {

	/**
	 * @param args
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
