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
import java.util.ArrayList;
import java.util.List;

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
public class GUI {
	
	private JFrame myFrame;
	
	private JPanel myMainPanel;
	
	private JPanel myTitlePanel;
	
	private JPanel myButtonPanel;
	
	private JPanel myDisplayPanel;
	
	private JPanel mySensorPanel;
	
	private JPanel myForecastPanel;
	
	private JButton myRetrieveDatabaseButton;
	
	private JButton myRetrieveCurrentButton;
	
	private List<JPanel> myDisplayPanels;
	
	private List<JTextArea> myDisplayAreas;
	
	public GUI() {
		setUpGUI();
	}
	
	private void setUpGUI() {
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
	}
	
	private void setUpButtons() {
		myRetrieveDatabaseButton = new JButton("Retrieve Historical Data");
		myRetrieveDatabaseButton.setPreferredSize(new Dimension(180,80));
		myRetrieveDatabaseButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		myRetrieveCurrentButton = new JButton("Retrieve Current Data");
		myRetrieveCurrentButton.setPreferredSize(new Dimension(180,80));
		myRetrieveCurrentButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
	}
	
	private void setUpDisplayPanel() {
		myDisplayPanel = new JPanel(new BorderLayout());
		setUpForecastPanel();
		mySensorPanel = new JPanel(new GridLayout(3,2));
		myDisplayPanels = new ArrayList<>();
		myDisplayAreas = new ArrayList<>();
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
	    tempArea.setEnabled(false); // This prevents user from manipulating text area
			
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
	    tempArea.setEnabled(false);
		
	    myForecastPanel.add(tempLabel);
	    myForecastPanel.add(tempArea);
	}
	
	private void setUpMainPanel() {
		myMainPanel = new JPanel(new BorderLayout());
		myMainPanel.add(myTitlePanel, BorderLayout.NORTH);
		myMainPanel.add(myDisplayPanel, BorderLayout.CENTER);
		myMainPanel.add(myButtonPanel, BorderLayout.WEST);
	}
	


}
