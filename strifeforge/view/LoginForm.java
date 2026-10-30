package strifeforge.view;

import javax.swing.*;
import java.awt.*;

public class LoginForm extends javax.swing.JFrame {

    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton btnLogin;

    public LoginForm() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Strife Forge Gym - Login");
        setSize(380, 220);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 15));
        panel.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

        JLabel lblUsername = new JLabel("Username:");
        txtUsername = new JTextField();

        JLabel lblPassword = new JLabel("Password:");
        txtPassword = new JPasswordField();

        btnLogin = new JButton("Login");

        panel.add(lblUsername);
        panel.add(txtUsername);
        panel.add(lblPassword);
        panel.add(txtPassword);
        panel.add(new JLabel());
        panel.add(btnLogin);

        add(panel);
    }

    public String getUsernameInput() {
        return txtUsername.getText();
    }

    public String getPasswordInput() {
        return new String(txtPassword.getPassword());
    }

    public JButton getBtnLogin() {
        return btnLogin;
    }

    public void resetForm() {
        txtUsername.setText("");
        txtPassword.setText("");
        txtUsername.requestFocus();
    }
}