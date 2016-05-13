package View;

import Controller.LoginController;
import Model.User;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.LineBorder;

/**
 * This is the View that contains the main UI components, 
 * a JTextField and a JPasswordField where the user can input his credentials, 
 * a JButton to authenticate his credentials and logging in.
 *
 * @author abtahi
 */
public class LoginWindow extends JFrame {

    private JTextField userTextField;
    private JTextField passwordTextField;
    private JButton loginButton;

    private User user;

    public LoginWindow() {
        super("Login MVC");
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        userTextField = new JTextField(15);
        passwordTextField = new JPasswordField(15);
        loginButton = new JButton("Login");
        
        loginButton.setActionCommand("loginButton");

        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new GridLayout(3, 2, 0, 5));
        loginPanel.add(new JLabel("Username:"));
        loginPanel.add(userTextField);
        loginPanel.add(new JLabel("Password:"));
        loginPanel.add(passwordTextField);
        loginPanel.add(loginButton);
        //loginPanel.setBorder(new LineBorder(Color.RED));

        loginButton.addActionListener(new LoginController(this));

        this.setContentPane(loginPanel);
        this.pack();
    }

    public User getUser() {
        user = new User(userTextField.getText(), passwordTextField.getText());
        return user;
    }

    public void showMessage(String message, boolean isValid) {
        if (isValid) {
            JOptionPane.showMessageDialog(this, message, "Success",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, message, "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
