/**
 * TCSS 360 Software Development
 * Project 4
 */

package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;

/**
 * This is the main GUI of the weather system.
 * 
 * @authors Michael Zachary Loria, Dung Thai, Nicholas La Tour-Telles, Brittany Guilbert, Duc Chau
 * @version 12.9.19
 */
public class GUIWeatherStation implements PropertyChangeListener {
	
	/** The date format of the weather system. */
	private static final SimpleDateFormat MY_DATE_FORMAT = new SimpleDateFormat("MM-dd-yyyy");
	
	/** The time format of the weather system. */
	private static final SimpleDateFormat MY_TIME_FORMAT = new SimpleDateFormat("HH:mm:ss");
	
	/** The property change support of this GUI. */
	private final PropertyChangeSupport myPCS = new PropertyChangeSupport(this);
	
	/** The frame of the GUI. */
	private JFrame myFrame;
	
	/** The main panel of the GUI. */
	private JPanel myMainPanel;
	
	/** The title panel of the GUI. */
	private JPanel myTitlePanel;
	
	/** The button panel of the GUI. */
	private JPanel myButtonPanel;
	
	/** The display panel of the GUI. */
	private JPanel myDisplayPanel;
	
	/** The panel containing all sensor data. */
	private JPanel mySensorPanel;
	
	/** The panel containing the current conditions. */
	private JPanel myForecastPanel;
	
	/** The last retrieved time label. */
	private JLabel myLastRetrievedLabel;
	
	/** The button to retrieve the database data. */
	private JButton myRetrieveDatabaseButton;
	
	/** The button to retrieve the current data. */
	private JButton myRetrieveCurrentButton;
	
	/** The list of display panels. */
	private List<JPanel> myDisplayPanels;
	
	/** The list of text areas. */
	private List<JTextArea> myDisplayAreas;
	
	/** The GUI used to retrieve the database. */
	private GUIRetrieveDatabase myHistoricalPopUp;
	
	/** The GUI used to retrieve the current data. */
	private GUIRetrieveCurrent myCurrentPopUp;
	
	/** The database mapping of the associated weather data field with its corresponding index. */
	private Map<String, Integer> myDatabaseMap;
	
	/**
	 * Sets up the GUI and the database mapping.
	 */
	public GUIWeatherStation() {
		setUpDatabaseMap();
		setUpGUI();
	}
	
	/** 
	 * Retrieves all current weather system data.
	 */
	public void fetchAllData() {
		String[] retrieveAllData = 
			{"Date", "Time", "Current Conditions", "Wind Speed", "Wind Direction", "Humidity", "Dew Point", "Rainfall", "Barometer"};
        myPCS.firePropertyChange("retrieve", null, retrieveAllData);  

	}
	
	/** 
	 * Sets up individual components of the GUI.
	 */
	private void setUpGUI() {
		setUpFrames();
		setUpTitlePanel();
		setUpButtonPanel();
		setUpDisplayPanel();
		setUpMainPanel();
		setUpFrame();
	}
	
	/**
	 * Sets up the frame of the GUI.
	 */
	private void setUpFrame() {
		myFrame = new JFrame();
		myFrame.add(myMainPanel);
		myFrame.setTitle("Wilderness Weather Monitoring Station Software");
		myFrame.setBounds(0, 0, 600, 400);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setLocationRelativeTo(null);
		myFrame.setResizable(false);	
		myFrame.setVisible(true);
	}
	
	/**
	 * Sets up the title panel of the GUI.
	 */
	private void setUpTitlePanel() {
		myTitlePanel = new JPanel();
		JLabel title = new JLabel("Weather Station");
		title.setFont(title.getFont().deriveFont(32.0f));
		myTitlePanel.add(title);
	}

	/** 
	 * Sets up the button panel of the GUI.
	 */
	private void setUpButtonPanel() {
		myButtonPanel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();		
		myButtonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		
		setUpButtons();
		
		c.weighty = 1;
		c.gridx = 0;
		c.gridy = 0;
		myButtonPanel.add(myRetrieveDatabaseButton, c);
		
		c.gridy = 1;
		myButtonPanel.add(myRetrieveCurrentButton, c);
		
		c.gridy = 2;
		myLastRetrievedLabel = new JLabel();
		updateLastRetrievedLabel();
		myButtonPanel.add(myLastRetrievedLabel, c);
	}
	
	/**
	 * Updates the label that displays when data
	 * was last retrieved. 
	 */
	private void updateLastRetrievedLabel() {
		String tempDate = MY_DATE_FORMAT.format(new Date());
		String tempTime = MY_TIME_FORMAT.format(new Date());
		myLastRetrievedLabel.setText("<html><body>Data last retrieved on:<br> " + tempDate + " at " + tempTime + "</body></html>");
	}
	
	/**
	 * Updates the selected fields in the graphical 
	 * user interface.
	 * 
	 * @param fetchedData The data that was fetched from the weather system.
	 * @param selectedData The data that was selected by the user to be updated.
	 */
	private void updateSelectedFields(String[] fetchedData, String[] selectedData) {
		Set<Integer> selectedIndices = new HashSet<>();
		for(String i : selectedData) {
			selectedIndices.add(myDatabaseMap.get(i));
		}	
		for(int i = 0; i < myDisplayAreas.size(); i++) {
			if(selectedIndices.contains(i + 2)) {
				myDisplayAreas.get(i).setText(fetchedData[i+2]);
				}
			}
	}
	
