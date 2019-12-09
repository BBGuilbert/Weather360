/**
 * 
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
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
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
import javax.swing.JTextArea;
import javax.swing.border.Border;

/**
 * @author miclo
 *
 */
public class GUIWeatherStation implements PropertyChangeListener {
	
	private static final SimpleDateFormat MY_DATE_FORMAT = new SimpleDateFormat("MM-dd-yyyy");
	
	private static final SimpleDateFormat MY_TIME_FORMAT = new SimpleDateFormat("HH:mm:ss");
	
	private final PropertyChangeSupport myPCS = new PropertyChangeSupport(this);
	
	private JFrame myFrame;
	
	private JPanel myMainPanel;
	
	private JPanel myTitlePanel;
	
	private JPanel myButtonPanel;
	
	private JPanel myDisplayPanel;
	
	private JPanel mySensorPanel;
	
	private JPanel myForecastPanel;
	
	private JLabel myLastRetrievedLabel;
	
	private JButton myRetrieveDatabaseButton;
	
	private JButton myRetrieveCurrentButton;
	
	private List<JPanel> myDisplayPanels;
	
	private List<JTextArea> myDisplayAreas;
	
	private GUIRetrieveDatabase myHistoricalPopUp;
	
	private GUIRetrieveCurrent myCurrentPopUp;
	
	private Map<String, Integer> myDatabaseMap;
	
	public GUIWeatherStation() {
		setUpDatabaseMap();
		setUpGUI();
	}
	
	public void fetchAllData() {
		String[] retrieveAllData = 
			{"Date", "Time", "Forecast", "Wind Speed", "Wind Direction", "Humidity", "Dew Point", "Rainfall", "Barometer"};
        myPCS.firePropertyChange("retrieve", null, retrieveAllData);  

	}
	
	private void setUpGUI() {
		setUpFrames();
		setUpTitlePanel();
		setUpButtonPanel();
		setUpDisplayPanel();
		setUpMainPanel();
		setUpFrame();
	}
	
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
	
	private void setUpTitlePanel() {
		myTitlePanel = new JPanel();
		JLabel title = new JLabel("Weather Station");
		title.setFont(title.getFont().deriveFont(32.0f));
		myTitlePanel.add(title);
	}

	
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
	
	private void updateLastRetrievedLabel() {
		String tempDate = MY_DATE_FORMAT.format(new Date());
		String tempTime = MY_TIME_FORMAT.format(new Date());
		myLastRetrievedLabel.setText("<html><body>Data last retrieved on:<br> " + tempDate + " at " + tempTime + "</body></html>");
	}
	
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
	
	public void updateData(String[] fetchedData, String[] selectedFields) {
		updateSelectedFields(fetchedData, selectedFields);
		if(selectedFields.length > 2) {
			updateLastRetrievedLabel();
		}
	}
	
	private void setUpButtons() {
		myRetrieveDatabaseButton = new JButton("Retrieve Historical Data");
		myRetrieveDatabaseButton.setPreferredSize(new Dimension(180,80));
		myRetrieveDatabaseButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				myHistoricalPopUp.showFrame();
				// TODO Auto-generated method stub
			}
			
		});
		myRetrieveCurrentButton = new JButton("Retrieve Current Data");
		myRetrieveCurrentButton.setPreferredSize(new Dimension(180,80));
		myRetrieveCurrentButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				myCurrentPopUp.showFrame();
			}
			
		});
		
	}
	
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
	
	private void setUpForecastPanel() {
		myForecastPanel = new JPanel(new GridLayout(2,1));
		
		JLabel tempLabel = new JLabel("Forecast");
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
	
	private void setUpMainPanel() {
		myMainPanel = new JPanel(new BorderLayout());
		myMainPanel.add(myTitlePanel, BorderLayout.NORTH);
		myMainPanel.add(myDisplayPanel, BorderLayout.CENTER);
		myMainPanel.add(myButtonPanel, BorderLayout.WEST);
	}
	
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
