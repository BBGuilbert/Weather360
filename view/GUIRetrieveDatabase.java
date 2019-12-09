/**
 * TCSS 360 Software Development
 * Project 4
 */

package view;

import java.awt.BorderLayout;
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
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * This is the GUI that displays the retrieve
 * database information.
 * 
 * @authors Michael Zachary Loria, Dung Thai, Nicholas La Tour-Telles, Brittany Guilbert, Duc Chau
 * @version 12.9.19
 */
public class GUIRetrieveDatabase {
	
	/** The frame of the GUI. */
	private JFrame myFrame;
	
	/** The historical data frame. */
	private GUIHistoricalData myHistoricalDataFrame;
	
	/** The main panel of the GUI. */
	private JPanel myMainPanel;
	
	/** The title panel of the GUI. */
	private JPanel myTitlePanel;
	
	/** The check box panel of the GUI. */
	private JPanel myCheckBoxPanel;
	
	/** The button panel of the GUI. */
	private JPanel myButtonPanel;
	
	/** The view button of the GUI. */
	private JButton myViewButton;
	
	/** The list of checkboxes of the GUI. */
	private List<JCheckBox> myCheckBoxes;
	
	/** 
	 * Sets up the components of the GUI.
	 */
	public GUIRetrieveDatabase() {
		setUpGUIRetrieveDatabase();
	}
	
	/**
	 * Sets up individual components of the
	 * user interface.
	 */
	private void setUpGUIRetrieveDatabase() {
		setUpTitlePanel();
		setUpCheckBoxPanel();
		setUpButtonPanel();
		setUpMainPanel();
		setUpFrame();
	}
	
	/**
	 * Sets up the frame of the GUI.
	 */
	private void setUpFrame() {
		myHistoricalDataFrame = new GUIHistoricalData(); 
		myFrame = new JFrame();
		myFrame.add(myMainPanel);
		myFrame.setTitle("Download Historical Data from Database");
		myFrame.setBounds(0, 0, 800, 400);
		myFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		myFrame.setLocationRelativeTo(null);
		myFrame.setResizable(false);	
	}
	
	/**
	 * Displays the frame.
	 */
	public void showFrame() {
		myFrame.setVisible(true);
	}
	
	/**
	 * Sets up the title panel of the GUI.
	 */
	private void setUpTitlePanel() {
		myTitlePanel = new JPanel();
		JLabel title = new JLabel("Download Historical Data from Database");
		title.setFont(title.getFont().deriveFont(24.0f));
		myTitlePanel.add(title);
	}
	
	/**
	 * Sets up the check box panel of the GUI.
	 */
	private void setUpCheckBoxPanel() {
		myCheckBoxes = new ArrayList<>();
		myCheckBoxPanel = new JPanel(new GridLayout(3,3));
		createCheckBox("Date");
		createCheckBox("Time");
		createCheckBox("Current Conditions");
		createCheckBox("Wind Speed");
		createCheckBox("Wind Direction");
		createCheckBox("Humidity");
		createCheckBox("Dew Point");
		createCheckBox("Rainfall");
		createCheckBox("Barometer");
	}
	
	/**
	 * Creates an individual check box with
	 * the specified name. 
	 * 
	 * @param name The name of the check box.
	 */
	private void createCheckBox(String name) {
		JCheckBox temp = new JCheckBox(name);
		temp.setFont(temp.getFont().deriveFont(13.0f));
		myCheckBoxes.add(temp);
		myCheckBoxPanel.add(temp);
	}
	
	/** 
	 * Sets up the button panel of the GUI.
	 */
	private void setUpButtonPanel() {
		myButtonPanel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();		
		myButtonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

		myViewButton = new JButton("View Selected Data");
		myViewButton.setFont(myViewButton.getFont().deriveFont(13.0f));
		myViewButton.setPreferredSize(new Dimension(180,80));
		
		myViewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				myFrame.setVisible(false);
				List<String> checkedBoxes = new ArrayList<>();
				for(JCheckBox box: myCheckBoxes) {
					if(box.isSelected()) {
						checkedBoxes.add(box.getText());
					}
				}
				myHistoricalDataFrame.showFrame(checkedBoxes.toArray(new String[checkedBoxes.size()]));
			}
			
		});
		c.gridx = 0;
		c.gridy = 0;
		myButtonPanel.add(myViewButton, c);
	}
	
	/**
	 * Sets up the main panel of the GUI.
	 */
	private void setUpMainPanel() {
		myMainPanel = new JPanel(new BorderLayout());
		myMainPanel.add(myTitlePanel, BorderLayout.NORTH);
		myMainPanel.add(myCheckBoxPanel, BorderLayout.CENTER);
		myMainPanel.add(myButtonPanel, BorderLayout.WEST);
	}
}
