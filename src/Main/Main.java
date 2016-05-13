package Main;

import View.LoginWindow;
import javax.swing.JOptionPane;

/**
 *
 * @author abtahi
 */
public class Main {

    public static void main(String[] args) {
        LoginWindow window;

        try {
            window = new LoginWindow();
            window.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Initialization Failed",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
