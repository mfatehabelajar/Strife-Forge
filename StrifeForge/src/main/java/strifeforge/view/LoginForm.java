package strifeforge.view;

import javax.swing.*;
import java.awt.*;

public class LoginForm extends JFrame {
    public JTextField txtUsername = new JTextField();
    public JPasswordField txtPassword = new JPasswordField();
    public JButton btnLogin = new JButton("Login");

    public LoginForm() {
        setTitle("Login Strife Forge");
        setSize(350, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        panel.add(new JLabel("Username:")); panel.add(txtUsername);
        panel.add(new JLabel("Password:")); panel.add(txtPassword);
        panel.add(new JLabel()); panel.add(btnLogin);

        add(panel);
    }
}