	/**
	 * Updates the data in the GUI and updates
	 * the time and date when data was last 
	 * retrieved. 
	 * 
	 * @param fetchedData The data that was fetched from the weather system.
	 * @param selectedData The data that was selected by the user to be updated.
	 */
	public void updateData(String[] fetchedData, String[] selectedFields) {
		updateSelectedFields(fetchedData, selectedFields);
		if(selectedFields.length > 2) {
			updateLastRetrievedLabel();
		}
	}
	
	/**
	 * Sets up the buttons of the GUI.
	 */
	private void setUpButtons() {
		myRetrieveDatabaseButton = new JButton("Download Historical Data");
		myRetrieveDatabaseButton.setPreferredSize(new Dimension(180,80));
		myRetrieveDatabaseButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				myHistoricalPopUp.showFrame();
			}
			
		});
		myRetrieveCurrentButton = new JButton("Download Current Data");
		myRetrieveCurrentButton.setPreferredSize(new Dimension(180,80));
		myRetrieveCurrentButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				myCurrentPopUp.showFrame();
			}
			
		});
		
	}
	
	/**
	 * Sets up the display panel of the GUI.
	 */
	private void setUpDisplayPanel() {
		myDisplayPanels = new ArrayList<>();
		myDisplayAreas = new ArrayList<>();
		myDisplayPanel = new JPanel(new BorderLayout());
		mySensorPanel = new JPanel(new GridLayout(3,2));
		setUpForecastPanel();
		setUpIndividualDisplays("Wind Speed");
		setUpIndividualDisplays("Wind Direction");
		setUpIndividualDisplays("Humidity");
		setUpIndividualDisplays("Dew Point");
		setUpIndividualDisplays("Rainfall");
		setUpIndividualDisplays("Barometer"); 
		for(JPanel i: myDisplayPanels) {
			mySensorPanel.add(i);
		}
		myDisplayPanel.add(myForecastPanel, BorderLayout.NORTH);
		myDisplayPanel.add(mySensorPanel, BorderLayout.CENTER);
	}
	
	/**
	 * Sets up the individual panels that contains the
	 * label and its corresponding text area.
	 * 
	 * @param label The label associated with the panel.
	 */
	private void setUpIndividualDisplays(String label) {
		JPanel tempPanel = new JPanel(new GridLayout(2,1));
		
		JLabel tempLabel = new JLabel(label);
			    
		JTextArea tempArea = new JTextArea();
		
		Border border = BorderFactory.createLineBorder(Color.BLACK);
	    tempArea.setBorder(BorderFactory.createCompoundBorder(border,
	            BorderFactory.createEmptyBorder(5, 5, 5, 5)));
	    
		tempPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	    tempArea.setEditable(false);; // This prevents user from manipulating text area
			
		tempPanel.add(tempLabel);
		tempPanel.add(tempArea);
		
		myDisplayPanels.add(tempPanel);
		myDisplayAreas.add(tempArea);
	}
	
	/**
	 * Sets up the forecast panel of the GUI.
	 */
	private void setUpForecastPanel() {
		myForecastPanel = new JPanel(new GridLayout(2,1));
		
		JLabel tempLabel = new JLabel("Current Conditions");
		JTextArea tempArea = new JTextArea();
		
		Border border = BorderFactory.createLineBorder(Color.BLACK);
	    tempArea.setBorder(BorderFactory.createCompoundBorder(border,
	            BorderFactory.createEmptyBorder(10, 10, 10, 10)));
	    
	    myForecastPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	    tempArea.setEditable(false);
		
	    myForecastPanel.add(tempLabel);
	    myForecastPanel.add(tempArea);
	    
	    myDisplayAreas.add(tempArea);
	}
	
	/**
	 * Sets up the main panel of the GUI.
	 */
	private void setUpMainPanel() {
		myMainPanel = new JPanel(new BorderLayout());
		myMainPanel.add(myTitlePanel, BorderLayout.NORTH);
		myMainPanel.add(myDisplayPanel, BorderLayout.CENTER);
		myMainPanel.add(myButtonPanel, BorderLayout.WEST);
	}
	
	/**
	 * Sets up the different frames of the GUI.
	 */
	private void setUpFrames() {
		myHistoricalPopUp = new GUIRetrieveDatabase();
		myCurrentPopUp = new GUIRetrieveCurrent();
		myCurrentPopUp.addPropertyChangeListener(this);
	}

	@Override
	public void propertyChange(PropertyChangeEvent theEvent) {
        if (theEvent.getPropertyName().equals("retrieve")) {
	        myPCS.firePropertyChange("retrieve", null, theEvent.getNewValue());  
        }
	}
	
    /**
     * Adds a listener for property change events from this class.
     * 
     * @param theListener a PropertyChangeListener to add.
     */
    public void addPropertyChangeListener(final PropertyChangeListener theListener) {
        myPCS.addPropertyChangeListener(theListener);
    }
    
    /**
     * Removes a listener for property change events from this class.
     * 
     * @param theListener a PropertyChangeListener to remove.
     */
    public void removePropertyChangeListener(final PropertyChangeListener theListener) {
        myPCS.removePropertyChangeListener(theListener);
    }
    
    /**
     * Sets up the database mapping of the 
     * weather system.
     */
	private void setUpDatabaseMap() {
		myDatabaseMap = new HashMap<>();
		myDatabaseMap.put("Date",0);
		myDatabaseMap.put("Time",1);
		myDatabaseMap.put("Current Conditions",2);
		myDatabaseMap.put("Wind Speed",3);
		myDatabaseMap.put("Wind Direction",4);
		myDatabaseMap.put("Humidity",5);
		myDatabaseMap.put("Dew Point",6);
		myDatabaseMap.put("Rainfall",7);
		myDatabaseMap.put("Barometer",8);
	}
}
