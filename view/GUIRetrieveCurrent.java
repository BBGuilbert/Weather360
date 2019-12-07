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

public class GUIRetrieveCurrent {
	
	private JFrame myFrame;
	
	private JPanel myMainPanel;
	
	private JPanel myTitlePanel;
	
	private JPanel myCheckBoxPanel;
	
	private JPanel myButtonPanel;
	
	private JButton myViewButton;
	
	private List<JCheckBox> myCheckBoxes;
	
	public GUIRetrieveCurrent() {
		setUpGUIRetrieveCurrent();
	}
	
	private void setUpGUIRetrieveCurrent() {
		setUpTitlePanel();
		setUpCheckBoxPanel();
		setUpButtonPanel();
		setUpMainPanel();
		setUpFrame();
	}
	
	private void setUpFrame() {
		myFrame = new JFrame();
		myFrame.add(myMainPanel);
		myFrame.setTitle("Download Current Data");
		myFrame.setBounds(0, 0, 600, 400);
		myFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		myFrame.setLocationRelativeTo(null);
		myFrame.setResizable(false);	
	}
	
	public void showFrame() {
		myFrame.setVisible(true);
	}
	
	private void setUpTitlePanel() {
		myTitlePanel = new JPanel();
		JLabel title = new JLabel("Download Current Data");
		title.setFont(title.getFont().deriveFont(24.0f));
		myTitlePanel.add(title);
	}
	
	private void setUpCheckBoxPanel() {
		myCheckBoxes = new ArrayList<>();
		myCheckBoxPanel = new JPanel(new GridLayout(3,3));
		createCheckBox("Date");
		createCheckBox("Time");
		createCheckBox("Forecast");
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
	
	private void createCheckBox(String name) {
		JCheckBox temp = new JCheckBox(name);
		temp.setFont(temp.getFont().deriveFont(13.0f));
		myCheckBoxes.add(temp);
		myCheckBoxPanel.add(temp);
	}
	
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
				// TODO
			}
			
		});
		c.gridx = 0;
		c.gridy = 0;
		myButtonPanel.add(myViewButton, c);
	}
	
	private void setUpMainPanel() {
		myMainPanel = new JPanel(new BorderLayout());
		myMainPanel.add(myTitlePanel, BorderLayout.NORTH);
		myMainPanel.add(myCheckBoxPanel, BorderLayout.CENTER);
		myMainPanel.add(myButtonPanel, BorderLayout.WEST);
	}

}
