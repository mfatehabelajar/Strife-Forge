package strifeforge.view;

import javax.swing.*;
import java.awt.*;

public class DashboardForm extends JFrame {
    public JButton btnMember = new JButton("Manajemen Member");
    public JButton btnPaket = new JButton("Manajemen Paket");
    public JButton btnTransaksi = new JButton("Transaksi & Pembayaran");
    public JButton btnAbsensi = new JButton("Absensi Kunjungan");
    public JButton btnLogout = new JButton("Logout");

    public JLabel lblInfo = new JLabel("Selamat Datang di Dashboard Strife Forge Gym");

    public DashboardForm() {
        setTitle("Dashboard Gym");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Header
        lblInfo.setHorizontalAlignment(SwingConstants.CENTER);
        lblInfo.setFont(new Font("Arial", Font.BOLD, 14));
        add(lblInfo, BorderLayout.NORTH);

        // Menu Tombol Tengah
        JPanel pMenu = new JPanel(new GridLayout(5, 1, 10, 10));
        pMenu.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));
        
        pMenu.add(btnMember);
        pMenu.add(btnPaket);
        pMenu.add(btnTransaksi);
        pMenu.add(btnAbsensi);
        pMenu.add(btnLogout);
        
        add(pMenu, BorderLayout.CENTER);
    }
}