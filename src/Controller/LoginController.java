package Controller;

import Model.DatabaseManager;
import Model.User;
import View.LoginWindow;
import java.awt.event.*;
import java.sql.*;

/**
 * This is the Controller class that implements the ActionListener interface. 
 * It will be invoked as a result of a user’s action on the View. 
 * In this case it will be invoked if the user press the JButton.
 *
 * @author abtahi
 */
public class LoginController implements ActionListener {

    private User user;
    private DatabaseManager dbManager;
    private LoginWindow loginWindow;

    public LoginController(LoginWindow loginWindow) {
        this.loginWindow = loginWindow;
        this.dbManager = new DatabaseManager();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getActionCommand().equals("loginButton")) {
            try {
                user = loginWindow.getUser();
                if (dbManager.authenticateUser(user)) {
                    loginWindow.showMessage("Login Succesfull!", true);
                } else {
                    loginWindow.showMessage("Invalid Username or Password!", false);
                }
            } catch (SQLException e) {
                loginWindow.showMessage("SQLException Occured", false);
            }
        }
    }
}
