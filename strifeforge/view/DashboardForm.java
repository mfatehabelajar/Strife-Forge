package strifeforge.view;

import javax.swing.*;
import java.awt.*;

public class DashboardForm extends javax.swing.JFrame {

    public DashboardForm() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Strife Forge Gym - Dashboard");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());
        JLabel lblWelcome = new JLabel("Selamat Datang di Dashboard Strife Forge", SwingConstants.CENTER);
        lblWelcome.setFont(new Font("Segoe UI", Font.BOLD, 18));
        panel.add(lblWelcome, BorderLayout.CENTER);

        add(panel);
    }
}