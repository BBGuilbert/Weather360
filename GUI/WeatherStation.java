package GUI;

import javax.swing.JFrame;

public class WeatherStation extends JFrame{
	
	public WeatherStation() {
        // Sets Title on JFrame
        super("Weather Station");
        
        // Starts GUI
        initGUI();

        setVisible(true);
    }
    
    /**
     * Sets up the GUI.
     */
    private void initGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
      
        setResizable(false);
        pack();
  
    }

}
