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

public class GUIHistoricalData {
	
	private JFrame myFrame;
	
	private JPanel myMainPanel;
	
	private JPanel myTitlePanel;
	
	private JPanel myDataPanel;
	
	private JPanel myButtonPanel;
	
	private JButton myExitButton;
	
	private List<JCheckBox> myCheckBoxes;
	
	public GUIHistoricalData() {
		setUpGUIHistoricalData();
	}
	
	private void setUpGUIHistoricalData() {
		setUpTitlePanel();
		setUpDataPanel();
		setUpButtonPanel();
		setUpMainPanel();
		setUpFrame();
	}
	
	private void setUpFrame() {
		myFrame = new JFrame();
		myFrame.add(myMainPanel);
		myFrame.setTitle("Historical Data");
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
		JLabel title = new JLabel("Historical Data");
		title.setFont(title.getFont().deriveFont(24.0f));
		myTitlePanel.add(title);
	}
	
	private void setUpDataPanel() {
		myDataPanel = new JPanel();
	}
	
	private void setUpButtonPanel() {
		myButtonPanel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();		
		myButtonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

		myExitButton = new JButton("Exit");
		myExitButton.setFont(myExitButton.getFont().deriveFont(13.0f));
		myExitButton.setPreferredSize(new Dimension(180,80));
		
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
		myMainPanel.add(myTitlePanel, BorderLayout.NORTH);
		myMainPanel.add(myDataPanel, BorderLayout.CENTER);
		myMainPanel.add(myButtonPanel, BorderLayout.WEST);
	}

}
