package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class GUIHistoricalData {
	
	private JFrame myFrame;
	
	private JPanel myMainPanel;
	
	private JPanel myTitlePanel;
	
	private JPanel myDataPanel;
	
	private JPanel myButtonPanel;
	
	private JButton myExitButton;
	
	private Map<String, Integer> myDatabaseMap;
	
	/**
	 * This is the database file for the program. A new line represents a new entry to the database. Different 
	 * columns are separated by commas, in the following order:
	 * Date, Time, Forecast, Wind Speed, Wind Direction, Humidity, Dew Point, Rainfall, Barometer.
	 */
	private static final File DATABASE_FILE = new File("database.csv");
	
	public GUIHistoricalData() {
		setUpDatabaseMap();
		setUpGUIHistoricalData();
	}
	
	private void setUpGUIHistoricalData() {
		setUpTitlePanel();
		setUpButtonPanel();
		setUpMainPanel();
		setUpFrame();
	}
	
	private void setUpFrame() {
		myFrame = new JFrame();
		myFrame.add(myMainPanel);
		myFrame.setTitle("Historical Data");
		myFrame.setBounds(0, 0, 800, 400);
		myFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		myFrame.setLocationRelativeTo(null);
		myFrame.setResizable(false);	
	}
	
	public void showFrame(String[] theColumns) {
		setUpDataPanel(theColumns);
		myFrame.setVisible(true);
	}
	
	private void setUpTitlePanel() {
		myTitlePanel = new JPanel();
		JLabel title = new JLabel("Historical Data");
		title.setFont(title.getFont().deriveFont(24.0f));
		myTitlePanel.add(title);
	}
	
	private void setUpDataPanel(String[] selectedData) {
		myDataPanel.removeAll();
		Set<Integer> selectedIndices = new HashSet<>();
		for(String i : selectedData) {
			selectedIndices.add(myDatabaseMap.get(i));
		}		
		List<String[]> myRows = new ArrayList<>();
		try {
			Scanner myFileScanner = new Scanner(DATABASE_FILE);
			while(myFileScanner.hasNextLine()) {
				String[] temp = myFileScanner.nextLine().split(",");
				String[] selectedColumns = new String[selectedIndices.size()];
				int j = 0;
				for(int i = 0; i < temp.length; i++) {
					if(selectedIndices.contains(i)) {
						selectedColumns[j] = temp[i];
						j++;
					}
				}
				myRows.add(selectedColumns);
			}
			myFileScanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("Database file not found.");
		}
		Object[][] myData = new Object[myRows.size()][8];
		for(int i = 0; i < myRows.size(); i++) {
			myData[i] = myRows.get(i);
		}

		JTable myJTable = new JTable(myData, selectedData);
		
		myJTable.setRowHeight(30);
		JScrollPane myScrollPane = new JScrollPane(myJTable);
		myDataPanel.add(myScrollPane);
	}
	
	private void setUpButtonPanel() {
		myButtonPanel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();		
		myButtonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

		myExitButton = new JButton("Exit");
		myExitButton.setFont(myExitButton.getFont().deriveFont(13.0f));
		myExitButton.setPreferredSize(new Dimension(70,50));
		
		myExitButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				myFrame.setVisible(false);
			}
			
		});
		c.gridx = 0;
		c.gridy = 0;
		myButtonPanel.add(myExitButton, c);
	}
	
	private void setUpMainPanel() {
		myMainPanel = new JPanel(new BorderLayout());
		myDataPanel = new JPanel(new GridLayout());
		myMainPanel.add(myTitlePanel, BorderLayout.NORTH);
		myMainPanel.add(myDataPanel, BorderLayout.CENTER);
		myMainPanel.add(myButtonPanel, BorderLayout.WEST);
	}
	
	
	private void setUpDatabaseMap() {
		myDatabaseMap = new HashMap<>();
		myDatabaseMap.put("Date",0);
		myDatabaseMap.put("Time",1);
		myDatabaseMap.put("Forecast",2);
		myDatabaseMap.put("Wind Speed",3);
		myDatabaseMap.put("Wind Direction",4);
		myDatabaseMap.put("Humidity",5);
		myDatabaseMap.put("Dew Point",6);
		myDatabaseMap.put("Rainfall",7);
		myDatabaseMap.put("Barometer",8);
	}

}
