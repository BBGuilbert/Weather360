import java.awt.EventQueue;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import GUI.WeatherStation;

public class MyMain {

	public static void main(String[] args) {
        try {
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
//            UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (final UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (final IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (final InstantiationException ex) {
            ex.printStackTrace();
        } catch (final ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        /* Turn off metal's use of bold fonts */
        UIManager.put("swing.boldMetal", Boolean.FALSE);
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new WeatherStation();
            }
        });
	}

}
