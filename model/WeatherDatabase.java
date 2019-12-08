/**
 * 
 */
package model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.TimerTask;

/**
 * @author miclo
 *
 */
public class WeatherDatabase {
	
	File myDatabase;
	
	public WeatherDatabase() {
		myDatabase = new File("database.csv");
	}
	
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
	
	public File sendReport() {
		return myDatabase;
	}
}
