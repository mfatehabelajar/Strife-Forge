package strifeforge.view;

import javax.swing.*;
import java.awt.*;

public class DashboardForm extends JFrame {
    public JButton btnMember = new JButton("Manajemen Member");
    public JButton btnPaket = new JButton("Manajemen Paket");
    public JButton btnTransaksi = new JButton("Transaksi & Pembayaran");
    public JButton btnAbsensi = new JButton("Absensi Kunjungan");
    public JButton btnJadwal = new JButton("Jadwal Kelas"); // 1. Tambah deklarasi tombol Jadwal
    public JButton btnLogout = new JButton("Logout");

    public JLabel lblInfo = new JLabel("Selamat Datang di Dashboard Strife Forge Gym");

    public DashboardForm() {
        setTitle("Dashboard Gym");
        setSize(400, 450); // Tinggi frame ditambah sedikit agar 6 tombol tidak terlalu sempit
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Header
        lblInfo.setHorizontalAlignment(SwingConstants.CENTER);
        lblInfo.setFont(new Font("Arial", Font.BOLD, 14));
        add(lblInfo, BorderLayout.NORTH);

        // Menu Tombol Tengah (Ubah dari 5 baris jadi 6 baris)
        JPanel pMenu = new JPanel(new GridLayout(6, 1, 10, 10)); 
        pMenu.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));
        
        pMenu.add(btnMember);
        pMenu.add(btnPaket);
        pMenu.add(btnTransaksi);
        pMenu.add(btnAbsensi);
        pMenu.add(btnJadwal); // 2. Masukkan tombol Jadwal di atas tombol Logout
        pMenu.add(btnLogout);
        
        add(pMenu, BorderLayout.CENTER);
    }
}