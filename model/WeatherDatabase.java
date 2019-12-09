/**
 * TCSS 360 Software Development
 * Project 4
 */

package model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * This is the class that handles the database
 * for the weather system.
 * 
 * @authors Michael Zachary Loria, Dung Thai, Nicholas La Tour-Telles, Britanny Guilbert, Duc Chau
 * @version 12.9.19
 */
public class WeatherDatabase {
	
	/** The file containing the database for the system. */
	private final File myDatabase;
	
	/**
	 * Initialize the file for the database. 
	 */
	public WeatherDatabase() {
		myDatabase = new File("database.csv");
	}
	
	/**
	 * Updates the database by adding the data to the
	 * database.
	 * 
	 * @param theData The data to be added to the database. 
	 */
	public void addData(List<String> theData) {
		FileWriter csvWriter;
		try {
			csvWriter = new FileWriter(myDatabase.getName(), true);
			csvWriter.append(String.join(",", theData));
			csvWriter.append("\n");
			csvWriter.flush();
			csvWriter.close();
		} catch (IOException e) {
			System.out.println("Unable to update data in database.");
		}
	}
	
	/**
	 * Sends the database report. 
	 * 
	 * @return File containing the databse report.
	 */
	public File sendReport() {
		return myDatabase;
	}
}
