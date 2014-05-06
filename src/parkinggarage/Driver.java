package parkinggarage;

import javax.swing.UIManager;

/**
 *
 * @author J-Tron
 * @version 1.2
 * This is the startup class for the Garage Program. It instantiates the Main Window
 * object GUI from which all other functionality of the program occurs.
 * 
 */
public class Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Set the O/S System Look and Feel for the Main Window
        try {          
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            System.out.println("Couldn't load System Look and Feel");
        } 
        
        // Creates the main window object and makes it visible
        MainWindow win = new MainWindow();
        win.setVisible(true);
    }           
}
