/**
 * 
 */
package view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author miclo
 *
 */
public class GUI {
	
	private JFrame myFrame;
	
	private JPanel myPanel;
	
	private JButton myButton;
	
	public GUI() {
		setUpGUI();
	}
	
	private void setUpGUI() {
		setUpPanel();
		setUpFrame();
	}
	
	private void setUpFrame() {
		myFrame = new JFrame();
		myFrame.add(myPanel);
		myFrame.setTitle("Wilderness Weather Monitoring Station Software");
		myFrame.setBounds(0, 0, 600, 400);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setLocationRelativeTo(null);
		myFrame.setResizable(false);	
		myFrame.setVisible(true);
	}
	
	private void setUpPanel() {
		myPanel = new JPanel();
		myButton = new JButton("Hello");
		myPanel.add(myButton);
	}

}
