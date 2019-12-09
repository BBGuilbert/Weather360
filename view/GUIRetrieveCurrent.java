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
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
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
 * current data information.
 * 
 * @authors Michael Zachary Loria, Dung Thai, Nicholas La Tour-Telles, Brittany Guilbert, Duc Chau
 * @version 12.9.19
 */
public class GUIRetrieveCurrent {
	
	/** The property change support of this GUI. */
	private final PropertyChangeSupport myPCS = new PropertyChangeSupport(this);
	
	/** The frame of the GUI. */
	private JFrame myFrame;
	
	/** The main panel of the GUI. */
	private JPanel myMainPanel;
	
	/** The title panel of the GUI. */
	private JPanel myTitlePanel;
	
	/** The panel containing the JCheckBox of the GUI. */
	private JPanel myCheckBoxPanel;
	
	/** The button panel of the GUI. */
	private JPanel myButtonPanel;
	
	/** The view button of the GUI. */
	private JButton myViewButton;
	
	/** The list of JCheckBox used in the GUI. */
	private List<JCheckBox> myCheckBoxes;
	
	/**
	 * Sets up the components of the GUI.
	 */
	public GUIRetrieveCurrent() {
		setUpGUIRetrieveCurrent();
	}
	
	/**
	 * Sets up individual components of the
	 * user interface.
	 */
	private void setUpGUIRetrieveCurrent() {
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
		myFrame = new JFrame();
		myFrame.add(myMainPanel);
		myFrame.setTitle("Download Current Data");
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
		JLabel title = new JLabel("Download Current Data");
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
		myCheckBoxes.get(0).setSelected(true);
		myCheckBoxes.get(1).setSelected(true);
		myCheckBoxes.get(0).setEnabled(false);
		myCheckBoxes.get(1).setEnabled(false);
		
	}
	
	/** 
	 * Creates the check box with the specified
	 * name.
	 * 
	 * @param name The name of the JCheckBox.
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

		myViewButton = new JButton("Return Selected Data");
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
		        myPCS.firePropertyChange("retrieve", null, checkedBoxes.toArray(new String[checkedBoxes.size()]));  
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

}
